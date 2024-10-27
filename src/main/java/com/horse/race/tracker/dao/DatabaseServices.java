package com.horse.race.tracker.dao;

import com.horse.race.tracker.models.UserBalanceRequest;
import com.horse.race.tracker.models.UserBalanceResponse;

import java.util.ArrayList;

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
import com.horse.race.tracker.tables.CardInfo;
import com.horse.race.tracker.tables.HorseInfo;
import com.horse.race.tracker.tables.UserInfo;

public interface DatabaseServices {
	
	/*** Create ***/
	public UserInfoResponse createAccount(UserInfo userInfo);
	public CardInfoResponse createCardInfo(CardInfo cardInfo);
	public HorseInfoResponse addHorseInfo(HorseInfo horseInfo);
	
	/** Update ***/
	public BetInfoResponse playBet(BetInfoRequest betInfoReq);
	public PaymentInfoResponse updateBalance(PaymentInfoRequest payInfoReq);
	
	/** Validate ***/
	public BalanceInfoResponse hasBalance(BalanceInfoRequest balInfoReq);
	public LoginInfoResponse authenticate(LoginInfoRequest loginInfoReq);
	
	/** Get ***/
	public UserBalanceResponse getUserBalanceList(UserBalanceRequest uBalanceReq);
	public ArrayList<HorseInfo> getHorseInfo();
	public CardInfo getCardInfo(int userId);
	public BalanceInfoResponse getBalanceInfo(int userId);
	public UserInfo getUserById(int userId);

}