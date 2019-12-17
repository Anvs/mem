//package com.anvs.mem.client;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonAnySetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//"id",
//"fio",
//"company",
//"position",
//"citizenship",
//"passpotPrefix",
//"passportNumber",
//"passportDepName",
//"passportDepCode",
//"passportDate",
//"archived"
//})
//
//public class EmployeeData //implements Serializable
//{
//
//@JsonProperty("id")
//private Integer id;
//@JsonProperty("fio")
//private String fio;
//@JsonProperty("company/name")
//private String companyName;
//@JsonProperty("company/id")
//private Long companyId;
//@JsonProperty("position/descr")
//private String positionName;
//@JsonProperty("position/id")
//private Position positionId;
//@JsonProperty("citizenship")
//private String citizenship;
//@JsonProperty("passpotPrefix")
//private String passpotPrefix;
//@JsonProperty("passportNumber")
//private String passportNumber;
//@JsonProperty("passportDepName")
//private String passportDepName;
//@JsonProperty("passportDepCode")
//private String passportDepCode;
//@JsonProperty("passportDate")
//private Integer passportDate;
//@JsonProperty("archived")
//private Boolean archived;
//
//@JsonIgnore
//private Map<String, Object> additionalProperties = new HashMap<String, Object>();
////public final static Parcelable.Creator<EmployeeData> CREATOR = new Creator<EmployeeData>() {
////
////
////@SuppressWarnings({
////"unchecked"
////})
////public EmployeeData createFromParcel(Parcel in) {
////return new EmployeeData(in);
////}
////
////public EmployeeData[] newArray(int size) {
////return (new EmployeeData[size]);
////}
////};
//
//private final static long serialVersionUID = -5548544018646508241L;
//
//protected EmployeeData(Parcel in) {
//this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
//this.fio = ((String) in.readValue((String.class.getClassLoader())));
//this.company = ((Company) in.readValue((Company.class.getClassLoader())));
//this.position = ((Position) in.readValue((Position.class.getClassLoader())));
//this.citizenship = ((String) in.readValue((String.class.getClassLoader())));
//this.passpotPrefix = ((String) in.readValue((String.class.getClassLoader())));
//this.passportNumber = ((String) in.readValue((String.class.getClassLoader())));
//this.passportDepName = ((String) in.readValue((String.class.getClassLoader())));
//this.passportDepCode = ((String) in.readValue((String.class.getClassLoader())));
//this.passportDate = ((Integer) in.readValue((Integer.class.getClassLoader())));
//this.archived = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
//this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
//}
//
//public EmployeeData() {
//}
//
//@JsonProperty("id")
//public Integer getId() {
//return id;
//}
//
//@JsonProperty("id")
//public void setId(Integer id) {
//this.id = id;
//}
//
//public EmployeeData withId(Integer id) {
//this.id = id;
//return this;
//}
//
//@JsonProperty("fio")
//public String getFio() {
//return fio;
//}
//
//@JsonProperty("fio")
//public void setFio(String fio) {
//this.fio = fio;
//}
//
//public EmployeeData withFio(String fio) {
//this.fio = fio;
//return this;
//}
//
//@JsonProperty("company")
//public Company getCompany() {
//return company;
//}
//
//@JsonProperty("company")
//public void setCompany(Company company) {
//this.company = company;
//}
//
//public EmployeeData withCompany(Company company) {
//this.company = company;
//return this;
//}
//
//@JsonProperty("position")
//public Position getPosition() {
//return position;
//}
//
//@JsonProperty("position")
//public void setPosition(Position position) {
//this.position = position;
//}
//
//public EmployeeData withPosition(Position position) {
//this.position = position;
//return this;
//}
//
//@JsonProperty("citizenship")
//public String getCitizenship() {
//return citizenship;
//}
//
//@JsonProperty("citizenship")
//public void setCitizenship(String citizenship) {
//this.citizenship = citizenship;
//}
//
//public EmployeeData withCitizenship(String citizenship) {
//this.citizenship = citizenship;
//return this;
//}
//
//@JsonProperty("passpotPrefix")
//public String getPasspotPrefix() {
//return passpotPrefix;
//}
//
//@JsonProperty("passpotPrefix")
//public void setPasspotPrefix(String passpotPrefix) {
//this.passpotPrefix = passpotPrefix;
//}
//
//public EmployeeData withPasspotPrefix(String passpotPrefix) {
//this.passpotPrefix = passpotPrefix;
//return this;
//}
//
//@JsonProperty("passportNumber")
//public String getPassportNumber() {
//return passportNumber;
//}
//
//@JsonProperty("passportNumber")
//public void setPassportNumber(String passportNumber) {
//this.passportNumber = passportNumber;
//}
//
//public EmployeeData withPassportNumber(String passportNumber) {
//this.passportNumber = passportNumber;
//return this;
//}
//
//@JsonProperty("passportDepName")
//public String getPassportDepName() {
//return passportDepName;
//}
//
//@JsonProperty("passportDepName")
//public void setPassportDepName(String passportDepName) {
//this.passportDepName = passportDepName;
//}
//
//public EmployeeData withPassportDepName(String passportDepName) {
//this.passportDepName = passportDepName;
//return this;
//}
//
//@JsonProperty("passportDepCode")
//public String getPassportDepCode() {
//return passportDepCode;
//}
//
//@JsonProperty("passportDepCode")
//public void setPassportDepCode(String passportDepCode) {
//this.passportDepCode = passportDepCode;
//}
//
//public EmployeeData withPassportDepCode(String passportDepCode) {
//this.passportDepCode = passportDepCode;
//return this;
//}
//
//@JsonProperty("passportDate")
//public Integer getPassportDate() {
//return passportDate;
//}
//
//@JsonProperty("passportDate")
//public void setPassportDate(Integer passportDate) {
//this.passportDate = passportDate;
//}
//
//public EmployeeData withPassportDate(Integer passportDate) {
//this.passportDate = passportDate;
//return this;
//}
//
//@JsonProperty("archived")
//public Boolean getArchived() {
//return archived;
//}
//
//@JsonProperty("archived")
//public void setArchived(Boolean archived) {
//this.archived = archived;
//}
//
//public EmployeeData withArchived(Boolean archived) {
//this.archived = archived;
//return this;
//}
//
//@JsonAnyGetter
//public Map<String, Object> getAdditionalProperties() {
//return this.additionalProperties;
//}
//
//@JsonAnySetter
//public void setAdditionalProperty(String name, Object value) {
//this.additionalProperties.put(name, value);
//}
//
//public EmployeeData withAdditionalProperty(String name, Object value) {
//this.additionalProperties.put(name, value);
//return this;
//}
//
//@Override
//public String toString() {
//return new ToStringBuilder(this).append("id", id).append("fio", fio).append("company", company).append("position", position).append("citizenship", citizenship).append("passpotPrefix", passpotPrefix).append("passportNumber", passportNumber).append("passportDepName", passportDepName).append("passportDepCode", passportDepCode).append("passportDate", passportDate).append("archived", archived).append("additionalProperties", additionalProperties).toString();
//}
//
////@Override
////public int hashCode() {
////return new HashCodeBuilder().append(passportNumber).append(passportDepName).append(citizenship).append(passpotPrefix).append(fio).append(passportDepCode).append(archived).append(company).append(id).append(position).append(additionalProperties).append(passportDate).toHashCode();
////}
//
//@Override
//public boolean equals(Object other) {
//if (other == this) {
//return true;
//}
//if ((other instanceof EmployeeData) == false) {
//return false;
//}
//EmployeeData rhs = ((EmployeeData) other);
//return new EqualsBuilder().append(passportNumber, rhs.passportNumber)
//		.append(passportDepName, rhs.passportDepName)
//		.append(citizenship, rhs.citizenship)
//		.append(passpotPrefix, rhs.passpotPrefix)
//		.append(fio, rhs.fio)
//		.append(passportDepCode, rhs.passportDepCode)
//		.append(archived, rhs.archived)
//		.append(companyName, rhs.company)
//		.append(id, rhs.id)
//		.append(positionName, rhs.position)
//		.append(additionalProperties, rhs.additionalProperties)
//		.append(passportDate, rhs.passportDate)
//		.isEquals();
//}
//
////public void writeToParcel(Parcel dest, int flags) {
////dest.writeValue(id);
////dest.writeValue(fio);
////dest.writeValue(company);
////dest.writeValue(position);
////dest.writeValue(citizenship);
////dest.writeValue(passpotPrefix);
////dest.writeValue(passportNumber);
////dest.writeValue(passportDepName);
////dest.writeValue(passportDepCode);
////dest.writeValue(passportDate);
////dest.writeValue(archived);
////dest.writeValue(additionalProperties);
////}
//
//public int describeContents() {
//return 0;
//}
//
//}


