package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zonemaster")
public class ZoneMaster {
	
	@Id
	private Long znZoneID;
	
	private Integer rgRegionID;
	
	private String znZone;
	
	private Integer cmID;
	
	private Integer znAcsysSyncstatus;
	
	private Integer znAcsysSyncDateTime;
	
	@Column(name = "AccID")
	private Integer accID;
	
	private Integer znCreateddt;
	
	private Integer znLastupdateddt;
	
	private String znCreatedby;
	
	private String znLastupdatedby;

	public Long getZnZoneID() {
		return znZoneID;
	}

	public void setZnZoneID(Long znZoneID) {
		this.znZoneID = znZoneID;
	}

	public Integer getRgRegionID() {
		return rgRegionID;
	}

	public void setRgRegionID(Integer rgRegionID) {
		this.rgRegionID = rgRegionID;
	}

	public String getZnZone() {
		return znZone;
	}

	public void setZnZone(String znZone) {
		this.znZone = znZone;
	}

	public Integer getCmID() {
		return cmID;
	}

	public void setCmID(Integer cmID) {
		this.cmID = cmID;
	}

	public int getZnAcsysSyncstatus() {
		return znAcsysSyncstatus;
	}

	public void setZnAcsysSyncstatus(Integer znAcsysSyncstatus) {
		this.znAcsysSyncstatus = znAcsysSyncstatus;
	}

	public int getZnAcsysSyncDateTime() {
		return znAcsysSyncDateTime;
	}

	public void setZnAcsysSyncDateTime(Integer znAcsysSyncDateTime) {
		this.znAcsysSyncDateTime = znAcsysSyncDateTime;
	}

	public Integer getAccID() {
		return accID;
	}

	public void setAccID(Integer accID) {
		this.accID = accID;
	}

	public int getZnCreateddt() {
		return znCreateddt;
	}

	public void setZnCreateddt(Integer znCreateddt) {
		this.znCreateddt = znCreateddt;
	}

	public Integer getZnLastupdateddt() {
		return znLastupdateddt;
	}

	public void setZnLastupdateddt(Integer znLastupdateddt) {
		this.znLastupdateddt = znLastupdateddt;
	}

	public String getZnCreatedby() {
		return znCreatedby;
	}

	public void setZnCreatedby(String znCreatedby) {
		this.znCreatedby = znCreatedby;
	}

	public String getZnLastupdatedby() {
		return znLastupdatedby;
	}

	public void setZnLastupdatedby(String znLastupdatedby) {
		this.znLastupdatedby = znLastupdatedby;
	}
}
