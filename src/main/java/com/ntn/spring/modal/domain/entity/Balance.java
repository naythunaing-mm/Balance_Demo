package com.ntn.spring.modal.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Balance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private LocalDate date;
	private String Category;
	
	@ManyToOne(optional=false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private User user;

	
	private Type type;

	public enum Type {
		INCOME, EXPENSE
	}
}
