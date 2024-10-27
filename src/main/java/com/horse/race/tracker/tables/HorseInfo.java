package com.horse.race.tracker.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HorseInfo")
public class HorseInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private Integer Id;

	@Column(name = "Horse_Name", unique=true)
	private String horseName;
	
	@Column(name = "Horse_Owner")
	private String horseOwner;
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

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

}
