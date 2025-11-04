package com.ntn.spring.modal.domain.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpForm {

	@NotBlank(message="enter login ID")
	private String loginId;
	
	@NotBlank(message="enter name")
	private String name;
	
	@NotBlank(message="enter password")
	private String password;
}
