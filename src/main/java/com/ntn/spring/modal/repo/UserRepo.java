package com.ntn.spring.modal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntn.spring.modal.domain.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findOneByLoginId(String username);

}
