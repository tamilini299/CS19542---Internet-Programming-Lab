package com.horse.race.tracker.models;

import java.util.List;

public class UserBalanceResponse {

	private List<UserPaymentInfo> userBalanceList;
	public List<UserPaymentInfo> getUserBalanceList() {
		return userBalanceList;
	}

	public void setUserBalanceList(List<UserPaymentInfo> userBalanceList) {
		this.userBalanceList = userBalanceList;
	}

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}