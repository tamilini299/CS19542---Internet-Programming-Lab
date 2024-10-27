package com.horse.race.tracker.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.horse.race.tracker.tables.HorseInfo;

public interface HorseRepository extends CrudRepository<HorseInfo, Integer> {

	 ArrayList<HorseInfo> findAll();
}
