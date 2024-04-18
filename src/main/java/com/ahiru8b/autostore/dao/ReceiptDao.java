package com.ahiru8b.autostore.dao;

import org.springframework.data.repository.CrudRepository;

import com.ahiru8b.autostore.model.Receipt;

public interface ReceiptDao extends CrudRepository<Receipt, Integer> {

}
