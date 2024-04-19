package com.ahiru8b.autostore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahiru8b.autostore.dao.DetailDao;
import com.ahiru8b.autostore.model.Detail;

@Service
public class DetailService {
	@Autowired
	private DetailDao detailDao;

	public Iterable<Detail> findAll() {
		return detailDao.findAll();
	}

	public Detail save(Detail detail) {
		return detailDao.save(detail);
	}

	public Detail deleteById(Integer id) {
		Optional<Detail> detail = detailDao.findById(id);
		detailDao.deleteById(id);
		if (detail.isPresent()) {
			return detail.get();
		} else {
			return null;
		}

	}

	public Detail findById(Integer id) {
		Optional<Detail> detail = detailDao.findById(id);
		if (detail.isPresent()) {
			return detail.get();
		} else {
			return null;
		}
	}

	public Detail update(Detail detail) {
		Optional<Detail> savedDetail = detailDao.findById(detail.getId());
		if (savedDetail.isEmpty()) {
			return null;
		} else {
			if (!detail.getName().isBlank()) {
				savedDetail.get().setName(detail.getName());
			}
		}
		if (detail.getPrice() != null) {
			savedDetail.get().setPrice(detail.getPrice());
		}
		return detailDao.save(savedDetail.get());
	}
}
