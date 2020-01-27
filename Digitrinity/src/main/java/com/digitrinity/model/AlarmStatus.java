package com.digitrinity.model;

import javax.persistence.*;

@Entity
@Table(name = "V_alarmStatus")
@IdClass(AlarmStatusComposite.class)
public class AlarmStatus {

	@Id
	@Column(name = "alOpentime")
	private String alOpentime;

	@Id
	@Column(name = "smsitecode")
	private String smSiteCode;

	@Column(name = "smsiteid")
	private Integer smsiteid;

	@Column(name = "sacalarmactivestatus")
	private Integer sacalarmactivestatus;

	@Column(name = "alrPinNumber")
	private String alrPinNumber;

	@Column(name = "smsitename")
	private String smSiteName;

	@Column(name = "alname")
	private String alName;

	@Column(name = "alpincriticality")
	private String alPinCriticality;
	
	@Column(name = "Aging")
	private Integer age;

	@Column(name = "almcategory")
	private String almcategory;

	@Column(name = "smsitetypeid")
	private String smSiteTypeId;

	@Column(name = "customer_id")
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getSmSiteTypeId() {
		return smSiteTypeId;
	}

	public void setSmSiteTypeId(String smSiteTypeId) {
		this.smSiteTypeId = smSiteTypeId;
	}


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
