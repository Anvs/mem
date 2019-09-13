package com.anvs.mem.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

@DynamicUpdate
@Table(appliesTo = "SALARIED_POSITION")
public class Position {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_POSITION")
	private Long id;
	
	@Column(name = "DESCR")
	private String name;
	//private String gmtIncomeTime; 

	public Position() {
		this.name = "";
	}
	
	public Position(String name) {
		this.name = name;
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
