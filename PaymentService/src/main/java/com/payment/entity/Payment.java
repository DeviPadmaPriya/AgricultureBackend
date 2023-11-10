package com.payment.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="payment")
public class Payment {
	@Id
	private String paymentid;
	private String paymentMode;
	private String cvv;
	private String userid;
	private String orderid;
	private String cardHolderName;
	private String cardNumber;
	private Date expiryDate;
	private double totalCost;
	
	
	public Payment(String paymentid, String paymentMode, String cvv, String userid, String orderid,
			String cardHolderName, String cardNumber, Date expiryDate, double totalCost) {
		super();
		this.paymentid = paymentid;
		this.paymentMode = paymentMode;
		this.cvv = cvv;
		this.userid = userid;
		this.orderid = orderid;
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.totalCost = totalCost;
	}


	public String getPaymentid() {
		return paymentid;
	}


	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String getCardHolderName() {
		return cardHolderName;
	}


	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
	

}
