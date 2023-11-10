package com.order.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.entity.Cart;
import com.order.entity.CartItem;
import com.order.entity.Crop;
import com.order.entity.Order;
import com.order.entity.User;
import com.order.exception.CartNotFoundException;
import com.order.exception.CropNotFoundException;
import com.order.exception.OrderNotFoundException;
import com.order.exception.UserNotFoundException;
import com.order.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	OrderRepository ordRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String CROP_MICROSERVICE_URL = "http://CROP/crop/";
    private static final String USER_MICROSERVICE_URL = "http://USERSERVICE/user/";
	private static final String CART_MICROSERVICE_URL="http://CART/cart/";
    
    
	 @Override
	    public Order createOrder(Order order) {
	        String userId = order.getUserid();
	        String cartId = order.getCartid(); 
	        String uName = order.getuName();
//	        List<CartItem> cartItems = order.getCartItems();
	        
	        User user = restTemplate.getForObject(USER_MICROSERVICE_URL + "getById/{userid}", User.class, userId);
	        if (user == null) {
	            throw new UserNotFoundException("User not found with ID: " + userId);
	        }

	        Cart cart = restTemplate.getForObject(CART_MICROSERVICE_URL + "getById/{cartid}", Cart.class, cartId);
	        if (cart == null) {
	            throw new CartNotFoundException("Cart not found with ID: " + cartId);
	        }

	        order.setuName(uName);
//	        order.setCartItems(cartItems);
	        order.setOrderdate(new Date());

	        order.setTotalCost(cart.getTotalCost());
	        order.setCartItems(cart.getCartItems());

	        return ordRepo.save(order);
	
	 }


	 public String deleteOrder(String orderid) {
			Optional<Order> o1 = ordRepo.findById(orderid);
			if(o1.isPresent()) {
				ordRepo.deleteById(orderid);
				return "order deleted";
			}
			
			return "order not found";
		}


	@Override
	public List<Order> getOrdersByUserid(String userid) {
	    List<Order> orders = ordRepo.findByUserid(userid);
	    return orders;
	}


	@Override
	public Order getOrderId(String orderid) {
	    Optional<Order> orderOptional = ordRepo.findById(orderid);
	    if (!orderOptional.isPresent()) {
	        throw new OrderNotFoundException("order not found for cartid: " + orderid);
	    }
	    return orderOptional.get();
	}


	@Override
	public List<Order> getAllOrders() {
		List<Order> orders=ordRepo.findAll();
		System.out.println("Getting data from"+orders);
		return orders;
	}
		
	
}
