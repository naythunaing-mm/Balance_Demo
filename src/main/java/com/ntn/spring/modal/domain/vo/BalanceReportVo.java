package com.ntn.spring.modal.domain.vo;

import java.time.LocalDate;

import com.ntn.spring.modal.domain.entity.Balance.Type;

import lombok.Data;

@Data
public class BalanceReportVo {

	private int id;
	private LocalDate date;
	private Type type;
	private String category;
	private int amount;
	private int balance;
}
