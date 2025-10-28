package com.ntn.spring.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ntn.spring.modal.domain.entity.User.Role;

@Controller
public class SecurityController {

	@GetMapping("/")
	public String index() {
		var auth = SecurityContextHolder.getContext().getAuthentication();
		if (null != auth && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(Role.ADMIN.name()) 
				|| a.getAuthority().equals(Role.ADMIN.name()))) {
			return "redirect:/user/index";
		}
		return "signin";
	}
	@GetMapping("/signup")
	public void loadSignUp() {

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
