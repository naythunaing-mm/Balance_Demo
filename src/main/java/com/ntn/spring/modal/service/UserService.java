package com.ntn.spring.modal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntn.spring.modal.domain.entity.User;
import com.ntn.spring.modal.domain.form.SignUpForm;
import com.ntn.spring.modal.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void signUp(SignUpForm form) {
		form.setPassword(passwordEncoder.encode(form.getPassword()));
		System.out.println(form.toString());
		userRepo.save(new User(form));
	}
	
}
