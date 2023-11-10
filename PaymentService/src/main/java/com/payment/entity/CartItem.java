package com.payment.entity;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	 private String cropid;
     private String cropName;
     private int quantity;
     private double totalprice;
     

	






//	public String getCropid() {
//		return cropid;
//	}
//
//
//
//	public void setCropid(String cropid) {
//		this.cropid = cropid;
//	}



	
	

	@Override
	public int hashCode() {
		return Objects.hash(cropName, totalprice, quantity);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return Objects.equals(cropName, other.cropName)
				&& Double.doubleToLongBits(totalprice) == Double.doubleToLongBits(other.totalprice) && quantity == other.quantity;
	}



	
	
     
     
}
