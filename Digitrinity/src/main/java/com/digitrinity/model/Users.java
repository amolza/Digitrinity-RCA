package com.digitrinity.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long umID;
	
	@Column(name = "utID")
	private Long utID;
	
	@Column(name = "umName")
	private String umName;
	@Column(name = "umDescription")
	private String umDescription;
	@Column(name = "umLoginName")
	private String username;
	@Column(name = "umLoginPassword")
	private String password;
	@Transient
	private String passwordConfirm;
	@Column(name = "umEmailid")
	private String umEmailid;
	@Column(name = "umMobileNumber")
	private String umMobileNumber;
	@Column(name = "umAactivationstatus")
	private int umAactivationstatus;
	@Column(name = "umType")
	private int umType;
	@Column(name = "umDateTimeFormat")
	private String umDateTimeFormat;
	@Column(name = "umRefreshRate")
	private int umRefreshRate;
	@Column(name = "umRecordsPerPage")
	private int umRecordsPerPage;
	@Column(name = "umAlarmDisplay")
	private int umAlarmDisplay;
	@Column(name = "umAlarmHistory")
	private int umAlarmHistory;
	@Column(name = "umInitialZoom")
	private int umInitialZoom;
	@Column(name = "umPopupflag")
	private int umPopupflag;
	@Column(name = "umRowsPerPopup")
	private int umRowsPerPopup;
	@Column(name = "umLocationPopup")
	private int umLocationPopup;
	@Column(name = "umDefaultColumnSort")
	private String umDefaultColumnSort;
	@Column(name = "umNoofMessages")
	private int umNoofMessages;
	@Column(name = "umCircleAccessMode")
	private int umCircleAccessMode;
	@Column(name = "umClusterAccessMode")
	private int umClusterAccessMode;
	@Column(name = "umLandingPageUrl")
	private String umLandingPageUrl;
	@Column(name = "umLoginIP")
	private String umLoginIP;
	@Column(name = "umLoginStatus")
	private int umLoginStatus;
	@Column(name = "umLoginTime")
	private int umLoginTime;
	@Column(name = "umSessionID")
	private String umSessionID;
	@Column(name = "umSessionResetMsg")
	private String umSessionResetMsg;
	@Column(name = "umSiteAccessMode")
	private int umSiteAccessMode;
	@Column(name = "umTenantAccessMode")
	private int umTenantAccessMode;
	@Column(name = "umLanguage")
	private String umLanguage;
	@Column(name = "umAlarmPins")
	private String umAlarmPins;
	@Column(name = "umDashboardLevelIds")
	private String umDashboardLevelIds;
	@Column(name = "umGCMRergistrationID")
	private String umGCMRergistrationID;
	@Column(name = "umMobileEmployeeID")
	private int umMobileEmployeeID;
	@Column(name = "acAccID")
	private int acAccID;
	@Column(name = "umCreateddt")
	private int umCreateddt;
	@Column(name = "umCreatedby")
	private String umCreatedby;
	@Column(name = "umLastupdateddt")
	private int umLastupdateddt;
	@Column(name = "umLastupdatedby")
	private String umLastupdatedby;

	@ManyToMany
	private Set<Role> roles;

	
	public Long getUmID() {
		return umID;
	}

	public void setUmID(Long umID) {
		this.umID = umID;
	}

	public Long getUtID() {
		return utID;
	}

	public void setUtID(Long utID) {
		this.utID = utID;
	}

	public String getUmName() {
		return umName;
	}

	public void setUmName(String umName) {
		this.umName = umName;
	}

	public String getUmDescription() {
		return umDescription;
	}

	public void setUmDescription(String umDescription) {
		this.umDescription = umDescription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String umLoginName) {
		this.username = umLoginName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String umLoginPassword) {
		this.password = umLoginPassword;
	}

	

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getUmEmailid() {
		return umEmailid;
	}

	public void setUmEmailid(String umEmailid) {
		this.umEmailid = umEmailid;
	}

	public String getUmMobileNumber() {
		return umMobileNumber;
	}

	public void setUmMobileNumber(String umMobileNumber) {
		this.umMobileNumber = umMobileNumber;
	}

	public int getUmAactivationstatus() {
		return umAactivationstatus;
	}

	public void setUmAactivationstatus(int umAactivationstatus) {
		this.umAactivationstatus = umAactivationstatus;
	}

	public int getUmType() {
		return umType;
	}

	public void setUmType(int umType) {
		this.umType = umType;
	}

	public String getUmDateTimeFormat() {
		return umDateTimeFormat;
	}

	public void setUmDateTimeFormat(String umDateTimeFormat) {
		this.umDateTimeFormat = umDateTimeFormat;
	}

	public int getUmRefreshRate() {
		return umRefreshRate;
	}

	public void setUmRefreshRate(int umRefreshRate) {
		this.umRefreshRate = umRefreshRate;
	}

	public int getUmRecordsPerPage() {
		return umRecordsPerPage;
	}

	public void setUmRecordsPerPage(int umRecordsPerPage) {
		this.umRecordsPerPage = umRecordsPerPage;
	}

	public int getUmAlarmDisplay() {
		return umAlarmDisplay;
	}

	public void setUmAlarmDisplay(int umAlarmDisplay) {
		this.umAlarmDisplay = umAlarmDisplay;
	}

	public int getUmAlarmHistory() {
		return umAlarmHistory;
	}

	public void setUmAlarmHistory(int umAlarmHistory) {
		this.umAlarmHistory = umAlarmHistory;
	}

	public int getUmInitialZoom() {
		return umInitialZoom;
	}

	public void setUmInitialZoom(int umInitialZoom) {
		this.umInitialZoom = umInitialZoom;
	}

	public int getUmPopupflag() {
		return umPopupflag;
	}

	public void setUmPopupflag(int umPopupflag) {
		this.umPopupflag = umPopupflag;
	}

	public int getUmRowsPerPopup() {
		return umRowsPerPopup;
	}

	public void setUmRowsPerPopup(int umRowsPerPopup) {
		this.umRowsPerPopup = umRowsPerPopup;
	}

	public int getUmLocationPopup() {
		return umLocationPopup;
	}

	public void setUmLocationPopup(int umLocationPopup) {
		this.umLocationPopup = umLocationPopup;
	}

	public String getUmDefaultColumnSort() {
		return umDefaultColumnSort;
	}

	public void setUmDefaultColumnSort(String umDefaultColumnSort) {
		this.umDefaultColumnSort = umDefaultColumnSort;
	}

	public int getUmNoofMessages() {
		return umNoofMessages;
	}

	public void setUmNoofMessages(int umNoofMessages) {
		this.umNoofMessages = umNoofMessages;
	}

	public int getUmCircleAccessMode() {
		return umCircleAccessMode;
	}

	public void setUmCircleAccessMode(int umCircleAccessMode) {
		this.umCircleAccessMode = umCircleAccessMode;
	}

	public int getUmClusterAccessMode() {
		return umClusterAccessMode;
	}

	public void setUmClusterAccessMode(int umClusterAccessMode) {
		this.umClusterAccessMode = umClusterAccessMode;
	}

	public String getUmLandingPageUrl() {
		return umLandingPageUrl;
	}

	public void setUmLandingPageUrl(String umLandingPageUrl) {
		this.umLandingPageUrl = umLandingPageUrl;
	}

	public String getUmLoginIP() {
		return umLoginIP;
	}

	public void setUmLoginIP(String umLoginIP) {
		this.umLoginIP = umLoginIP;
	}

	public int getUmLoginStatus() {
		return umLoginStatus;
	}

	public void setUmLoginStatus(int umLoginStatus) {
		this.umLoginStatus = umLoginStatus;
	}

	public int getUmLoginTime() {
		return umLoginTime;
	}

	public void setUmLoginTime(int umLoginTime) {
		this.umLoginTime = umLoginTime;
	}

	public String getUmSessionID() {
		return umSessionID;
	}

	public void setUmSessionID(String umSessionID) {
		this.umSessionID = umSessionID;
	}

	public String getUmSessionResetMsg() {
		return umSessionResetMsg;
	}

	public void setUmSessionResetMsg(String umSessionResetMsg) {
		this.umSessionResetMsg = umSessionResetMsg;
	}

	public int getUmSiteAccessMode() {
		return umSiteAccessMode;
	}

	public void setUmSiteAccessMode(int umSiteAccessMode) {
		this.umSiteAccessMode = umSiteAccessMode;
	}

	public int getUmTenantAccessMode() {
		return umTenantAccessMode;
	}

	public void setUmTenantAccessMode(int umTenantAccessMode) {
		this.umTenantAccessMode = umTenantAccessMode;
	}

	public String getUmLanguage() {
		return umLanguage;
	}

	public void setUmLanguage(String umLanguage) {
		this.umLanguage = umLanguage;
	}

	public String getUmAlarmPins() {
		return umAlarmPins;
	}

	public void setUmAlarmPins(String umAlarmPins) {
		this.umAlarmPins = umAlarmPins;
	}

	public String getUmDashboardLevelIds() {
		return umDashboardLevelIds;
	}

	public void setUmDashboardLevelIds(String umDashboardLevelIds) {
		this.umDashboardLevelIds = umDashboardLevelIds;
	}

	public String getUmGCMRergistrationID() {
		return umGCMRergistrationID;
	}

	public void setUmGCMRergistrationID(String umGCMRergistrationID) {
		this.umGCMRergistrationID = umGCMRergistrationID;
	}

	public int getUmMobileEmployeeID() {
		return umMobileEmployeeID;
	}

	public void setUmMobileEmployeeID(int umMobileEmployeeID) {
		this.umMobileEmployeeID = umMobileEmployeeID;
	}

	public int getAcAccID() {
		return acAccID;
	}

	public void setAcAccID(int acAccID) {
		this.acAccID = acAccID;
	}

	public int getUmCreateddt() {
		return umCreateddt;
	}

	public void setUmCreateddt(int umCreateddt) {
		this.umCreateddt = umCreateddt;
	}

	public String getUmCreatedby() {
		return umCreatedby;
	}

	public void setUmCreatedby(String umCreatedby) {
		this.umCreatedby = umCreatedby;
	}

	public int getUmLastupdateddt() {
		return umLastupdateddt;
	}

	public void setUmLastupdateddt(int umLastupdateddt) {
		this.umLastupdateddt = umLastupdateddt;
	}

	public String getUmLastupdatedby() {
		return umLastupdatedby;
	}

	public void setUmLastupdatedby(String umLastupdatedby) {
		this.umLastupdatedby = umLastupdatedby;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}