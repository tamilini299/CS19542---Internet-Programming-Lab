package com.horse.race.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.horse.race.tracker.models.UserPaymentInfo;
import com.horse.race.tracker.tables.UserInfo;

public interface UserRepository extends CrudRepository<UserInfo, Integer> {
	
	
	@Query(value = "SELECT * FROM UserInfo u WHERE u.user_name = :userName", nativeQuery = true)
	UserInfo getUser(String userName);

	@Query(value = "SELECT new com.horse.race.tracker.models.UserPaymentInfo(u.firstName, p.userId, p.balanace) FROM UserInfo u JOIN PaymentInfo p ON u.Id = p.userId")
	List<UserPaymentInfo> getUserBalance();
	
	@Query(value = "SELECT * FROM UserInfo u WHERE u.id = :id", nativeQuery = true)
	UserInfo getUserById(int id);


}