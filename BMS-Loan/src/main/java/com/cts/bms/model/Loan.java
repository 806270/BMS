package com.cts.bms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "Loans")
public class Loan {
	
	@Id
    @Column(name = "username")
	private String userName;
	
	@Column(name = "loan_type")
	private String loanType;	

	@Column(name = "amount")
	private Long loanAmount;
	
	@Column(name = "Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private  Date dob;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "interest")
	private Integer RateofInterest;
	
	@Column(name = "duration")
	private Integer duration;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getRateofInterest() {
		return RateofInterest;
	}

	public void setRateofInterest(Integer rateofInterest) {
		RateofInterest = rateofInterest;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	
	

}
