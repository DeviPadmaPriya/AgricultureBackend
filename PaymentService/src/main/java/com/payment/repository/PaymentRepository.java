package com.payment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.payment.entity.Payment;

public interface PaymentRepository extends MongoRepository<Payment,String> {

}
