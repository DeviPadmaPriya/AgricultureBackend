package com.order.entity;

import java.util.ArrayList;
import java.util.List;

public class Crop {

	private String cropid;
	private String cropName;
	private String cropType;
	private int quantity;
	private double price;
	private double amount;
	private String Location;
	
	
	
	
	 
	public Crop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Crop(String cropid, String cropName, String cropType, int quantity, double price, double amount,
			String location) {
		super();
		this.cropid = cropid;
		this.cropName = cropName;
		this.cropType = cropType;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
		Location = location;
	}
	public String getCropid() {
		return cropid;
	}
	public void setCropid(String cropid) {
		this.cropid = cropid;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	
}
