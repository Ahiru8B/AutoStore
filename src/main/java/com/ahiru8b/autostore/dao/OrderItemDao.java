package com.ahiru8b.autostore.dao;

import org.springframework.data.repository.CrudRepository;

import com.ahiru8b.autostore.model.OrderItem;

public interface OrderItemDao extends CrudRepository<OrderItem, Integer> {

}
