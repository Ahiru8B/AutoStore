package com.ahiru8b.autostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahiru8b.autostore.service.DetailService;

@Controller
@RequestMapping("/details")
public class DetailsCotroller {
	@Autowired
	private DetailService detailsService;

	@GetMapping
	public String getDetailsPage(Model model) {
		model.addAttribute("details", detailsService.findAll());
		return "details";
	}
}
