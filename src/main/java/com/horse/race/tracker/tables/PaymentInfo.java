package com.horse.race.tracker.tables;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PaymentInfo")
public class PaymentInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private Integer Id;

	@Column(name = "User_Id", unique=true)
	private Long userId;
	
	@Column(name = "Available_Balance")
	private Double balanace;
	
	@CreationTimestamp
    @Column(name = "Creation_Time")
    private Date createdTime;

	@UpdateTimestamp
    @Column(name = "Last_Updated")
    private LocalDateTime updatedTime;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double getBalanace() {
		return balanace;
	}

	public void setBalanace(Double balanace) {
		this.balanace = balanace;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

}
