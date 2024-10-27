package com.horse.race.tracker.models;

public class BetInfoRequest {
	
	private int userId;
	private int horseId;
	private double betAmount;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHorseId() {
		return horseId;
	}
	public void setHorseId(int horseId) {
		this.horseId = horseId;
	}
	public double getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}

}
