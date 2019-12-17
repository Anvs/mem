package com.anvs.mem.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "SALARIED_COMPANY")
public class Company {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator="sqlite")
	@TableGenerator(name="sqlite", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq",
	    pkColumnValue="SALARIED_COMPANY")
	@Column(name = "ID_COMPANY")
	private Long id;
	
	@Column(name = "CompanyName")
	private String name;
	
	@Column(name = "dinner_time")
	private Integer dinnerLimitInMinutes;
	
	@Column(name = "UseForCheck")
	private Boolean limitCheck;
	
	@Column(name = "MailForSend")
	private String broadcastEmail;
	
	public Company(String name, Integer dinnerLimitInMinutes, Boolean limitCheck, String broadcastEmail) {
		this.name = name;
		this.dinnerLimitInMinutes = dinnerLimitInMinutes;
		this.limitCheck = limitCheck;
		this.broadcastEmail = broadcastEmail;
	}
	
	public Company(String name) {
		this.name = name;
//		this.dinnerLimitInMinutes = 0;
//		this.limitCheck = false;
//		this.broadcastEmail = "";
	}

	public Company() {
//		this.name = "";
//		this.dinnerLimitInMinutes = 0;
//		this.limitCheck = false;
//		this.broadcastEmail = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDinnerLimitInMinutes() {
		return dinnerLimitInMinutes;
	}

	public void setDinnerLimitInMinutes(Integer dinnerLimitInMinutes) {
		this.dinnerLimitInMinutes = dinnerLimitInMinutes;
	}

	public Boolean isLimitCheck() {
		return limitCheck;
	}

	public void setLimitCheck(Boolean limitCheck) {
		this.limitCheck = limitCheck;
	}

	public String getBroadcastEmail() {
		return broadcastEmail;
	}

	public void setBroadcastEmail(String broadcastEmail) {
		this.broadcastEmail = broadcastEmail;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(broadcastEmail, dinnerLimitInMinutes, id, limitCheck, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Company)) {
			return false;
		}
		Company other = (Company) obj;
		return Objects.equals(broadcastEmail, other.broadcastEmail)
				&& dinnerLimitInMinutes == other.dinnerLimitInMinutes && Objects.equals(id, other.id)
				&& limitCheck == other.limitCheck && Objects.equals(name, other.name);
	}
	
}
