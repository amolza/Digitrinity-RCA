package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clustermaster")
public class ClusterMaster {
	
	@Id
	private Long crClusterID;
	
	private Integer emEmployeeID;
	
	private Integer znZoneID;
	
	private String crName;
	
	private String crDefinition;
	
	private Integer crAcsysSyncstatus;
	
	private Integer crAcsysSyncDateTime;
	
	@Column(name = "AccID")
	private Integer accID=0;
	
	private Integer crCreateddt;	
	
	private Integer crLastupdateddt;
	
	private String crCreatedby;
	
	private String crLastupdatedby;

	public Long getCrClusterID() {
		return crClusterID;
	}

	public void setCrClusterID(Long crClusterID) {
		this.crClusterID = crClusterID;
	}

	public Integer getEmEmployeeID() {
		return emEmployeeID;
	}

	public void setEmEmployeeID(Integer emEmployeeID) {
		this.emEmployeeID = emEmployeeID;
	}

	public Integer getZnZoneID() {
		return znZoneID;
	}

	public void setZnZoneID(Integer znZoneID) {
		this.znZoneID = znZoneID;
	}

	public String getCrName() {
		return crName;
	}

	public void setCrName(String crName) {
		this.crName = crName;
	}

	public String getCrDefinition() {
		return crDefinition;
	}

	public void setCrDefinition(String crDefinition) {
		this.crDefinition = crDefinition;
	}

	public Integer getCrAcsysSyncstatus() {
		return crAcsysSyncstatus;
	}

	public void setCrAcsysSyncstatus(Integer crAcsysSyncstatus) {
		this.crAcsysSyncstatus = crAcsysSyncstatus;
	}

	public int getCrAcsysSyncDateTime() {
		return crAcsysSyncDateTime;
	}

	public void setCrAcsysSyncDateTime(Integer crAcsysSyncDateTime) {
		this.crAcsysSyncDateTime = crAcsysSyncDateTime;
	}

	public Integer getAccID() {
		return accID;
	}

	public void setAccID(Integer accID) {
		this.accID = accID;
	}

	public Integer getCrCreateddt() {
		return crCreateddt;
	}

	public void setCrCreateddt(Integer crCreateddt) {
		this.crCreateddt = crCreateddt;
	}

	public Integer getCrLastupdateddt() {
		return crLastupdateddt;
	}

	public void setCrLastupdateddt(Integer crLastupdateddt) {
		this.crLastupdateddt = crLastupdateddt;
	}

	public String getCrCreatedby() {
		return crCreatedby;
	}

	public void setCrCreatedby(String crCreatedby) {
		this.crCreatedby = crCreatedby;
	}

	public String getCrLastupdatedby() {
		return crLastupdatedby;
	}

	public void setCrLastupdatedby(String crLastupdatedby) {
		this.crLastupdatedby = crLastupdatedby;
	}
	
}
