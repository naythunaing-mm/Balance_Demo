package com.ntn.spring.modal.domain.vo;

import java.util.List;

import com.ntn.spring.modal.domain.form.BalanceItemForm;

import lombok.Data;

@Data
public class BalanceVo {

	private BalanceSummaryVo header;
	private List<BalanceItemForm> items;
}
