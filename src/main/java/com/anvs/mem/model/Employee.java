package com.anvs.mem.model;

import java.util.Date;

//import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

import org.hibernate.annotations.*;


//CREATE TABLE SALARIED_PERSONS(ID_PERSON int primary key, FIO varchar(100) NOT NULL,  ADDDATE datetime default CURRENT_TIMESTAMP NULL, ID_COMPANY int NULL, id_position int NOT NULL, archive int default 0 NULL, citizenOf varchar(50) NULL, passpotSer varchar(10) NULL, passportNum varchar(10) NULL, passportDepName varchar(100) NULL, passportDepCode varchar(10) NULL, passportDate datetime NULL);

//@Entity
@DynamicUpdate
@Table(appliesTo = "SALARIED_PERSONS")
public class Employee {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSON")
	private int id;
	
	@Column(name = "FIO")
	private String fio;
	
	@OneToOne()
	@Column(name = "ID_COMPANY")
	private Company company;
	
	
	private Position position;
	
	@Column(name = "ARCHIVE")
	private boolean isArchived;
	
	@Column(name = "COTOZENOF")
	private String citizenship;
	
	@Column(name = "PASSPOTSER")
	private String passpotPrefix;
	
	@Column(name = "PASSPOTNUM")
	private String passportNumber;
	
	@Column(name = "PASSPOTDEPNAME")
	private String passportDepName;
	
	@Column(name = "PASSPOTDEPCODE")
	private String passportDepCode;
	
	@Column(name = "PASSPOTDATE")
	private Date passportDate;
	
	
	public Employee() {
		this.fio = "";
		this.company = new Company();
		this.position = new Position();
		this.isArchived = false;
		this.citizenship = "";
		this.passpotPrefix = "";
		this.passportNumber = "";
		this.passportDepName = "";
		this.passportDepCode = "";
		this.passportDate = new Date();
	}
	public Employee(String fio, Company company, Position position, boolean isArchived, String citizenship,
			String passpotPrefix, String passportNumber, String passportDepName, String passportDepCode,
			Date passportDate) {
		this.fio = fio;
		this.company = company;
		this.position = position;
		this.isArchived = isArchived;
		this.citizenship = citizenship;
		this.passpotPrefix = passpotPrefix;
		this.passportNumber = passportNumber;
		this.passportDepName = passportDepName;
		this.passportDepCode = passportDepCode;
		this.passportDate = passportDate;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public boolean isArchived() {
		return isArchived;
	}
	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public String getPasspotPrefix() {
		return passpotPrefix;
	}
	public void setPasspotPrefix(String passpotPrefix) {
		this.passpotPrefix = passpotPrefix;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getPassportDepName() {
		return passportDepName;
	}
	public void setPassportDepName(String passportDepName) {
		this.passportDepName = passportDepName;
	}
	public String getPassportDepCode() {
		return passportDepCode;
	}
	public void setPassportDepCode(String passportDepCode) {
		this.passportDepCode = passportDepCode;
	}
	public Date getPassportDate() {
		return passportDate;
	}
	public void setPassportDate(Date passportDate) {
		this.passportDate = passportDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