package com.anvs.mem.client;

import java.util.Calendar;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeData {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("fio")
	private String fio;
	//@JsonProperty("id")
	private Integer companyId;
	//@JsonProperty("id")
	private String companyName;
	//@JsonProperty("id")
	private Integer positionId;
	//@JsonProperty("id")
	private String positionName;
	@JsonProperty("archived")
	private Boolean isArchived;
	@JsonProperty("citizenship")
	private String citizenship;
	@JsonProperty("passpotPrefix")
	private String passpotPrefix;
	@JsonProperty("passportNumber")
	private String passportNumber;
	@JsonProperty("passportDepName")
	private String passportDepName;
	@JsonProperty("passportDepCode")
	private String passportDepCode;
	@JsonProperty("passportDate")
	private Calendar passportDate;
	
	@JsonProperty("company")
    private void unpackNestedFromCompany(Map<String,Object> company) {
        this.companyId = (Integer) company.get("id");
        this.companyName = (String) company.get("name");
    }
	
	@JsonProperty("position")
    private void unpackNestedFromPosition(Map<String,Object> position) {
        this.positionId = (Integer) position.get("id");
        this.positionName = (String) position.get("name");
    }
	
	public EmployeeData() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Boolean getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(Boolean isArchived) {
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

	@Override
	public String toString() {
		return "EmployeeData [" + (id != null ? "id=" + id + ", " : "") + (fio != null ? "fio=" + fio + ", " : "")
				+ (companyName != null ? "companyName=" + companyName + ", " : "")
				+ (positionName != null ? "positionName=" + positionName + ", " : "")
				+ (isArchived != null ? "isArchived=" + isArchived + ", " : "")
				+ (citizenship != null ? "citizenship=" + citizenship + ", " : "")
				+ (passpotPrefix != null ? "passpotPrefix=" + passpotPrefix + ", " : "")
				+ (passportNumber != null ? "passportNumber=" + passportNumber + ", " : "")
				+ (passportDepName != null ? "passportDepName=" + passportDepName + ", " : "")
				+ (passportDepCode != null ? "passportDepCode=" + passportDepCode + ", " : "")
				+ (passportDate != null ? "passportDate=" + passportDate.getTimeInMillis() : "") + "]";
	}

}
