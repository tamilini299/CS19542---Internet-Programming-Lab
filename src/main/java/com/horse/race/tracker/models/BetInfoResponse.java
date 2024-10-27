package com.horse.race.tracker.models;

public class BetInfoResponse {

	private long userId;
	private long horseId;
	private String errorMessage;
	private long wonHorse;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getHorseId() {
		return horseId;
	}
	public void setHorseId(long horseId) {
		this.horseId = horseId;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public long getWonHorse() {
		return wonHorse;
	}
	public void setWonHorse(long wonHorse) {
		this.wonHorse = wonHorse;
	}
}
