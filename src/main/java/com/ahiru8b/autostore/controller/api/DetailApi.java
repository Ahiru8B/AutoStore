package com.ahiru8b.autostore.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahiru8b.autostore.model.Detail;
import com.ahiru8b.autostore.service.DetailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/detail/")
@Slf4j
public class DetailApi {
	@Autowired
	private DetailService detailService;

	@PostMapping
	public Detail save(@RequestBody Detail detail) {
		log.info("Попытка сохранить detail = {}", detail);
		return detailService.save(detail);
	}

	@DeleteMapping("{id}")
	public Detail delete(@PathVariable Integer id) {
		log.info("Попытка удалить detail с id = {}", id);
		return detailService.deleteById(id);
	}

	@GetMapping("{id}")
	public Detail get(@PathVariable Integer id) {
		log.info("Попытка получить detail с id = {}", id);
		return detailService.findById(id);
	}

	@PutMapping
	public Detail put(@RequestBody Detail detail) {
		return detailService.update(detail);
	}

}
