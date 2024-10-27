package com.horse.race.tracker.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.horse.race.tracker.constants.RaceTrackerConstants;
import com.horse.race.tracker.models.UserBalanceRequest;
import com.horse.race.tracker.models.UserBalanceResponse;
import com.horse.race.tracker.models.BalanceInfoRequest;
import com.horse.race.tracker.models.BalanceInfoResponse;
import com.horse.race.tracker.models.BetInfoRequest;
import com.horse.race.tracker.models.BetInfoResponse;
import com.horse.race.tracker.models.CardInfoResponse;
import com.horse.race.tracker.models.HorseInfoResponse;
import com.horse.race.tracker.models.LoginInfoRequest;
import com.horse.race.tracker.models.LoginInfoResponse;
import com.horse.race.tracker.models.PaymentInfoRequest;
import com.horse.race.tracker.models.PaymentInfoResponse;
import com.horse.race.tracker.models.UserInfoResponse;
import com.horse.race.tracker.models.UserPaymentInfo;
import com.horse.race.tracker.repository.CardRepository;
import com.horse.race.tracker.repository.HorseRepository;
import com.horse.race.tracker.repository.PaymentRepository;
import com.horse.race.tracker.repository.UserRepository;
import com.horse.race.tracker.tables.CardInfo;
import com.horse.race.tracker.tables.HorseInfo;
import com.horse.race.tracker.tables.PaymentInfo;
import com.horse.race.tracker.tables.UserInfo;

@Component
public class DatabaseServicesImpl implements DatabaseServices{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private HorseRepository horseRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public UserInfoResponse createAccount(UserInfo userInfo) {

		UserInfoResponse uInfoRes = new UserInfoResponse();
		
		try {
			userInfo = userRepository.save(userInfo);
			
			uInfoRes.setFirstName(userInfo.getFirstName());
			uInfoRes.setUserId(userInfo.getId());
			
		}catch(DataIntegrityViolationException sqlExe){
			uInfoRes.setErrorMessage(RaceTrackerConstants.DUPLICATE_USER_NAME);
		}catch(Exception e) {
			uInfoRes.setErrorMessage(RaceTrackerConstants.DB_FETCH_FAILED);
			e.printStackTrace();
		}		

