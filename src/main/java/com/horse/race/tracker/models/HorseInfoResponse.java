package com.horse.race.tracker.models;

public class HorseInfoResponse {

	private long horseId;
	private String errorMessage;
	
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
}
