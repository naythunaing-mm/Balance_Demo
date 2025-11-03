package com.ntn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/balance")
public class BalanceController {

	@GetMapping("{id:\\d+}")
	public String findById(@PathVariable int id, org.springframework.security.core.Authentication auth) {
		 System.out.println("Logged in user: " + auth.getName());
		    System.out.println("Authorities: " + auth.getAuthorities());
		return "balance-detail";
	}

	@GetMapping("add/{type}")
	public String addNew(@PathVariable String type, ModelMap model) {
		model.put("title", "incomes".equals(type) ? "Add New Income" : "Add New Expense");
		model.put("type", type);
		return "balance-edit";
	}
	
	@GetMapping("/{type}")
	public String incomes(ModelMap model, @PathVariable String type) {
		model.put("title", "incomes".equals(type)? "Income Managements" : "Expense Managements");
		return "balance-list";
	}
	
	@GetMapping("edit/{id:\\d+}")
	public String edit(@PathVariable int id, ModelMap model) {
		model.put("title", "Edit Income");
		model.put("type", "incomes");
		return "balance-edit";
	}
	
	@GetMapping("delete/{id:\\d+}")
	public String delete(@PathVariable int id) {
		return "redirect:/";
	}

	@PostMapping
	public String save() {
		return "redirect:/user/balance/%d".formatted(1);
	}
	
	@GetMapping
	public String listBalances(ModelMap model) {
	    model.put("title", "Balance Report");
	    return "balance-report";
	}


}
