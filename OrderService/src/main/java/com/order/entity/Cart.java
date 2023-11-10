package com.order.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection="cart")
public class Cart {
//	@Id
	private String cartid;
	private String userid;
    private double totalCost;
    
    private List<CartItem> cartItems=new ArrayList<>();
    
   



//	public Cart(String cartid, List<CartItem> cartItems) {
//		super();
//		this.cartid = cartid;
//		this.cartItems = cartItems;
//		 calculateTotalPrice();
//	}

	



//	private void calculateTotalPrice() {
//        this.totalCost = cartItems.stream().mapToDouble(CartItem::getPrice).sum();
//
//	}







//	public Cart(long cartid, long userid, double totalCost, List<CartItem> cartItems) {
//		super();
//		this.cartid = cartid;
//		this.userid = userid;
//		this.totalCost = totalCost;
//		this.cartItems = cartItems;
//	}




	






	


	

   
	
	
	

}
