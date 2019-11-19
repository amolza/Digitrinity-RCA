package com.digitrinity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rca_report")
public class RcaReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rcaid;

	@Column(name = "Date")
	private java.util.Date rcaDate;

	@Column(name = "smSitecode")
	private String smSiteID;

	@Column(name = "smSitename")
	private String smSitename;

	@Column(name = "rgRegionID")
	private int rgRegionID;

	@Column(name = "AnchorOprtr")
	private String anchorOprtr;

	@Column(name = "OPCO_ID")
	private String opcoID;

	@Column(name = "SiteDownTime")
	private Date siteDownTime;

	@Column(name = "RestoredTime")
	private Date restoredTime;

	@Column(name = "SiteDownDuration")
	private String siteDownDuration;

	@Column(name = "IssueCatID")
	private int issueCatID;

	@Column(name = "OutageCatID")
	private int outageCatID;

	@Column(name = "FaultID")
	private int faultID;

	@Column(name = "RCA")
	private String rca;

	@Column(name = "OutageInMinutes")
	private int outageInMinutes;

	@Column(name = "SLA")
	private double sla;

	public Long getRcaid() {
		return rcaid;
	}

	public void setRcaid(Long rcaid) {
		this.rcaid = rcaid;
	}

	public java.util.Date getRcaDate() {
		return rcaDate;
	}

	public void setRcaDate(java.util.Date rcaDate) {
		this.rcaDate = rcaDate;
	}

	

	public String getSmSiteID() {
		return smSiteID;
	}

	public void setSmSiteID(String smSiteID) {
		this.smSiteID = smSiteID;
	}

	public String getSmSitename() {
		return smSitename;
	}

	public void setSmSitename(String smSitename) {
		this.smSitename = smSitename;
	}

	public int getRgRegionID() {
		return rgRegionID;
	}

	public void setRgRegionID(int rgRegionID) {
		this.rgRegionID = rgRegionID;
	}

	public String getAnchorOprtr() {
		return anchorOprtr;
	}

	public void setAnchorOprtr(String anchorOprtr) {
		this.anchorOprtr = anchorOprtr;
	}

	public String getOpcoID() {
		return opcoID;
	}

	public void setOpcoID(String opcoID) {
		this.opcoID = opcoID;
	}

	public Date getSiteDownTime() {
		return siteDownTime;
	}

	public void setSiteDownTime(Date siteDownTime) {
		this.siteDownTime = siteDownTime;
	}

	public Date getRestoredTime() {
		return restoredTime;
	}

	public void setRestoredTime(Date restoredTime) {
		this.restoredTime = restoredTime;
	}

	public String getSiteDownDuration() {
		return siteDownDuration;
	}

	public void setSiteDownDuration(String siteDownDuration) {
		this.siteDownDuration = siteDownDuration;
	}

	public int getIssueCatID() {
		return issueCatID;
	}

	public void setIssueCatID(int issueCatID) {
		this.issueCatID = issueCatID;
	}

	public int getOutageCatID() {
		return outageCatID;
	}

	public void setOutageCatID(int outageCatID) {
		this.outageCatID = outageCatID;
	}

	public int getFaultID() {
		return faultID;
	}

	public void setFaultID(int faultID) {
		this.faultID = faultID;
	}

	public String getRca() {
		return rca;
	}

	public void setRca(String rca) {
		this.rca = rca;
	}

	public int getOutageInMinutes() {
		return outageInMinutes;
	}

	public void setOutageInMinutes(int outageInMinutes) {
		this.outageInMinutes = outageInMinutes;
	}

	public double getSla() {
		return sla;
	}

	public void setSla(double sla) {
		this.sla = sla;
	}

	
	
}