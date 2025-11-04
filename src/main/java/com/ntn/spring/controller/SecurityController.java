package com.ntn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ntn.spring.modal.domain.entity.User.Role;
import com.ntn.spring.modal.domain.form.SignUpForm;
import com.ntn.spring.modal.service.UserService;

@Controller
public class SecurityController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		var auth = SecurityContextHolder.getContext().getAuthentication();
		if (null != auth && auth.getAuthorities().stream().anyMatch(
				a -> a.getAuthority().equals(Role.ADMIN.name()) || a.getAuthority().equals(Role.ADMIN.name()))) {
			return "redirect:/user/index";
		}
		return "signin";
	}

	@GetMapping("/signin")
	public String signin(ModelMap model) {
		model.put("title", "User Sign");
		return "signin";
	}

	@GetMapping("/signup")
	public void loadSignUp(ModelMap model) {
		model.put("title", "User SignUp");

	}

	@PostMapping("/signup")
	public String signUp(@ModelAttribute("form") @Validated SignUpForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "signup";
		}
		userService.signUp(form);
		System.out.println(form);
		return "redirect:/";
	}

	@PostMapping("/user/change-password")
	public String changePassword() {
		return "redirect:/";
	}

	@ModelAttribute("form")
	SignUpForm form() {
		return new SignUpForm();
	}

}
