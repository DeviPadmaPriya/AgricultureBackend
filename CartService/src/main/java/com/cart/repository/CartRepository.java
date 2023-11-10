package com.cart.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cart.entity.Cart;



public interface CartRepository extends MongoRepository<Cart,String> {

    Cart findByUserid(String userid);


	Optional<Cart> findById(String id);




//	Optional<Cart> findByUserid(Long userid);

}
