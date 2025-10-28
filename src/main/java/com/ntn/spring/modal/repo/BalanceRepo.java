package com.ntn.spring.modal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntn.spring.modal.domain.entity.Balance;

public interface BalanceRepo extends JpaRepository<Balance, Integer> {

}
