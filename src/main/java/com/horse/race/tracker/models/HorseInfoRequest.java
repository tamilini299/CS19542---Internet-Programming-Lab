package com.horse.race.tracker.models;

public class HorseInfoRequest {

	private String horseName;
	private String horseOwner;
	private int userId;
	private String firstName;
	
	public String getHorseName() {
		return horseName;
	}
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	public String getHorseOwner() {
		return horseOwner;
	}
	public void setHorseOwner(String horseOwner) {
		this.horseOwner = horseOwner;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
