package com.horse.race.tracker.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.horse.race.tracker.tables.CardInfo;

public interface CardRepository extends CrudRepository<CardInfo, Long> {

	@Query(value = "SELECT * FROM CardInfo c WHERE c.User_ID = :userId", nativeQuery = true)
	CardInfo findCardByUserId(int userId);
}
