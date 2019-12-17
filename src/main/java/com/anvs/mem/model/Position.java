package com.anvs.mem.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@javax.persistence.Table(name = "SALARIED_POSITION")
public class Position {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator="sqlite")
	@TableGenerator(name="sqlite", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq",
	    pkColumnValue="SALARIED_POSITION")
	@Column(name = "ID_POSITION")
	private Long id;
	
	@Column(name = "DESCR")
	private String name;
	//private String gmtIncomeTime; 

	public Position() {
		this.name = "";
		this.id = null;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Position)) {
			return false;
		}
		Position other = (Position) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	
}
