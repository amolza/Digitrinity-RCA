package com.digitrinity.formBeans;

import java.sql.Date;

public class RCAReportFormBean {
	private Date rcaDate;
	private String faultID;
	private String faultCategory;
	private int outageCatID;
	private String outageCategory;
	private long rcaid;
	private String anchorOprtr;
	private String opcoId;
	private int rgRegionID;
	private Integer znZoneID;
	private String rgRegion;
	private Integer rgAcsysSyncstatus;
	private Integer rgAcsysSyncDateTime;
	private Integer accID;
	private int smSiteID;
	private String smSitecode;
	private String smSitename;
	private String issueCatID;
	private String issuename;
	private Date siteDownTime;
	private Date restoredTime;
	private String siteDownDuration;
	private String rca;
	private int outageInMinutes;
	private double sla;
	
	public void clear()
	{
		this.rcaDate=null;                  
		this.faultID="";                
		this.faultCategory="";         
		this.outageCatID=0;                
		this.outageCategory="";         
		this. rcaid=0l;                     
		this.anchorOprtr="";         
		this.opcoId="";                
		this.rgRegionID=0;               
		this.znZoneID=null;               
		this.rgRegion="";                 
		this.rgAcsysSyncstatus=null;      
		this.rgAcsysSyncDateTime=null;    
		this.accID=null;                  
		this. smSiteID=0;                   
		this.smSitecode="";             
		this.smSitename="";            
		this.issueCatID="";           
		this.issuename="";              
		this.siteDownTime=null;             
		this.restoredTime=null;             
		this.siteDownDuration="";     
		this.rca="";                    
		this.outageInMinutes=0;           
		this.sla=0.0;                   
	}
	public Date getRcaDate() {
		return rcaDate;
	}
	public void setRcaDate(Date rcaDate) {
		this.rcaDate = rcaDate;
	}
	public String getFaultID() {
		return faultID;
	}
	public void setFaultID(String faultID) {
		this.faultID = faultID;
	}
	public String getFaultCategory() {
		return faultCategory;
	}
	public void setFaultCategory(String faultCategory) {
		this.faultCategory = faultCategory;
	}
	public int getOutageCatID() {
		return outageCatID;
	}
	public void setOutageCatID(int outageCatID) {
		this.outageCatID = outageCatID;
	}
	public String getOutageCategory() {
		return outageCategory;
	}
	public void setOutageCategory(String outageCategory) {
		this.outageCategory = outageCategory;
	}
	public long getRcaid() {
		return rcaid;
	}
	public void setRcaid(long rcaid) {
		this.rcaid = rcaid;
	}
	public String getAnchorOprtr() {
		return anchorOprtr;
	}
	public void setAnchorOprtr(String anchorOprtr) {
		this.anchorOprtr = anchorOprtr;
	}
	public String getOpcoId() {
		return opcoId;
	}
	public void setOpcoId(String opcoId) {
		this.opcoId = opcoId;
	}
	public int getRgRegionID() {
		return rgRegionID;
	}
	public void setRgRegionID(int rgRegionID) {
		this.rgRegionID = rgRegionID;
	}
	public Integer getZnZoneID() {
		return znZoneID;
	}
	public void setZnZoneID(Integer znZoneID) {
		this.znZoneID = znZoneID;
	}
	public String getRgRegion() {
		return rgRegion;
	}
	public void setRgRegion(String rgRegion) {
		this.rgRegion = rgRegion;
	}
	public Integer getRgAcsysSyncstatus() {
		return rgAcsysSyncstatus;
	}
	public void setRgAcsysSyncstatus(Integer rgAcsysSyncstatus) {
		this.rgAcsysSyncstatus = rgAcsysSyncstatus;
	}
	public Integer getRgAcsysSyncDateTime() {
		return rgAcsysSyncDateTime;
	}
	public void setRgAcsysSyncDateTime(Integer rgAcsysSyncDateTime) {
		this.rgAcsysSyncDateTime = rgAcsysSyncDateTime;
	}
	public Integer getAccID() {
		return accID;
	}
	public void setAccID(Integer accID) {
		this.accID = accID;
	}
	public int getSmSiteID() {
		return smSiteID;
	}
	public void setSmSiteID(int smSiteID) {
		this.smSiteID = smSiteID;
	}
	public String getSmSitecode() {
		return smSitecode;
	}
	public void setSmSitecode(String smSitecode) {
		this.smSitecode = smSitecode;
	}
	public String getSmSitename() {
		return smSitename;
	}
	public void setSmSitename(String smSitename) {
		this.smSitename = smSitename;
	}
	public String getIssueCatID() {
		return issueCatID;
	}
	public void setIssueCatID(String issueCatID) {
		this.issueCatID = issueCatID;
	}
	public String getIssuename() {
		return issuename;
	}
	public void setIssuename(String issuename) {
		this.issuename = issuename;
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
