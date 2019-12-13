package com.digitrinity.dto;

import java.io.Serializable;

public class RegionDto implements Serializable {
	
	private static final long serialVersionUID = -752288070889029320L;

	private String rgRegionID;
	
	private String znZoneID;
	
	private String rgRegion;

	public String getRgRegionID() {
		return rgRegionID;
	}

	public void setRgRegionID(String rgRegionID) {
		this.rgRegionID = rgRegionID;
	}

	public String getZnZoneID() {
		return znZoneID;
	}

	public void setZnZoneID(String znZoneID) {
		this.znZoneID = znZoneID;
	}

	public String getRgRegion() {
		return rgRegion;
	}

	public void setRgRegion(String rgRegion) {
		this.rgRegion = rgRegion;
	}
	
	
}
