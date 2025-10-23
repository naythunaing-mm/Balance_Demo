package com.ntn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

	@GetMapping("/singout")
	public String signOut() {
		return "redirect:/signin";
	}
	
	@GetMapping("/signin")
	public void loadSignIn() {

	}

	@GetMapping("/signup")
	public void loadSignUp() {

	}
	
	@PostMapping("/signin")
	public String signIn() {
		return "redirect:/";
	}

	@PostMapping("/signup")
	public String signUp() {
		return "redirect:/";
	}

	@PostMapping("/user/change-password")
	public String changePassword() {
		return "redirect:/";
	}
}
