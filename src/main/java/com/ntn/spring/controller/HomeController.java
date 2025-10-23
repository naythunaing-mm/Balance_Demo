package com.ntn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/home")
public class HomeController {

	@GetMapping("{type}")
	public String incomes(ModelMap model, @PathVariable String type) {
		model.put("title", "incomes".equals(type) ? "Income Management" : "Expense Management");
		model.put("type", type);
		return "balance-list";
	}

//	@GetMapping("/expenses")
//	public String expenses(ModelMap model) {
//		model.put("title", "Expense Management");
//		return "balance-list";
//	}
}
