package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.Payment;
import com.payment.exception.PaymentNotFoundException;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {

	@Autowired
	PaymentService payService;
	
	
	@PostMapping("/add/user/{userid}/order/{orderid}")
	public Payment addPayment(@RequestBody Payment payment, @PathVariable String userid, @PathVariable String orderid) {
	    payment.setUserid(userid);
	    payment.setOrderid(orderid);

	    return payService.addPayment(payment);
	}
	
	
	
}
