package com.horse.race.tracker.constants;

public class RaceTrackerConstants {

	// Number constants
	public static int BET_WIN_PROPORTION = 5;
	public static int BET_LOSS_PROPORTION = 1;

	// Common constants
	public static String DB_FETCH_FAILED 		= "Application error. Please try again later";
	public static String YOU_HAVE_WON      		= "Congratulations. Your horse has WON";
	public static String YOU_HAVE_LOST      	= "Better luck next time";
	
	// Horse constants
	public static String HORSE_ADDITION_FAILED 	= "Horse information update failed";
	public static String HORSE_ADDITION_SUCCESS = "Horse information added successfully";
	public static String DUPLICATE_HORSE_INFO 	= "Duplicate horse information provided";
	
	// User constants
	public static String ADMIN_PASSWORD 		= "admin";
	public static String INVALID_USER_ID 		= "Invalid user";
	public static String NOT_AUTHORIZED 		= "User not authorized";
	public static String AUTH_FAILED 			= "Invalid credentials";
	public static String DUPLICATE_USER_NAME 	= "Duplicate user names not allowed";
	
	// Card constants
	public static String ANOTHER_CARD_AVAILABLE = "Only one card allowed";
	public static String CARD_INFO_UNAVAILABLE 	= "Card information unavailabale";
	public static String BALANCE_UPDATE_SUCCESS = "Balance updated successfully";
	public static String NO_ADEQUATE_BALANCE 	= "Insufficient balance";
	public static String BALANCE_UPDATE_FAILURE = "Balance update failed";

}
