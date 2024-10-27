package com.horse.race.tracker.models;

public class LoginInfoResponse {	

	private long userId;
	private String firstName;	
	private String errorMessage;

	public long getUserId() {
	   return userId;
	}	
	public void setId(long userId) {
	   this.userId = userId;
	}	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
