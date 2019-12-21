package com.digitrinity.dto;

import java.io.Serializable;

public class DeviceTypeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String deviceType;

	public DeviceTypeDto() {
	}

	public DeviceTypeDto(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
}
