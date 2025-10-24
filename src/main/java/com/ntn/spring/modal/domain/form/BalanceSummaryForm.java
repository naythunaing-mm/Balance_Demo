package com.ntn.spring.modal.domain.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BalanceSummaryForm {
	private int id;
	private LocalDate date;
	private String category;
}
