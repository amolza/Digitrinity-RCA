package com.digitrinity.model;

public class HourlyReportGroup {

	public HourlyReportGroup(String date, Double mdgEnergy,
			Double dgEnergy, Double batteryDisEnergy, Double batteryChargingEnergy, Double teleEnergy,
			Double inverterEnergy, Double communityLoadEnergy, Double solarOutputEnergy, Double solarInputEnergy) {
		this.date = date;
		this.mdgEnergy = mdgEnergy;
		this.dgEnergy = dgEnergy;
		this.batteryDisEnergy = batteryDisEnergy;
		this.batteryChargingEnergy = batteryChargingEnergy;
		this.teleEnergy = teleEnergy;
		this.inverterEnergy = inverterEnergy;
		this.communityLoadEnergy = communityLoadEnergy;
		this.solarOutputEnergy = solarOutputEnergy;
		this.solarInputEnergy = solarInputEnergy;
	}

	private String date;
	
	private String siteTypeId;
	
	private String deviceType;
	
	private String smSiteCode;
	
	private Double mdgEnergy;
	
	private Double dgEnergy;
	
	private Double batteryDisEnergy;
	
	private Double batteryChargingEnergy;
	
	private Double teleEnergy;
	
	private Double inverterEnergy;
	
	private Double communityLoadEnergy;
	
	private Double solarOutputEnergy;
	
	private Double solarInputEnergy;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(String siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getSmSiteCode() {
		return smSiteCode;
	}

	public void setSmSiteCode(String smSiteCode) {
		this.smSiteCode = smSiteCode;
	}

	public Double getMdgEnergy() {
		return mdgEnergy;
	}

	public void setMdgEnergy(Double mdgEnergy) {
		this.mdgEnergy = mdgEnergy;
	}

	public Double getDgEnergy() {
		return dgEnergy;
	}

	public void setDgEnergy(Double dgEnergy) {
		this.dgEnergy = dgEnergy;
	}

	public Double getBatteryDisEnergy() {
		return batteryDisEnergy;
	}

	public void setBatteryDisEnergy(Double batteryDisEnergy) {
		this.batteryDisEnergy = batteryDisEnergy;
	}

	public Double getBatteryChargingEnergy() {
		return batteryChargingEnergy;
	}

	public void setBatteryChargingEnergy(Double batteryChargingEnergy) {
		this.batteryChargingEnergy = batteryChargingEnergy;
	}

	public Double getTeleEnergy() {
		return teleEnergy;
	}

	public void setTeleEnergy(Double teleEnergy) {
		this.teleEnergy = teleEnergy;
	}

	public Double getInverterEnergy() {
		return inverterEnergy;
	}

	public void setInverterEnergy(Double inverterEnergy) {
		this.inverterEnergy = inverterEnergy;
	}

	public Double getCommunityLoadEnergy() {
		return communityLoadEnergy;
	}

	public void setCommunityLoadEnergy(Double communityLoadEnergy) {
		this.communityLoadEnergy = communityLoadEnergy;
	}

	public Double getSolarOutputEnergy() {
		return solarOutputEnergy;
	}

	public void setSolarOutputEnergy(Double solarOutputEnergy) {
		this.solarOutputEnergy = solarOutputEnergy;
	}

	public Double getSolarInputEnergy() {
		return solarInputEnergy;
	}

	public void setSolarInputEnergy(Double solarInputEnergy) {
		this.solarInputEnergy = solarInputEnergy;
	}
}
