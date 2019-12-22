package com.digitrinity.dto;

import java.io.Serializable;

public class LatestReportStatusDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long totalSite;
	
	private Long onlineSite;
	
	private Long offlineSite;

	public Long getTotalSite() {
		return totalSite;
	}

	
	
	public LatestReportStatusDto(Long totalSite, Long onlineSite, Long offlineSite) {
		this.totalSite = totalSite;
		this.onlineSite = onlineSite;
		this.offlineSite = offlineSite;
	}



	public LatestReportStatusDto() {
	}



	public void setTotalSite(Long totalSite) {
		this.totalSite = totalSite;
	}

	public Long getOnlineSite() {
		return onlineSite;
	}

	public void setOnlineSite(Long onlineSite) {
		this.onlineSite = onlineSite;
	}

	public Long getOfflineSite() {
		return offlineSite;
	}

	public void setOfflineSite(Long offlineSite) {
		this.offlineSite = offlineSite;
	}

	
}

