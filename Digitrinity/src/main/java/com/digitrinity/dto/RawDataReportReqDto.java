package com.digitrinity.dto;

import java.util.List;

public class RawDataReportReqDto {
	
	private final String ALL = "All";

	private int start;
	
	private int length;
	
	private int draw;
	
	private int page;
	private String date = "";
	private List<String> siteId;
	private List<String> deviceType;	
	private List<String> siteType;
	private List<String> clusters;
	private List<String> zones;
	private List<String> regions;
	private int siteStatus;

	public RawDataReportReqDto() {
	}

	public RawDataReportReqDto(int start, int length, int draw) {
		this.start = start;
		this.length = length;
		this.draw = draw;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(int siteStatus) {
		this.siteStatus = siteStatus;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<String> getSiteId() {
		return siteId;
	}

	public void setSiteId(List<String> siteId) {
		this.siteId = siteId;
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

	public List<String> getZones() {
		return zones;
	}

	public void setZones(List<String> zones) {
		this.zones = zones;
	}

	public List<String> getRegions() {
		return regions;
	}

	public void setRegions(List<String> regions) {
		this.regions = regions;
	}
	
	public List<String> getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(List<String> deviceType) {
		this.deviceType = deviceType;
	}

	public boolean isAllSiteId() {
		return this.getSiteId().contains(ALL);
	}
	
	public boolean isAllDeviceType() {
		return this.getDeviceType().contains(ALL);
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
	
	public boolean isAnyFilterEmpty() {
		return this.getClusters().isEmpty() || this.getDeviceType().isEmpty() || this.getRegions().isEmpty() || this.getSiteId().isEmpty() || this.getSiteType().isEmpty() || this.getZones().isEmpty();
	}
	public boolean isAllSiteStatus(){return this.getSiteStatus()==-1;}
}
