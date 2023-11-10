package com.agriculture.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection="Crop")
public class Crop {
	
	@Id
	private String cropid= UUID.randomUUID().toString();
	private String cropName;
	private String cropType;
	private int quantity;
	private double price;
	private String cropLocation;
	private String image;
	
	public Crop(String cropid, String cropName, String cropType, int quantity, double price, String cropLocation,String image) {
		super();
		this.cropid = cropid;
		this.cropName = cropName;
		this.cropType = cropType;
		this.quantity = quantity;
		this.price = price;
		this.cropLocation = cropLocation;
		this.image=image;
	}

	public Crop() {
		
	}
	
	/*potato---
	 * https://plantix.net/en/library/assets/custom/crop-images/potato.jpeg
	 * rice------
	 * https://m.economictimes.com/thumb/msid-90396410,width-1200,height-900,resizemode-4,imgsize-153676/adani-wilmar-rice.jpg
	 * peanut-------
	 * https://images.healthshots.com/healthshots/en/uploads/2021/12/30131524/peanuts-bowl-1600x900.jpg
	 * apple------------
	 * https://img.pikbest.com/origin/09/36/15/47EpIkbEsT58G.jpg!w700wp
	 * guava-------
	 * https://previews.123rf.com/images/lekcha/lekcha1608/lekcha160800086/62965354-guava-tropical-fruit-in-wicker-basket-on-the-white-background.jpg
	 * srawberry----------
	 * https://m.economictimes.com/thumb/msid-102281194,width-1200,height-900,resizemode-4,imgsize-73862/strawberries_istock.jpg
	 
	 *banana-----------
	 *https://www.forbesindia.com/media/images/2022/Sep/img_193773_banana.jpg 
	 * */
	
}
