package com.horse.race.tracker.models;

public class CardInfoRequest {	

	private long Id;
	private long userId;
	private String cardNumber;
	private String cardOwner;
	private String cardExpiry;
	private int cardCVV;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardOwner() {
		return cardOwner;
	}
	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public int getCardCVV() {
		return cardCVV;
	}
	public void setCardCVV(int cardCVV) {
		this.cardCVV = cardCVV;
	}
	

}
