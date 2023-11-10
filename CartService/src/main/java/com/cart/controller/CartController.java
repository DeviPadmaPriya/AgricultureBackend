package com.cart.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.entity.Cart;
import com.cart.entity.CartItem;
import com.cart.exception.CartNotFoundException;
import com.cart.exception.CropNotFoundException;
import com.cart.exception.UserNotFoundException;
import com.cart.service.CartServiceImpl;


@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
	
	
	@Autowired
	private CartServiceImpl cartServ;
	

	  
	@PostMapping("/add/dealer/{userId}/crop/{cropId}")
	public ResponseEntity<Object> addToCart(@RequestBody CartItem item, @PathVariable String userId, @PathVariable String cropId){
//		
//		Cart c1 = cartServ.addCart(item, userId,cropId);
//		return new ResponseEntity<>(c1, HttpStatus.CREATED);
		try {
		    Cart c1 = cartServ.addCart(item, userId, cropId);
		    return new ResponseEntity<>(c1, HttpStatus.CREATED);
		} catch (UserNotFoundException ex) {
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		} catch (CropNotFoundException ex) {
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable String id, @RequestBody Cart cart){
		
		Cart upcart = cartServ.updateCart(id, cart);
		return new ResponseEntity<>(upcart, HttpStatus.CREATED);
	}
	
	@PostMapping("/checkout/{cartId}")
	public ResponseEntity<String> checkoutCart(@PathVariable String cartId, @RequestBody Cart cart) {
	    try {
	        cartServ.checkoutCart(cartId, cart);
	        return ResponseEntity.ok("Cart checked out successfully.");
	    } catch (CartNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	
	  @GetMapping("/getByUserId/{userid}")
	  public ResponseEntity<Object> getCartByUserId(@PathVariable String userid) throws UserNotFoundException {
	      try {
	          Cart cart = cartServ.getCartByUserId(userid);
	          return new ResponseEntity<>(cart, HttpStatus.OK);
	      } catch (UserNotFoundException ex) {
	          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart not found for userid: " + userid);
	      }
	  }
	  
	  @GetMapping("/getById/{cartid}")
	  public ResponseEntity<Object> getCartId(@PathVariable String cartid) throws CartNotFoundException {
	      try {
	          Cart cart = cartServ.getCartId(cartid);
	          return new ResponseEntity<>(cart, HttpStatus.OK);
	      } catch (CartNotFoundException ex) {
	          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart not found for cartid: " + cartid);
	      }
	  }
	  
	  @DeleteMapping("/removeCartItem/{cartId}/{cropId}")
	    public ResponseEntity<String> removeCartItem(@PathVariable String cartId,@PathVariable String cropId) {
	        try {
	            cartServ.removeCartItem(cartId, cropId);
	            return ResponseEntity.ok("Item removed successfully.");
	        } catch (CartNotFoundException | CropNotFoundException ex) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	        }
	    
	}
	  


	  
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteCart(@PathVariable String id) {
	        String result = cartServ.deleteCart(id);
	        if ("cart deleted".equals(result)) {
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	        }
	        
	    }

}



//@GetMapping("/getById/{id}")
//public ResponseEntity<Object> getCartById(@PathVariable String id) throws CartNotFoundException {
//    try {
//    	Cart cart = cartServ.getCartById(id);
//    	
//        return new ResponseEntity<>(cart, HttpStatus.OK);
//    } catch (CartNotFoundException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart not found for id: " + id);
//    }
//}

//@GetMapping("/all")
//public ResponseEntity<List<Cart>> getAllCarts() {
//    List<Cart> carts = cartServ.getAllCarts();
//    return ResponseEntity.ok(carts);
//}


//@DeleteMapping("/delete/{userid}")
//public ResponseEntity<Object> deleteCartItem(@PathVariable Long userid, @RequestParam("cropName")String cropName) {
//    try {
//        Cart updatedCart = cartServ.deleteCartItemByName(userid, cropName);
//        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
//    } catch (ResponseStatusException ex) {
//        return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
//    }
//}
//
//@GetMapping("/getAll")
//  public ResponseEntity<List<Cart>> getAllCarts() {
//      List<Cart> cart = cartServ.getAllCarts();
//      return new ResponseEntity<>(cart, HttpStatus.OK);
//  }