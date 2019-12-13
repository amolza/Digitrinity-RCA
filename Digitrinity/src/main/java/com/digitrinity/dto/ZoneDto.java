package com.digitrinity.dto;

import java.io.Serializable;

public class ZoneDto implements Serializable {
	
	private static final long serialVersionUID = -8471338064827629745L;

	private String znZoneID;
	
	private String rgRegionID;
	
	private String znZone;
	
	public String getZnZoneID() {
		return znZoneID;
	}

	public void setZnZoneID(String znZoneID) {
		this.znZoneID = znZoneID;
	}

	public String getRgRegionID() {
		return rgRegionID;
	}

	public void setRgRegionID(String rgRegionID) {
		this.rgRegionID = rgRegionID;
	}

	public String getZnZone() {
		return znZone;
	}

	public void setZnZone(String znZone) {
		this.znZone = znZone;
	}
	
}
