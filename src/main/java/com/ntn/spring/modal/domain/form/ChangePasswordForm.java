package com.ntn.spring.modal.domain.form;

import lombok.Data;

@Data
public class ChangePasswordForm {

	private String loginId;
	private String oldPassword;
	private String newPassword;
}
