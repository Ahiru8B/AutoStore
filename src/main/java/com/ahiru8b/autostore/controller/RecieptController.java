package com.ahiru8b.autostore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahiru8b.autostore.dao.DetailDao;
import com.ahiru8b.autostore.model.Detail;
import com.ahiru8b.autostore.model.OrderItem;
import com.ahiru8b.autostore.model.Person;
import com.ahiru8b.autostore.model.Receipt;

@Controller
@RequestMapping("/reciept/")
public class RecieptController {
	@Autowired
	private DetailDao detailDao;

	@GetMapping("{id}")
	public String getRecieptPage(@PathVariable Integer id, Model model) {
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
		List<OrderItem> orders = new ArrayList<OrderItem>();
		orders.add(orderItem);
		List<Detail> details = new ArrayList<Detail>();
		details.add(detail);
		model.addAttribute("items", orders);
		model.addAttribute("details", details);
		return "reciept";
	}
}
