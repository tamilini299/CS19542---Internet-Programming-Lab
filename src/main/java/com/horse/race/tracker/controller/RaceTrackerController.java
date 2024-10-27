package com.horse.race.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.horse.race.tracker.constants.RaceTrackerConstants;
import com.horse.race.tracker.dao.DatabaseServices;
import com.horse.race.tracker.models.UserBalanceRequest;
import com.horse.race.tracker.models.UserBalanceResponse;
import com.horse.race.tracker.models.BalanceInfoRequest;
import com.horse.race.tracker.models.BalanceInfoResponse;
import com.horse.race.tracker.models.BetInfoRequest;
import com.horse.race.tracker.models.BetInfoResponse;
import com.horse.race.tracker.models.CardInfoResponse;
import com.horse.race.tracker.models.HorseInfoRequest;
import com.horse.race.tracker.models.LoginInfoRequest;
import com.horse.race.tracker.models.LoginInfoResponse;
import com.horse.race.tracker.models.PaymentInfoRequest;
import com.horse.race.tracker.models.PaymentInfoResponse;
import com.horse.race.tracker.models.UserInfoResponse;
import com.horse.race.tracker.tables.CardInfo;
import com.horse.race.tracker.tables.HorseInfo;
import com.horse.race.tracker.tables.UserInfo;

@Controller
public class RaceTrackerController {
	
	@Autowired
	DatabaseServices databaseServices;
	
	@GetMapping
	public String getHome() { return "Login"; }
	
	@GetMapping("/get/regform")
	public String getRegForm() { return "RegUser";	}
	
	@PostMapping(value = "/user/login")
	public String authenticate(@ModelAttribute("userForm") LoginInfoRequest loginInfoReq, Model respObj) {
	
		String pageName = "HorseInfo";
		LoginInfoResponse loginInfoRes = databaseServices.authenticate(loginInfoReq);
		
		if(loginInfoRes.getErrorMessage() == null) {
			respObj.addAttribute("horseInfo", databaseServices.getHorseInfo());
			respObj.addAttribute("userInfo", loginInfoRes);
		}else {
			respObj.addAttribute("errorInfo", loginInfoRes.getErrorMessage());
			pageName = "Login";
		}		

		return pageName;
	}
	
	@PostMapping("/get/horse")
	public String getUser(@RequestParam("userId") int userId, Model userObj) {
		
		UserInfo uObj = databaseServices.getUserById(userId);
		
		UserInfoResponse userInfo = new UserInfoResponse();
		userInfo.setUserId(uObj.getId());
		userInfo.setFirstName(uObj.getFirstName());
		
		userObj.addAttribute("userInfo", userInfo);
		userObj.addAttribute("horseInfo", databaseServices.getHorseInfo());
		
		return "HorseInfo";
	}

	@PostMapping("/register/user")
	public String createAccount(@ModelAttribute("regForm") UserInfo userInfoReq, Model userObj) {
	    
		String pageName = "RegUser";
		
		UserInfoResponse userInfo = databaseServices.createAccount(userInfoReq);
		if(userInfo.getErrorMessage() == null) {
			userObj.addAttribute("userInfo", userInfo);
			pageName = "RegCard";
		}else {
			userObj.addAttribute("errorInfo", userInfo.getErrorMessage());
		}
		
		return pageName;

	}	
	
	@PostMapping("/register/card")
	public String createCardInfo(@ModelAttribute("cardForm") CardInfo cardInfo, Model cardObj) {

		String pageName = "RegCard";

		CardInfoResponse cInfo = databaseServices.createCardInfo(cardInfo);
		if(cInfo.getErrorMessage() == null) {
			pageName = "RegSuccess";
			
		}else {
			cardObj.addAttribute("errorInfo", cInfo.getErrorMessage());
			
			UserInfoResponse uInfo = new UserInfoResponse();
			uInfo.setUserId(cardInfo.getUserId());
			
			cardObj.addAttribute("userInfo", uInfo);

		}

		return pageName;

	}
	
	@PostMapping("/get/card")
	public String getCardInfo(@RequestParam("userId") int userId, Model cardObj) {
		
	    CardInfo cardInfo = databaseServices.getCardInfo(userId);
	    
	    if( cardInfo != null) {
	    	
			UserInfo uObj = databaseServices.getUserById(userId);
			UserInfoResponse userInfo = new UserInfoResponse();
			userInfo.setUserId(userId);			
			userInfo.setFirstName(uObj.getFirstName());
	
		    cardObj.addAttribute("cardInfo", cardInfo);
		    cardObj.addAttribute("userInfo", userInfo);
	    }else {
	    	cardObj.addAttribute("errorInfo", RaceTrackerConstants.CARD_INFO_UNAVAILABLE);
	    }
	    
	    return "MakePayment";
	}
	
