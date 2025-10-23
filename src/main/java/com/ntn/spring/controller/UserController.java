package com.ntn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/users")
public class UserController {

	@GetMapping
	public String search() {
		return "users";
	}
}
