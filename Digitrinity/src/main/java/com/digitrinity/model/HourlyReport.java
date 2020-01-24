package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_HourlyData")
public class HourlyReport {

	@Id
	@Column(name="date")
	private String date;
	
	@Column(name="sitetypeid")
	private String siteTypeId;
	
	@Column(name="Devicetype")
	private String deviceType;
	
	@Column(name="smSiteCode")
	private String smSiteCode;
	
	@Column(name="MDG_Energy")
	private Double mdgEnergy;
	
	@Column(name="DG_Energy")
	private Double dgEnergy;
	
	@Column(name="Batt_DisEnergy")
	private Double batteryDisEnergy;
	
	@Column(name="Batt_ChargingEnergy")
	private Double batteryChargingEnergy;
	
	@Column(name="TeleEnergy")
	private Double teleEnergy;
	
	@Column(name="InverterEnergy")
	private Double inverterEnergy;
	
	@Column(name="CommunityLoad_Energy")
	private Double communityLoadEnergy;
	
	@Column(name="Solar_Output_Energy")
	private Double solarOutputEnergy;
	
	@Column(name="Solar_Input_Energy")
	private Double solarInputEnergy;

	@Column(name="tran_date")
	private String tranDate;

	@Column(name = "customer_id")
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

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

	@Override
	public String toString() {
		return "HourlyReport [date=" + date + ", siteTypeId=" + siteTypeId + ", deviceType=" + deviceType
				+ ", smSiteCode=" + smSiteCode + ", mdgEnergy=" + mdgEnergy + ", dgEnergy=" + dgEnergy
				+ ", batteryDisEnergy=" + batteryDisEnergy + ", batteryChargingEnergy=" + batteryChargingEnergy
				+ ", teleEnergy=" + teleEnergy + ", inverterEnergy=" + inverterEnergy + ", communityLoadEnergy="
				+ communityLoadEnergy + ", solarOutputEnergy=" + solarOutputEnergy + ", solarInputEnergy="
				+ solarInputEnergy + "]";
	}
	
	
	
}
