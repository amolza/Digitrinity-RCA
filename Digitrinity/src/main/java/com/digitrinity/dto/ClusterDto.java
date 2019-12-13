package com.digitrinity.dto;

import java.io.Serializable;

import lombok.ToString;

@ToString(includeFieldNames=true)
public class ClusterDto implements Serializable {
	
	private static final long serialVersionUID = 3548480296160075797L;
	
	private String crClusterID;
	private String crName;
	private String znZoneID;
	
	public String getCrClusterID() {
		return crClusterID;
	}
	public void setCrClusterID(String crClusterID) {
		this.crClusterID = crClusterID;
	}
	public String getCrName() {
		return crName;
	}
	public void setCrName(String crName) {
		this.crName = crName;
	}
	public String getZnZoneID() {
		return znZoneID;
	}
	public void setZnZoneID(String znZoneID) {
		this.znZoneID = znZoneID;
	}
	
	
}
