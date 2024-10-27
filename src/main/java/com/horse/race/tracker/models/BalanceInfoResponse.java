package com.horse.race.tracker.models;

public class BalanceInfoResponse {
	
	private long userId;
	private String errorMessage;
	private double balance;

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getUserId() {
	   return userId;
	}	
	public void setUserId(long userId) {
	   this.userId = userId;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
