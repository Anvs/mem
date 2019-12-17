package com.anvs.mem.model;
 
import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//CREATE TABLE SALARIED_PERSONS 
//	(ID_PERSON int primary key
//	, FIO varchar(100) NOT NULL
//	, ADDDATE datetime default CURRENT_TIMESTAMP NULL
//	, ID_COMPANY int NULL
//	, id_position int NOT NULL
//	, archive int default 0 NULL
//	, citizenOf varchar(50) NULL
//	, passpotSer varchar(10) NULL
//	, passportNum varchar(10) NULL
//	, passportDepName varchar(100) NULL
//	, passportDepCode varchar(10) NULL
//	, passportDate datetime NULL);

@Entity
@javax.persistence.Table(name = "SALARIED_PERSONS")
public class Employee {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator="sqlite")
	@TableGenerator(name="sqlite", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq",
	    pkColumnValue="SALARIED_PERSONS")
	@Column(name = "ID_PERSON")
	private Long id;
	
	@Column(name = "FIO")
	private String fio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_COMPANY")
	private Company company;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_POSITION")
	private Position position;
	
	@Column(name = "ARCHIVE")
	private boolean isArchived;
	
	@Column(name = "CITIZENOF")
	private String citizenship;
	
	@Column(name = "PASSPOTSER")
	private String passpotPrefix;
	
	@Column(name = "PASSPORTNUM")
	private String passportNumber;
	
	@Column(name = "PASSPORTDEPNAME")
	private String passportDepName;
	
	@Column(name = "PASSPORTDEPCODE")
	private String passportDepCode;
	
	@Column(name = "PASSPORTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar passportDate;
	//private Date passportDate;
	
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
		this.passportDate = new GregorianCalendar(2000, 01, 01);
	}
	public Employee(String fio, Company company, Position position, boolean isArchived, String citizenship,
			String passpotPrefix, String passportNumber, String passportDepName, String passportDepCode,
			Calendar passportDate) {
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
	public Calendar getPassportDate() {
		return passportDate;
	}
	public void setPassportDate(Calendar passportDate) {
		this.passportDate = passportDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(citizenship, company, fio, id, isArchived, passportDate, passportDepCode, passportDepName,
				passportNumber, passpotPrefix, position);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		return Objects.equals(citizenship, other.citizenship) && Objects.equals(company, other.company)
				&& Objects.equals(fio, other.fio) && Objects.equals(id, other.id) && isArchived == other.isArchived
				&& Objects.equals(passportDate, other.passportDate)
				&& Objects.equals(passportDepCode, other.passportDepCode)
				&& Objects.equals(passportDepName, other.passportDepName)
				&& Objects.equals(passportNumber, other.passportNumber)
				&& Objects.equals(passpotPrefix, other.passpotPrefix) && Objects.equals(position, other.position);
	}
	
	
}
