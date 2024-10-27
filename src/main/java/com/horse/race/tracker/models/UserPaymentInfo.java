package com.horse.race.tracker.models;

public class UserPaymentInfo {
	
	private String firstName;
	private long userId;
	private double balance;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public UserPaymentInfo(String firstName, long userId, double balance) {
		super();
		this.firstName = firstName;
		this.userId = userId;
		this.balance = balance;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
