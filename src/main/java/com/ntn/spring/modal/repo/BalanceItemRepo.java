package com.ntn.spring.modal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntn.spring.modal.domain.entity.BalanceItem;

public interface BalanceItemRepo extends JpaRepository<BalanceItem, Integer>{

}
