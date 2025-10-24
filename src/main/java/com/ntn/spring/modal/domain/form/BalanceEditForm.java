package com.ntn.spring.modal.domain.form;

import java.util.List;

import lombok.Data;

@Data
public class BalanceEditForm {

    private BalanceSummaryForm header;
    private List<BalanceItemForm> items;
	
}
