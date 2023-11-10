package com.cart.service;

import java.util.List;

import javax.naming.InsufficientResourcesException;

import com.cart.entity.Cart;
import com.cart.entity.CartItem;
import com.cart.exception.CartNotFoundException;
import com.cart.exception.CropNotFoundException;

public interface ICartService {
	
	  public Cart addCart(CartItem cartitem, String userid, String cropid) ;
	  public Cart getCartByUserId(String userid);

	  public String deleteCart(String cartid);
	  public Cart updateCart(String id, Cart cart);
		public void removeCartItem(String cartId, String cropId);
		public Cart getCartId(String cartid);
		

}
























//
//public Cart addCart(Long userid,Cart cart){
//	  
//    double totalCost = calculateTotalCost(cart.getCartItems());
//    if (!userExists(userid)) {
//  	   
//  	    throw new DealerNotFoundException("User not found: ");
//  	}
//
//  	for (CartItem cartItem : cart.getCartItems()) {
//  	    if (!cropExists(cartItem.getCropName())) {
//  	       
//  	        throw new  CropNotFoundException("Crop not found for  " + cartItem.getCropName());
//  	    }
//  	}
//
//  	cart.setTotalCost(totalCost);
//  	cart.setUserid(userid);
//  	Cart savedCart = cartRepo.save(cart);
//
//  	return savedCart;