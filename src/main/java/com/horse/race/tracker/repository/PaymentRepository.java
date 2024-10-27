package com.horse.race.tracker.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.horse.race.tracker.tables.PaymentInfo;

public interface PaymentRepository extends CrudRepository<PaymentInfo, Integer> {	

	@Query(value = "SELECT * FROM PaymentInfo p WHERE p.User_ID = :id", nativeQuery = true)
	PaymentInfo findByUserId(long id);	
}
