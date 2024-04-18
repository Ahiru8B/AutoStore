package com.ahiru8b.autostore.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OrderItemTest {

	@Test
	void testPrice() {
		OrderItem orderItem = new OrderItem();
		orderItem.setCount(10);
		Detail detail = new Detail();
		detail.setName("Сцепление");
		detail.setPrice(5000);
		orderItem.setDetail(detail);

		assertEquals(50000, orderItem.price());
	}

}