	@PostMapping("/list/horse")
	public String listHorseInfo(@ModelAttribute("horseForm") HorseInfoRequest horseInfoReg, Model horseObj) {	

		UserInfoResponse userInfo = new UserInfoResponse();
		userInfo.setUserId(horseInfoReg.getUserId());			
		userInfo.setFirstName(horseInfoReg.getFirstName());
		
		horseObj.addAttribute("userInfo", userInfo);

	    return "AddHorse";
	}


	@PostMapping("/register/horse")
	public String createHorseInfo(@ModelAttribute("horseForm") HorseInfoRequest horseInfoReg, Model horseObj) {	
		
		HorseInfo horseInfo = new HorseInfo();
		horseInfo.setHorseName(horseInfoReg.getHorseName());
		horseInfo.setHorseOwner(horseInfoReg.getHorseOwner());
		
		UserInfoResponse userInfo = new UserInfoResponse();
		userInfo.setUserId(horseInfoReg.getUserId());			
		userInfo.setFirstName(horseInfoReg.getFirstName());

		horseObj.addAttribute("userInfo", userInfo);
		horseObj.addAttribute("errorInfo", databaseServices.addHorseInfo(horseInfo).getErrorMessage());

	    return "AddHorse";
	}
	
	@PostMapping(value = "/balance/get/all")
	public String getUserBalanceList(@ModelAttribute("navForm") UserBalanceRequest uBalanceInfo, Model cardObj) {

	    UserInfoResponse userInfo = new UserInfoResponse();
		userInfo.setUserId(uBalanceInfo.getUserId());
		userInfo.setFirstName(uBalanceInfo.getFirstName());

		UserBalanceResponse uBalResp = databaseServices.getUserBalanceList(uBalanceInfo);
		
	    cardObj.addAttribute("userInfo", userInfo);
	    cardObj.addAttribute("summaryInfo", uBalResp.getUserBalanceList());
	    cardObj.addAttribute("errorInfo", uBalResp.getErrorMessage());
	    
	    return "BalanceSummary";
	}
	
	@PostMapping("/get/balance")
	public String getBalanceInfo(@RequestParam("userId") int userId, Model cardObj) {

	    cardObj.addAttribute("balanceInfo", databaseServices.getBalanceInfo(userId));
	    
	    UserInfo uObj = databaseServices.getUserById(userId);
	    
	    UserInfoResponse userInfo = new UserInfoResponse();
		userInfo.setUserId(userId);
		userInfo.setFirstName(uObj.getFirstName());

	    cardObj.addAttribute("userInfo", userInfo);

	    return "BalanceInfo";
	}

	@PostMapping("/balance/update")
	public String updateBalance(@ModelAttribute("cardForm") PaymentInfoRequest payInfoReq, Model cardObj) {
				
		PaymentInfoResponse payInfo = databaseServices.updateBalance(payInfoReq);
		cardObj.addAttribute("errorInfo", payInfo.getErrorMessage());
	
	    UserInfo uObj = databaseServices.getUserById((int)payInfoReq.getUserId());
	    
	    UserInfoResponse userInfo = new UserInfoResponse();
		userInfo.setUserId((int)uObj.getId());
		userInfo.setFirstName(uObj.getFirstName());

	    cardObj.addAttribute("userInfo", userInfo);
	    cardObj.addAttribute("cardInfo", payInfoReq);
	    
	    return "MakePayment";
	}
	
	@GetMapping(value = "/balance/check", produces = "application/json")
	public @ResponseBody BalanceInfoResponse hasBalance() {
		
		BalanceInfoRequest balInfoReq = new BalanceInfoRequest();
		balInfoReq.setUserId(1);
		balInfoReq.setAmount(234.56);

	    return databaseServices.hasBalance(balInfoReq);
	}
	
	@PostMapping("/play/bet")
	public String playBet(@ModelAttribute("betInfo") BetInfoRequest betInfoReq, Model betObj) {

		BetInfoResponse bInfo = databaseServices.playBet(betInfoReq);
	    
		UserInfo uObj = databaseServices.getUserById(betInfoReq.getUserId());
		
		UserInfoResponse userInfo = new UserInfoResponse();
		userInfo.setUserId(uObj.getId());
		userInfo.setFirstName(uObj.getFirstName());
		
		betObj.addAttribute("userInfo", userInfo);
		betObj.addAttribute("horseInfo", databaseServices.getHorseInfo());
		betObj.addAttribute("errorInfo", bInfo.getErrorMessage());
		betObj.addAttribute("betInfo", bInfo);
		
		return "HorseInfo";

	}
}
