package com.fandf.mall.cart.mapper;

import com.fandf.mall.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMapper extends MongoRepository<Cart,String> {
}