package com.payment.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

//@Document(collection="order")

public class Order {
//	@Id
	private String orderid;
	private String userid;
	private String uName;
	private String cartid;
//	private Address address;
	private Date orderdate;
	private double totalCost;
	 private List<CartItem> cartItems;
	
	
	public Order() {
		super();
	}



	



	public Order(String orderid, String userid, String uName, String cartid, Date orderdate,
			double totalCost) {
		super();
		this.orderid = orderid;
		this.userid = userid;
	this.uName = uName;
		this.cartid = cartid;
		
		this.orderdate = orderdate;
		this.totalCost = totalCost;
	}






	public String getuName() {
		return uName;
	}







	public void setuName(String uName) {
		this.uName = uName;
	}







	public List<CartItem> getCartItems() {
		return cartItems;
	}







	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}







	public String getOrderid() {
		return orderid;
	}



	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getCartid() {
		return cartid;
	}



	public void setCartid(String cartid) {
		this.cartid = cartid;
	}







	



	public Date getOrderdate() {
		return orderdate;
	}



	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}



	public double getTotalCost() {
		return totalCost;
	}



	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
	
	
	

}
