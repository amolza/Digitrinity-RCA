package com.digitrinity.service;

import java.util.List;

import com.digitrinity.dto.CustomerDto;
import com.digitrinity.dto.HourlyReportDto;
import com.digitrinity.dto.LatestReportDto;
import com.digitrinity.dto.SiteCodeDto;
import com.digitrinity.dto.SiteTypeDto;
import com.digitrinity.model.ClusterMaster;
import com.digitrinity.model.HourlyReportGroup;
import com.digitrinity.model.LatestDataReport;
import com.digitrinity.model.RegionMaster;
import com.digitrinity.model.SiteMaster;
import com.digitrinity.model.ZoneMaster;

public interface IDashboardReportService {

	public List<LatestDataReport> getLatestReportData();
	
	public List<LatestDataReport> getFilteredLatestReportData(LatestReportDto latestReportDto);
	
	public List<SiteMaster> getSiteMaster();
	
	public List<CustomerDto> getCustomerNames();
	
	public List<SiteTypeDto> getSiteType();
	
	public List<SiteCodeDto> getSiteCode();
	
	public List<ClusterMaster> getClusters();
	
	public List<ZoneMaster> getZones();
	
	public List<RegionMaster> getRegions();
	
	public List<HourlyReportGroup> getLatestHourlReportData(HourlyReportDto requestDto);
	
	public List<String> fetchDeviceTypes();
	
}
