package com.horse.race.tracker.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import com.horse.race.tracker.models.UserBalance;
import com.horse.race.tracker.repository.CustomRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class CustomServiceImpl implements CustomRepository {

	@PersistenceContext
	private EntityManager emManager;

	@Override
	public List<UserBalance> getUserBalance() {
		
		TypedQuery<UserBalance> query = emManager.createQuery("SELECT u.firstName, u.Id userId, p.balanace FROM UserInfo u JOIN PaymentInfo p ON u.Id = p.userId", UserBalance.class);
       	List<UserBalance> uBalancelist =  query.getResultList();
		
		return uBalancelist;
	}
}
