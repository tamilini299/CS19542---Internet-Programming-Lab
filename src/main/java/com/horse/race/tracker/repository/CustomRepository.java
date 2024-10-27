package com.horse.race.tracker.repository;

import java.util.List;

import com.horse.race.tracker.models.UserBalance;

public interface CustomRepository {

	public List<UserBalance> getUserBalance();
}
