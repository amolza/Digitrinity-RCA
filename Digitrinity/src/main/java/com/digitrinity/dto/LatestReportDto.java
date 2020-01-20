package com.digitrinity.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@ToString(includeFieldNames=true)
@Data
public class LatestReportDto implements Serializable {	
	private static final long serialVersionUID = -7046112818896100070L;
	
	private final String ALL = "All";
	
	private List<String> siteId;
	private List<String> customers;	
	private List<String> siteType;
	private List<String> clusters;
	private List<String> zones;
	private List<String> regions;
	private int siteStatus;
	
	public List<String> getSiteId() {
		return siteId;
	}
	public void setSiteId(List<String> siteId) {
		this.siteId = siteId;
	}
	public List<String> getCustomers() {
		return customers;
	}
	public void setCustomers(List<String> customer) {
		this.customers = customer;
	}
	public List<String> getSiteType() {
		return siteType;
	}
	public void setSiteType(List<String> siteType) {
		this.siteType = siteType;
	}
	public List<String> getClusters() {
		return clusters;
	}
	public void setClusters(List<String> clusters) {
		this.clusters = clusters;
	}
	
	@Override
	public String toString() {
		return "LatestReportDto [siteId=" + siteId + ", customers=" + customers + ", siteType=" + siteType
				+ ",  siteStatus=" + siteStatus + ",clusters=" + clusters + "]";
	}
	public List<String> getRegions() {
		return regions;
	}
	public void setRegions(List<String> regions) {
		this.regions = regions;
	}

	public int getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(int siteStatus) {
		this.siteStatus = siteStatus;
	}

	public List<String> getZones() {
		return zones;
	}
	public void setZones(List<String> zones) {
		this.zones = zones;
	}
	
	public boolean isAllSiteId() {
		return this.getSiteId().contains(ALL);
	}
	
	public boolean isAllCustomers() {
		return this.getCustomers().contains(ALL);
	}
	
	public boolean isAllSiteTypes() {
		return this.getSiteType().contains(ALL);
	}
	
	public boolean isAllClusters() {
		return this.getClusters().contains(ALL);
	}
	
	public boolean isAllZones() {
		return this.getZones().contains(ALL);
	}
	
	public boolean isAllRegions() {
		return this.getRegions().contains(ALL);
	}

	public boolean isAllSiteStatus(){return this.getSiteStatus()==-1;}
	
	public boolean isAnyFilterEmpty() {
		return this.getClusters().isEmpty() || this.getCustomers().isEmpty() || this.getRegions().isEmpty() || this.getSiteId().isEmpty() || this.getSiteType().isEmpty() || this.getZones().isEmpty();
	}
}
