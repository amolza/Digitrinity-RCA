package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regionmaster")
public class RegionMaster{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rgRegionID")
	private int rgRegionID;
	@Column(name = "znZoneID")
	private Integer znZoneID;
	@Column(name = "rgRegion")
	private String rgRegion;
	@Column(name = "rgAcsysSyncstatus")
	private Integer rgAcsysSyncstatus;
	@Column(name = "rgAcsysSyncDateTime")
	private Integer rgAcsysSyncDateTime;
	@Column(name = "AccID")
	private Integer accID;
	@Column(name = "rgCreateddt")
	private Integer rgCreateddt;
	@Column(name = "rgCreatedby")
	private String rgCreatedby;
	@Column(name = "rgLastupdateddt")
	private Integer rgLastupdateddt;
	@Column(name = "rgLastupdatedby")
	private String rgLastupdatedby;
	public int getRgRegionID() {
		return rgRegionID;
	}
	public void setRgRegionID(int rgRegionID) {
		this.rgRegionID = rgRegionID;
	}
	public int getZnZoneID() {
		return znZoneID;
	}
	public void setZnZoneID(int znZoneID) {
		this.znZoneID = znZoneID;
	}
	public String getRgRegion() {
		return rgRegion;
	}
	public void setRgRegion(String rgRegion) {
		this.rgRegion = rgRegion;
	}
	public int getRgAcsysSyncstatus() {
		return rgAcsysSyncstatus;
	}
	public void setRgAcsysSyncstatus(int rgAcsysSyncstatus) {
		this.rgAcsysSyncstatus = rgAcsysSyncstatus;
	}
	public int getRgAcsysSyncDateTime() {
		return rgAcsysSyncDateTime;
	}
	public void setRgAcsysSyncDateTime(int rgAcsysSyncDateTime) {
		this.rgAcsysSyncDateTime = rgAcsysSyncDateTime;
	}
	public Integer getAccID() {
		return accID;
	}
	public void setAccID(Integer accID) {
		this.accID = accID;
	}
	public int getRgCreateddt() {
		return rgCreateddt;
	}
	public void setRgCreateddt(int rgCreateddt) {
		this.rgCreateddt = rgCreateddt;
	}
	public String getRgCreatedby() {
		return rgCreatedby;
	}
	public void setRgCreatedby(String rgCreatedby) {
		this.rgCreatedby = rgCreatedby;
	}
	public int getRgLastupdateddt() {
		return rgLastupdateddt;
	}
	public void setRgLastupdateddt(int rgLastupdateddt) {
		this.rgLastupdateddt = rgLastupdateddt;
	}
	public String getRgLastupdatedby() {
		return rgLastupdatedby;
	}
	public void setRgLastupdatedby(String rgLastupdatedby) {
		this.rgLastupdatedby = rgLastupdatedby;
	}

	
}