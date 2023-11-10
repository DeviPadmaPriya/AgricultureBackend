package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.exception.CartNotFoundException;
import com.order.exception.CropNotFoundException;
import com.order.exception.CustomErrorResponse;
import com.order.exception.OrderNotFoundException;
import com.order.exception.UserNotFoundException;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;


@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
	

	
	@Autowired
	private OrderService ordServ;
	

	
	@PostMapping("/create/userid/{userId}/cartid/{cartId}")
	public ResponseEntity<?> createOrder(@PathVariable String userId, @PathVariable String cartId, @RequestBody Order order) {
		  try {
		        order.setUserid(userId);
		        order.setCartid(cartId);

		        Order createdOrder = ordServ.createOrder(order);
		        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
		    } catch (RuntimeException e) {
		        CustomErrorResponse errorResponse = new CustomErrorResponse(e.getMessage());
		        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		    }
	}
	
	@GetMapping("/ordersByUserId/{userid}")
	public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable String userid) {
	    List<Order> orders = ordServ.getOrdersByUserid(userid);
	    return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	 @GetMapping("/getAll")
	    public ResponseEntity<List<Order>> getAllOrders() {
	        List<Order> orders = ordServ.getAllOrders();
	        return new ResponseEntity<>(orders, HttpStatus.OK);
	    }
	 
	 @GetMapping("/getById/{orderid}")
	  public ResponseEntity<Object> getOrderId(@PathVariable String orderid) throws OrderNotFoundException {
	      try {
	          Order order = ordServ.getOrderId(orderid);
	          return new ResponseEntity<>(order, HttpStatus.OK);
	      } catch (CartNotFoundException ex) {
	          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart not found for userid: " + orderid);
	      }
	  }
	
	@DeleteMapping("/delete/orderid/{orderId}")
	public ResponseEntity<?> deleteOrder( @PathVariable String orderId) {
	    try {
	        // Call a service method to delete the order
	        ordServ.deleteOrder(orderId);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    } catch (RuntimeException e) {
	        CustomErrorResponse errorResponse = new CustomErrorResponse(e.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/add")
//	@CircuitBreaker(name = "ORDER")
//	 public ResponseEntity<OrderResponse> createOrder(@RequestBody Order order) {
//       OrderResponse response = ordServ.createOrder(order);
//
//        if ("Crop Not Found".equals(response.getMessage())) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//	public ResponseEntity<String> createOrder(@RequestBody Order order) {
//		return new ResponseEntity<>(ordServ.createOrder(order),HttpStatus.CREATED);
//		
//		
//	}
}
