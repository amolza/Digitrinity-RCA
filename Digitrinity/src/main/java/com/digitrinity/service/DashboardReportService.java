/**
 * 
 */
package com.digitrinity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.digitrinity.dto.CustomerDto;
import com.digitrinity.dto.LatestReportDto;
import com.digitrinity.dto.SiteCodeDto;
import com.digitrinity.dto.SiteTypeDto;
import com.digitrinity.model.ClusterMaster;
import com.digitrinity.model.LatestDataReport;
import com.digitrinity.model.RegionMaster;
import com.digitrinity.model.SiteMaster;
import com.digitrinity.model.ZoneMaster;
import com.digitrinity.repository.ClusterMasterRepository;
import com.digitrinity.repository.LatestDataReportRepository;
import com.digitrinity.repository.RegionMasterRepository;
import com.digitrinity.repository.SiteMasterRepository;
import com.digitrinity.repository.ZoneMasterRepository;

@Service
public class DashboardReportService implements IDashboardReportService {

	private final String ALL = "All";
	
	@Autowired
	private LatestDataReportRepository latestDataReportRepository;  
	
	@Autowired
	private SiteMasterRepository siteMasterRepository;
	
	@Autowired
	private ClusterMasterRepository clusterMasterRepository;	
	
	@Autowired
	private ZoneMasterRepository zoneMasterRepository;
	
	@Autowired
	private RegionMasterRepository regionMasterRepository;
	
	@Override
	public List<LatestDataReport> getLatestReportData() {
		return latestDataReportRepository.findAll();		
	}

	@Override
	public List<SiteMaster> getSiteMaster() {
		return siteMasterRepository.findAll();
	}

	@Override
	public List<CustomerDto> getCustomerNames() {
		return CustomerDto.generate(siteMasterRepository.fetchCustomerNames());
	}

	@Override
	public List<SiteTypeDto> getSiteType() {
		return SiteTypeDto.generate(siteMasterRepository.fetchSiteTypeId());
	}

	@Override
	public List<SiteCodeDto> getSiteCode() {
		return SiteCodeDto.generate(siteMasterRepository.fetchSiteCode());
	}

	@Override
	public List<ClusterMaster> getClusters() {
		return clusterMasterRepository.findAllByOrderByCrNameAsc();
	}

	@Override
	public List<ZoneMaster> getZones() {
		return zoneMasterRepository.findAllByOrderByZnZoneAsc();
	}

	@Override
	public List<RegionMaster> getRegions() {
		return regionMasterRepository.findAllByOrderByRgRegionAsc();
	}

	@Override
	public List<LatestDataReport> getFilteredLatestReportData(LatestReportDto latestReportDto) {
		System.out.println(latestReportDto);
		List<LatestDataReport> dataReports = new ArrayList<LatestDataReport>();
		if(latestReportDto.isAnyFilterEmpty()) {
			return dataReports;
		}else if(latestReportDto.isAllClusters() && latestReportDto.isAllCustomers() 
				&& latestReportDto.isAllSiteId() && latestReportDto.isAllSiteTypes()
				&& latestReportDto.isAllRegions() && latestReportDto.isAllZones()){
			dataReports = latestDataReportRepository.findAll();
		} else {
			dataReports = latestDataReportRepository.findLatestReport(latestReportDto.isAllRegions() ? null : latestReportDto.getRegions(), 
					latestReportDto.isAllZones() ? null : latestReportDto.getZones(), 
					latestReportDto.isAllClusters() ? null : latestReportDto.getClusters(), 
					latestReportDto.isAllSiteId() ? null : latestReportDto.getSiteId(), 
					latestReportDto.isAllCustomers() ? null : latestReportDto.getCustomers(), 
					latestReportDto.isAllSiteTypes() ? null : latestReportDto.getSiteType(),
					latestReportDto.isAllSiteTypes() ? null : ALL,
					latestReportDto.isAllCustomers() ? null : ALL,
					latestReportDto.isAllSiteId() ? null : ALL,
					latestReportDto.isAllClusters() ? null : ALL,
					latestReportDto.isAllZones() ? null : ALL,
					latestReportDto.isAllRegions() ? null : ALL
					);
		}
		return dataReports;
	}

}
