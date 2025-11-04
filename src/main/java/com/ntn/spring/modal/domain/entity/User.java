package com.ntn.spring.modal.domain.entity;

import java.io.Serializable;

import com.ntn.spring.modal.domain.form.SignUpForm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Column(nullable = false)
    private String password;

    private String phone;

    @Column(nullable = false, unique = true) 
    private String loginId;

    private boolean isActive = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public enum Role {
        ADMIN, MEMBER
    }
    
    public User(SignUpForm form) {
    	this.name = form.getName();
    	this.loginId = form.getLoginId();
    	this.password = form.getPassword();
    	this.isActive = true;
    	this.role = Role.MEMBER;
    }
}
