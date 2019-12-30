package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_alarmStatus")
public class AlarmStatus {

	@Id
	private String alOpentime;
	
	private Integer smsiteid;
	
	private Integer sacalarmactivestatus;
	
	private String alrPinNumber;
	
	private String smSiteCode;
	
	private String smSiteName;
	
	private String alName;
	
	private String alPinCriticality;
	
	@Column(name = "Aging")
	private Integer age;
	
	private String almcategory;

	public String getAlOpentime() {
		return alOpentime;
	}

	public void setAlOpentime(String alOpentime) {
		this.alOpentime = alOpentime;
	}

	public Integer getSmsiteid() {
		return smsiteid;
	}

	public void setSmsiteid(Integer smsiteid) {
		this.smsiteid = smsiteid;
	}

	public Integer getSacalarmactivestatus() {
		return sacalarmactivestatus;
	}

	public void setSacalarmactivestatus(Integer sacalarmactivestatus) {
		this.sacalarmactivestatus = sacalarmactivestatus;
	}

	public String getAlrPinNumber() {
		return alrPinNumber;
	}

	public void setAlrPinNumber(String alrPinNumber) {
		this.alrPinNumber = alrPinNumber;
	}

	public String getSmSiteCode() {
		return smSiteCode;
	}

	public void setSmSiteCode(String smSiteCode) {
		this.smSiteCode = smSiteCode;
	}

	public String getSmSiteName() {
		return smSiteName;
	}

	public void setSmSiteName(String smSiteName) {
		this.smSiteName = smSiteName;
	}

	public String getAlName() {
		return alName;
	}

	public void setAlName(String alName) {
		this.alName = alName;
	}

	public String getAlPinCriticality() {
		return alPinCriticality;
	}

	public void setAlPinCriticality(String alPinCriticality) {
		this.alPinCriticality = alPinCriticality;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAlmcategory() {
		return almcategory;
	}

	public void setAlmcategory(String almcategory) {
		this.almcategory = almcategory;
	}

	
}
