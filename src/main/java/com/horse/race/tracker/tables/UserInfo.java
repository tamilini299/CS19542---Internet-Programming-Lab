package com.horse.race.tracker.tables;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserInfo")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "User_Name", unique=true)
	private String userName;

	@Column(name = "Password")
	private String password;
	
	@Column(name = "Mobile_Number")
	private Long mobileNum;
	
	@Column(name = "Email_Id")
	private String emailId;
	
	@CreationTimestamp
    @Column(name = "Creation_Time")
    private Date createdTime;

	@UpdateTimestamp
    @Column(name = "Last_Updated")
    private LocalDateTime updatedTime;
	
	@OneToMany (fetch = FetchType.LAZY)
	@JoinColumn (name = "PAY_KEY")//, referencedColumnName = "Id")
	private List<PaymentInfo> paymentInfo;
	
	public List<PaymentInfo> getUserBalanceList() {
		return paymentInfo;
	}
	public void setUserBalanceList(List<PaymentInfo> paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	
	public Integer getId() {
	   return id;
	}	
	public void setId(Integer id) {
	   this.id = id;
	}	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Long l) {
		this.mobileNum = l;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
