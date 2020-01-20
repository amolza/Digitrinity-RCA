package com.digitrinity.service;

import java.util.List;

import com.digitrinity.dto.AlarmCategoryDto;
import com.digitrinity.dto.AlarmSeverityDto;
import com.digitrinity.dto.AlarmStatusDto;
import com.digitrinity.dto.CustomerDto;
import com.digitrinity.dto.HourlyReportDto;
import com.digitrinity.dto.LatestReportDto;
import com.digitrinity.dto.LatestReportStatusDto;
import com.digitrinity.dto.SiteCodeDto;
import com.digitrinity.dto.SiteTypeDto;
import com.digitrinity.model.AlarmStatus;
import com.digitrinity.model.ClusterMaster;
import com.digitrinity.model.HourlyReportGroup;
import com.digitrinity.model.LatestDataReport;
import com.digitrinity.model.RegionMaster;
import com.digitrinity.model.SiteMaster;
import com.digitrinity.model.ZoneMaster;

import javax.servlet.http.HttpServletRequest;

public interface IDashboardReportService {

	public List<LatestDataReport> getLatestReportData();
	
	public List<LatestDataReport> getFilteredLatestReportData(LatestReportDto latestReportDto,List<String> siteType);
	public List<LatestDataReport> getFilteredLatestReportData(LatestReportDto latestReportDto, HttpServletRequest request);
	public List<SiteMaster> getSiteMaster();
	
	public List<CustomerDto> getCustomerNames();
	
	public List<SiteTypeDto> getSiteType();
	
	public List<SiteCodeDto> getSiteCode();
	
	public List<ClusterMaster> getClusters();
	
	public List<ZoneMaster> getZones();
	
	public List<RegionMaster> getRegions();
	
	public List<HourlyReportGroup> getLatestHourlReportData(HourlyReportDto requestDto);
	
	public List<String> fetchDeviceTypes();
	
	public LatestReportStatusDto getLatestReportStatus();
	
	public List<AlarmCategoryDto> getAlarmCategory();
	
	public List<AlarmSeverityDto> getAlarmSeverity();
	
	public List<AlarmStatus> getAlarmStatus(AlarmStatusDto alarmStatusDto);
	
}
