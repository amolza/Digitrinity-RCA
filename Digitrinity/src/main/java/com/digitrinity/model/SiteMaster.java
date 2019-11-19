package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sitemaster")
public class SiteMaster{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int smSiteID;
	@Column(name = "smSitecode")
	private String smSitecode;
	@Column(name = "smSitename")
	private String smSitename;
	@Column(name = "crClusterID")
	private Integer crClusterID;
	@Column(name = "smAddress")
	private String smAddress;
	@Column(name = "smDistrict")
	private String smDistrict;
	@Column(name = "smPincode")
	private Integer smPincode;
	@Column(name = "smLatitude")
	private double smLatitude;
	@Column(name = "smLongitude")
	private double smLongitude;
	@Column(name = "smTechEmpid")
	private Integer smTechEmpid;
	@Column(name = "Devicetype")
	private String devicetype;
	@Column(name = "simID")
	private Integer simID;
	@Column(name = "smCreateddt")
	private Integer smCreateddt;
	@Column(name = "smCreatedby")
	private String smCreatedby;
	@Column(name = "smLastupdateddt")
	private Integer smLastupdateddt;
	@Column(name = "smLastupdatedby")
	private String smLastupdatedby;
	@Column(name = "smSiteactivestatus")
	private Integer smSiteactivestatus;
	@Column(name = "smSitetypeid")
	private Integer smSitetypeid;
	@Column(name = "smCustomerName")
	private String smCustomerName;
	@Column(name = "AccID")
	private Integer accID;
	
	public int getSmSiteID() {
		return smSiteID;
	}
	public void setSmSiteID(int smSiteID) {
		this.smSiteID = smSiteID;
	}
	public String getSmSitecode() {
		return smSitecode;
	}
	public void setSmSitecode(String smSitecode) {
		this.smSitecode = smSitecode;
	}
	public String getSmSitename() {
		return smSitename;
	}
	public void setSmSitename(String smSitename) {
		this.smSitename = smSitename;
	}
	public int getCrClusterID() {
		return crClusterID;
	}
	public void setCrClusterID(int crClusterID) {
		this.crClusterID = crClusterID;
	}
	public String getSmAddress() {
		return smAddress;
	}
	public void setSmAddress(String smAddress) {
		this.smAddress = smAddress;
	}
	public String getSmDistrict() {
		return smDistrict;
	}
	public void setSmDistrict(String smDistrict) {
		this.smDistrict = smDistrict;
	}
	public int getSmPincode() {
		return smPincode;
	}
	public void setSmPincode(int smPincode) {
		this.smPincode = smPincode;
	}
	public double getSmLatitude() {
		return smLatitude;
	}
	public void setSmLatitude(double smLatitude) {
		this.smLatitude = smLatitude;
	}
	public double getSmLongitude() {
		return smLongitude;
	}
	public void setSmLongitude(double smLongitude) {
		this.smLongitude = smLongitude;
	}
	public int getSmTechEmpid() {
		return smTechEmpid;
	}
	public void setSmTechEmpid(int smTechEmpid) {
		this.smTechEmpid = smTechEmpid;
	}
	public String getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	public int getSimID() {
		return simID;
	}
	public void setSimID(int simID) {
		this.simID = simID;
	}
	public int getSmCreateddt() {
		return smCreateddt;
	}
	public void setSmCreateddt(int smCreateddt) {
		this.smCreateddt = smCreateddt;
	}
	public String getSmCreatedby() {
		return smCreatedby;
	}
	public void setSmCreatedby(String smCreatedby) {
		this.smCreatedby = smCreatedby;
	}
	public int getSmLastupdateddt() {
		return smLastupdateddt;
	}
	public void setSmLastupdateddt(int smLastupdateddt) {
		this.smLastupdateddt = smLastupdateddt;
	}
	public String getSmLastupdatedby() {
		return smLastupdatedby;
	}
	public void setSmLastupdatedby(String smLastupdatedby) {
		this.smLastupdatedby = smLastupdatedby;
	}
	public int getSmSiteactivestatus() {
		return smSiteactivestatus;
	}
	public void setSmSiteactivestatus(int smSiteactivestatus) {
		this.smSiteactivestatus = smSiteactivestatus;
	}
	public int getSmSitetypeid() {
		return smSitetypeid;
	}
	public void setSmSitetypeid(int smSitetypeid) {
		this.smSitetypeid = smSitetypeid;
	}
	public String getSmCustomerName() {
		return smCustomerName;
	}
	public void setSmCustomerName(String smCustomerName) {
		this.smCustomerName = smCustomerName;
	}
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}

	
}