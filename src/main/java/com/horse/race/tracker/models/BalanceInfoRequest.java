package com.horse.race.tracker.models;

public class BalanceInfoRequest {

	private long userId;
	private double amount;

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
