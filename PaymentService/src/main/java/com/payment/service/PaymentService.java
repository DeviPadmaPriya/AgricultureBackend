package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.payment.entity.Order;
import com.payment.entity.Payment;
import com.payment.entity.User;
import com.payment.exception.OrderNotFoundException;
import com.payment.exception.UserNotFoundException;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentService {
	
	
	@Autowired
	PaymentRepository payRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	private static final String ORDER_MICROSERVICE_URL = "http://ORDER/order/";
    private static final String USER_MICROSERVICE_URL = "http://USERSERVICE/user/";

	 public Payment addPayment(Payment payment) {
	        String userId = payment.getUserid();
	        User user = restTemplate.getForObject(USER_MICROSERVICE_URL + "getById/{userid}", User.class, userId);
	        if (user == null) {
	            throw new UserNotFoundException("User not found with ID: " + userId);
	        }

	        String orderId = payment.getOrderid();
	        Order order = restTemplate.getForObject(ORDER_MICROSERVICE_URL + "getById/{orderid}", Order.class, orderId);
	        if (order == null) {
	            throw new OrderNotFoundException("Order not found with ID: " + orderId);
	        }

	        return payRepo.save(payment);
	    }

}
