package com.ntn.spring.modal.domain.vo;

import lombok.Data;

@Data
public class UserVo {

	private int id;
	private String name;
	private String email;
	private String phone;
	private Boolean status;
}
