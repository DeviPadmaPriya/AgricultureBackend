package com.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.entity.Order;

public interface OrderRepository extends MongoRepository<Order,String>{

	List<Order> findByUserid(String userid);

	

}
