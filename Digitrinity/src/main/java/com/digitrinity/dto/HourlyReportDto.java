package com.digitrinity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HourlyReportDto implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String ALL = "All";
	
	List<String> labels= new ArrayList<String>();
	
	private List<String> siteId = new ArrayList<String>();;
	private List<String> deviceType = new ArrayList<String>();;	
	private List<String> siteType = new ArrayList<String>();;	
	private String date = "";
	
	List<DataSet> dataSets = new ArrayList<DataSet>();

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<DataSet> getDataSets() {
		return dataSets;
	}

	public void setDataSets(List<DataSet> dataSets) {
		this.dataSets = dataSets;
	}

	public List<String> getSiteId() {
		return siteId;
	}

	public void setSiteId(List<String> siteId) {
		this.siteId = siteId;
	}

	public List<String> getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(List<String> deviceType) {
		this.deviceType = deviceType;
	}

	public List<String> getSiteType() {
		return siteType;
	}

	public void setSiteType(List<String> siteType) {
		this.siteType = siteType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public boolean isAllSiteId() {
		return this.getSiteId().contains(ALL);
	}
	
	public boolean isAllSiteTypes() {
		return this.getSiteType().contains(ALL);
	}
	
	public boolean isAllDeviceTypes() {
		return this.getDeviceType().contains(ALL);
	}
	
	public boolean isAnyFilterEmpty() {
		return this.getSiteId().isEmpty() || this.getSiteType().isEmpty() || this.getDeviceType().isEmpty();
	}
	
}