		return uInfoRes;
	}
	
	
	@Override
	public UserInfo getUserById(int userId) {

		UserInfo userInfo = new UserInfo();
		
		try {
			userInfo = userRepository.getUserById(userId);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return userInfo;
	}
	
	@Override
	public CardInfoResponse createCardInfo(CardInfo cardInfo) {
				
		CardInfoResponse cardInfoRes = new CardInfoResponse();		
		try {
			cardInfo = cardRepository.save(cardInfo);
		}catch(DataIntegrityViolationException sqlExe){
			cardInfoRes.setErrorMessage(RaceTrackerConstants.ANOTHER_CARD_AVAILABLE);
		}catch(Exception e) {
			cardInfoRes.setErrorMessage(RaceTrackerConstants.DB_FETCH_FAILED);
			e.printStackTrace();
		}

	    return cardInfoRes;
	}
	
	@Override
	public CardInfo getCardInfo(int userId) {
				
		CardInfo cardInfo = new CardInfo();		
		try {			
			cardInfo = cardRepository.findCardByUserId(userId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	    return cardInfo;
	}
	
	@Override
	public HorseInfoResponse addHorseInfo(HorseInfo horseInfo) {

		HorseInfoResponse hInfoResp = new HorseInfoResponse();		
		try {
			horseInfo = horseRepository.save(horseInfo);
			hInfoResp.setErrorMessage(RaceTrackerConstants.HORSE_ADDITION_SUCCESS);
		}catch(DataIntegrityViolationException sqlExe){
			hInfoResp.setErrorMessage(RaceTrackerConstants.DUPLICATE_HORSE_INFO);
		}catch(Exception e) {
			hInfoResp.setErrorMessage(RaceTrackerConstants.HORSE_ADDITION_FAILED);
			e.printStackTrace();
		}
		
		hInfoResp.setHorseId(horseInfo.getId());
		
	    return hInfoResp;
	}
	
	@Override
	public ArrayList<HorseInfo> getHorseInfo() {

		ArrayList<HorseInfo> hInfoResp = new ArrayList<HorseInfo>();		
		try {
			hInfoResp = horseRepository.findAll();
			/*Iterator<HorseInfo> iterator = hInfoResp.iterator();

			while(iterator.hasNext()) {
				HorseInfo element = iterator.next();
			    System.out.println( element.getHorseName() );
			}*/
		}catch(Exception e) {			
			e.printStackTrace();
		}
		
		//hInfoResp.setHorseId(horseInfo.getId());
		
	    return hInfoResp;
	}
	
	@Override
	public BalanceInfoResponse getBalanceInfo(int userId) {
		
		BalanceInfoResponse bInfoResp = new BalanceInfoResponse();

		PaymentInfo payInfo = paymentRepository.findByUserId(userId);
		if( payInfo != null ) {
			bInfoResp.setBalance(payInfo.getBalanace());
			bInfoResp.setUserId(payInfo.getUserId());
		}else {
			bInfoResp.setErrorMessage(RaceTrackerConstants.INVALID_USER_ID);
		}
		
	    return bInfoResp;
	}

	@Override
	public BetInfoResponse playBet(BetInfoRequest betInfoReq) {		

		BetInfoResponse bInfoResp = new BetInfoResponse();
		
		 PaymentInfo paymentInfo = paymentRepository.findByUserId(betInfoReq.getUserId());
		
		if( paymentInfo == null ) {
			bInfoResp.setErrorMessage(RaceTrackerConstants.NOT_AUTHORIZED);
			
		}else if( paymentInfo.getBalanace() < betInfoReq.getBetAmount()) {				
			bInfoResp.setErrorMessage(RaceTrackerConstants.NO_ADEQUATE_BALANCE);
			
		}else {
			
			ArrayList<HorseInfo> hInfoList = horseRepository.findAll();			
			int wonHorse = new Random().nextInt(hInfoList.size()) + 1;
	
			double newBalance = (wonHorse == betInfoReq.getHorseId()) ? 
					paymentInfo.getBalanace() + betInfoReq.getBetAmount() * 
												RaceTrackerConstants.BET_WIN_PROPORTION:
					paymentInfo.getBalanace() - betInfoReq.getBetAmount() * 
												RaceTrackerConstants.BET_LOSS_PROPORTION;
	
			paymentInfo.setBalanace(newBalance);
		
			try {
				paymentRepository.save(paymentInfo);
				
				bInfoResp.setUserId(betInfoReq.getUserId());
				bInfoResp.setHorseId(betInfoReq.getHorseId());
				bInfoResp.setWonHorse(wonHorse);
				
			}catch(Exception e) {
				bInfoResp.setErrorMessage(RaceTrackerConstants.DB_FETCH_FAILED);
			}
			
			if( wonHorse ==  betInfoReq.getHorseId()) {
				bInfoResp.setErrorMessage(RaceTrackerConstants.YOU_HAVE_WON);
			}else {
				bInfoResp.setErrorMessage(RaceTrackerConstants.YOU_HAVE_LOST);
			}
		}		
	
		return bInfoResp;
	}
	
	@Override
	public PaymentInfoResponse updateBalance(PaymentInfoRequest payInfoReq) {		

		PaymentInfoResponse payInfoResp = new PaymentInfoResponse();
		PaymentInfo payInfo = paymentRepository.findByUserId(payInfoReq.getUserId());
		
		if( payInfo != null ) {		
			payInfo.setBalanace(payInfo.getBalanace() + payInfoReq.getBalance());			
			
			try {
				paymentRepository.save(payInfo);
				payInfoResp.setUserId(payInfo.getUserId());
				payInfoResp.setErrorMessage(RaceTrackerConstants.BALANCE_UPDATE_SUCCESS);
				
			}catch(Exception e) {
				payInfoResp.setErrorMessage(RaceTrackerConstants.BALANCE_UPDATE_FAILURE);
			}
		}else {
			
			PaymentInfo pInfo = new PaymentInfo();
			pInfo.setBalanace(payInfoReq.getBalance());
			pInfo.setUserId(payInfoReq.getUserId());
			
			try {
				pInfo = paymentRepository.save(pInfo);				
				payInfoResp.setUserId(pInfo.getUserId());
				payInfoResp.setErrorMessage(RaceTrackerConstants.BALANCE_UPDATE_SUCCESS);
				
			}catch(Exception e) {
				payInfoResp.setErrorMessage(RaceTrackerConstants.BALANCE_UPDATE_FAILURE);
			}
			
		}
		
		return payInfoResp;
		
	}
	

	@Override
	public BalanceInfoResponse hasBalance(BalanceInfoRequest balInfoReq) {		
		
		BalanceInfoResponse balInfoResp = new BalanceInfoResponse();
		
		PaymentInfo paymentInfo = paymentRepository.findByUserId(balInfoReq.getUserId());		
		if( paymentInfo != null && paymentInfo.getBalanace() > balInfoReq.getAmount()) {
			balInfoResp.setUserId(paymentInfo.getUserId());
		}else {
			balInfoResp.setErrorMessage(RaceTrackerConstants.NO_ADEQUATE_BALANCE);
		}
		
		return balInfoResp;

	}
	
	@Override
	public LoginInfoResponse authenticate(LoginInfoRequest loginInfoReq) {
	
		LoginInfoResponse loginInfoRes = new LoginInfoResponse();
		
		UserInfo userInfo = userRepository.getUser(loginInfoReq.getUserName());
		
		if( userInfo != null && 
			userInfo.getUserName().equals(loginInfoReq.getUserName()) &&
			userInfo.getPassword().equals(loginInfoReq.getPassword())) {
			
			loginInfoRes.setFirstName(userInfo.getFirstName());
			loginInfoRes.setId(userInfo.getId());

		}else {
			loginInfoRes.setErrorMessage(RaceTrackerConstants.AUTH_FAILED);
		}
		
		return loginInfoRes;

	}

	@Override
	public UserBalanceResponse getUserBalanceList(UserBalanceRequest bInfoListReq) {

		UserBalanceResponse uBalanceResp = new UserBalanceResponse();
		
		if( !bInfoListReq.getAdminPass().equals(RaceTrackerConstants.ADMIN_PASSWORD)) {
			uBalanceResp.setErrorMessage(RaceTrackerConstants.NOT_AUTHORIZED);
			
		}else {
			List<UserPaymentInfo> uBalanceList = userRepository.getUserBalance();
			//List<UserBalance> uBalanceList = customServiceImpl.getUserBalance();
			if(uBalanceList == null) {
				uBalanceResp.setErrorMessage(RaceTrackerConstants.DB_FETCH_FAILED);
			}
			uBalanceResp.setUserBalanceList(uBalanceList);			
		}
		
		return uBalanceResp;
	}
}
