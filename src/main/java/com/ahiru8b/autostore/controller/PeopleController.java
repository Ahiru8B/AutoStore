package com.ahiru8b.autostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahiru8b.autostore.service.PersonService;

@Controller
@RequestMapping("/people")
public class PeopleController {
	@Autowired
	private PersonService personService;

	@GetMapping
	public String getPeoplePage(Model model) {
		model.addAttribute("people", personService.findAll());
		return "people";
	}
}
