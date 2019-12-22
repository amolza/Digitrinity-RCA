package com.digitrinity.dto;

import java.io.Serializable;
import java.util.List;

public class AlarmStatusDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public AlarmStatusDto(List<String> siteId, List<String> categories, List<String> severities) {
		this.siteId = siteId;
		this.categories = categories;
		this.severities = severities;
	}

	private final String ALL = "All";

	private List<String> siteId;
	private List<String> categories;
	private List<String> severities;

	public List<String> getSiteId() {
		return siteId;
	}

	public void setSiteId(List<String> siteId) {
		this.siteId = siteId;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getSeverities() {
		return severities;
	}

	public void setSeverities(List<String> severities) {
		this.severities = severities;
	}

	public String getALL() {
		return ALL;
	}
	
	
	public boolean isAllSiteId() {
		return this.getSiteId().contains(ALL);
	}
	
	public boolean isAllCategory() {
		return this.getCategories().contains(ALL);
	}
	
	public boolean isAllSeverity() {
		return this.getSeverities().contains(ALL);
	}
	
	public boolean isAnyFilterEmpty() {
		return this.getSiteId().isEmpty() || this.getCategories().isEmpty() || this.getSeverities().isEmpty();
	}

}
