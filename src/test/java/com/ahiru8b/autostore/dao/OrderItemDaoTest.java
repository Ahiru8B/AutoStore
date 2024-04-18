package com.ahiru8b.autostore.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ahiru8b.autostore.model.Detail;
import com.ahiru8b.autostore.model.OrderItem;

@SpringBootTest
class OrderItemDaoTest {
	@Autowired
	private OrderItemDao orderItemDao;

	@Test
	void init() {
		assertNotNull(orderItemDao);
	}

	@Test
	void save() {
		OrderItem orderItem = new OrderItem();
		orderItem.setCount(10);
		Detail detail = new Detail();
		detail.setName("Сцепление");
		detail.setPrice(5000);
		orderItem.setDetail(detail);
		orderItemDao.save(orderItem);
		assertEquals(orderItem, orderItemDao.findById(1).get());
	}

}
