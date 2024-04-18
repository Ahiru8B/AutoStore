package com.ahiru8b.autostore.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ahiru8b.autostore.model.Detail;

@SpringBootTest
class DetailDaoTest {
	@Autowired
	private DetailDao detailsDao;

	@Test
	void initTest() {
		assertNotNull(detailsDao);
	}

	@Test
	void saveTest() {
		Detail detail = new Detail();
		detail.setName("Сцепление");
		detail.setPrice(5000);
		detailsDao.save(detail);
		assertEquals(detail, detailsDao.findById(1).get());
	}

}
