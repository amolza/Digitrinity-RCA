package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "V_latestData")
@IdClass(LatestDataReportComposite.class)
public class LatestDataReport {
	
	@Id
	@Column(name="Last_Updated")
	private String lastUpdated;
	
	@Column(name="Ageing")
	private String age;
	
	@Column(name="clusterName")
	private String clusterName;
	
	@Column(name = "smSitetypeid")
	private String siteTypeId;
	
	@Column(name="Zone")
	private String zone;
	
	@Column(name="Region")	
	private String region;
	
	@Id
	@Column(name="smSitecode")
	private String smSiteCode;
	
	@Column(name="Site_Name")
	private String siteName;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="CustomerName")
	private String customerName;
	
	@Column(name="Powersource")
	private String powerSource;
	
	@Column(name="Engineer_Name")
	private String engineerName;
	
	@Column(name="Solar_Kw")
	private String solarKw;
	
	@Column(name="DC_Voltage")
	private String dcVoltage;
	
	@Column(name="Battery_SOC")
	private String batterySOC;
	
	@Column(name="DC_Load")
	private String dcLoad;
	
	@Column(name="DG_Power")
	private String dgPower;
	
	@Column(name="fuellevel_ltrs")
	private String fuelLevel;
	
	@Column(name="Critical")
	private String critical;
	
	@Column(name="Major")
	private String major;
	
	@Column(name="Minor")
	private String minor;

	@Column(name = "is_offline")
	private int isOffline;

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(String siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSmSiteCode() {
		return smSiteCode;
	}

	public void setSmSiteCode(String smSiteCode) {
		this.smSiteCode = smSiteCode;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPowerSource() {
		return powerSource;
	}

	public void setPowerSource(String powerSource) {
		this.powerSource = powerSource;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	public String getSolarKw() {
		return solarKw;
	}

	public void setSolarKw(String solarKw) {
		this.solarKw = solarKw;
	}

	public String getDcVoltage() {
		return dcVoltage;
	}

	public void setDcVoltage(String dcVoltage) {
		this.dcVoltage = dcVoltage;
	}

	public String getBatterySOC() {
		return batterySOC;
	}

	public void setBatterySOC(String batterySOC) {
		this.batterySOC = batterySOC;
	}

	public String getDcLoad() {
		return dcLoad;
	}

	public void setDcLoad(String dcLoad) {
		this.dcLoad = dcLoad;
	}

	public String getDgPower() {
		return dgPower;
	}

	public void setDgPower(String dgPower) {
		this.dgPower = dgPower;
	}

	public String getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(String fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public String getCritical() {
		return critical;
	}

	public void setCritical(String critical) {
		this.critical = critical;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public int getIsOffline() {
		return isOffline;
	}

	public void setIsOffline(int isOffline) {
		this.isOffline = isOffline;
	}
}
