package com.ahiru8b.autostore.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ahiru8b.autostore.model.Detail;
import com.ahiru8b.autostore.model.OrderItem;
import com.ahiru8b.autostore.model.Person;
import com.ahiru8b.autostore.model.Receipt;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class ReceiptDaoTest {
	@Autowired
	private ReceiptDao orderDao;

	@Test
	void initTest() {
		assertNotNull(orderDao);
	}

	@Test
	void saveTest() {
		OrderItem orderItem = new OrderItem();
		orderItem.setCount(10);
		Detail detail = new Detail();
		detail.setName("Сцепление");
		detail.setPrice(5000);
		orderItem.setDetail(detail);

		Receipt receipt = new Receipt();
		receipt.addItem(orderItem);

		Person person = new Person();
		person.setName("Петр");
		person.setSurname("Иванов");
		person.setPatronymic("Петрович");
		person.setNumber("+75554383355");
		receipt.setCustomer(person);

		orderDao.save(receipt);
		log.debug("saved object = {}", orderDao.findById(1).get());
		log.debug("norma object = {}", receipt);
		log.debug("is eq = {}", receipt.equals(orderDao.findById(1).get()));
		log.debug("s hash = {}", orderDao.findById(1).get().hashCode());
		log.debug("n hash = {}", receipt.hashCode());
		log.debug("hash is eq = {}", orderDao.findById(1).get().hashCode() == receipt.hashCode());
		assertEquals(receipt, orderDao.findById(1).get());
	}

}
