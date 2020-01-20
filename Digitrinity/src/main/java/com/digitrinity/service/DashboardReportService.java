/**
 * 
 */
package com.digitrinity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.digitrinity.model.*;
import com.digitrinity.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitrinity.dto.AlarmCategoryDto;
import com.digitrinity.dto.AlarmSeverityDto;
import com.digitrinity.dto.AlarmStatusDto;
import com.digitrinity.dto.CustomerDto;
import com.digitrinity.dto.HourlyReportDto;
import com.digitrinity.dto.LatestReportDto;
import com.digitrinity.dto.LatestReportStatusDto;
import com.digitrinity.dto.SiteCodeDto;
import com.digitrinity.dto.SiteTypeDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	private UserRoleRepository userRoleRepository;

	@Autowired
	UserService userService;
	@Autowired
	private ZoneMasterRepository zoneMasterRepository;
	
	@Autowired
	private RegionMasterRepository regionMasterRepository;
	
	@Autowired
	private HourlyReportRepository hourlyReportRepository;
	
	@Autowired
	private AlarmStatusRepository alarmStatusRepository;
	
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
	public List<LatestDataReport> getFilteredLatestReportData(LatestReportDto latestReportDto, HttpServletRequest request) {
	List<RoleUsers> roleUsers=new ArrayList<>();
List<String> siteType= new ArrayList<>();
		if (request.getUserPrincipal() != null) {
			Users user = userService.findByUsername(request.getUserPrincipal().getName());
			for (Role s : user.getRoles()) {
				roleUsers.add(userRoleRepository.getOne(s.getId()));
			}
			}


		for (RoleUsers r:roleUsers){
			siteType.add(String.valueOf(r.getTee()));
			siteType.add(String.valueOf(r.getHybrid()));
			siteType.add(String.valueOf(r.getLithiumIon()));
		}

		return getFilteredLatestReportData(latestReportDto,siteType);
	}

	@Override
	public List<LatestDataReport> getFilteredLatestReportData(LatestReportDto latestReportDto,List<String> siteType) {

		List<LatestDataReport> dataReports = new ArrayList<LatestDataReport>();
		if(latestReportDto.isAnyFilterEmpty()) {
			return dataReports;
		}else if(latestReportDto.isAllClusters() && latestReportDto.isAllCustomers() 
				&& latestReportDto.isAllSiteId() && latestReportDto.isAllSiteTypes()
				&& latestReportDto.isAllRegions() && latestReportDto.isAllZones() && latestReportDto.isAllSiteStatus()){
			dataReports = latestDataReportRepository.findAll();
		} else {
			dataReports = latestDataReportRepository.findLatestReport(latestReportDto.isAllRegions() ? null : latestReportDto.getRegions(), 
					latestReportDto.isAllZones() ? null : latestReportDto.getZones(), 
					latestReportDto.isAllClusters() ? null : latestReportDto.getClusters(), 
					latestReportDto.isAllSiteId() ? null : latestReportDto.getSiteId(), 
					latestReportDto.isAllCustomers() ? null : latestReportDto.getCustomers(), 
					latestReportDto.isAllSiteTypes() ? siteType :siteType,
					latestReportDto.isAllSiteTypes() ? null : ALL,
					latestReportDto.isAllCustomers() ? null : ALL,
					latestReportDto.isAllSiteId() ? null : ALL,
					latestReportDto.isAllClusters() ? null : ALL,
					latestReportDto.isAllZones() ? null : ALL,
					latestReportDto.isAllRegions() ? null : ALL,
					latestReportDto.isAllSiteStatus() ? null : latestReportDto.getSiteStatus()
					);
		}
		
		return dataReports.stream().filter(dataReport -> Objects.nonNull(dataReport)).collect(Collectors.toList());
	}

	@Override
	public List<HourlyReportGroup> getLatestHourlReportData(HourlyReportDto requestDto) {
		String date = requestDto.getDate();
		String startDate = date.split("-")[0].trim().replaceAll("/", "-");
		String endDate = date.split("-")[1].trim().replaceAll("/", "-");
		
		if(requestDto.isAnyFilterEmpty()) {
			return new ArrayList<HourlyReportGroup>();
		}
		if(requestDto.isAllDeviceTypes() && requestDto.isAllSiteId() && requestDto.isAllSiteTypes()) {
			return hourlyReportRepository.latestHourlyDateGroupBy(startDate, endDate);
		} else {
			return hourlyReportRepository.filteredLatestHourlyDateGroupBy(startDate, endDate, 
					requestDto.isAllSiteTypes()? null : ALL,
					requestDto.getSiteType(),
					requestDto.isAllDeviceTypes() ? null : ALL,
					requestDto.getDeviceType(),
					requestDto.isAllSiteId() ? null : ALL,
					requestDto.getSiteId());
		}
		
		
	}

	@Override
	public List<String> fetchDeviceTypes() {
		List<String> deviceTypes = hourlyReportRepository.fetchDeviceTypes();
		return deviceTypes;
	}

	@Override
	public LatestReportStatusDto getLatestReportStatus() {
		long total = latestDataReportRepository.countByAge("-1");
		long offline = latestDataReportRepository.countByAge("4");
		return new LatestReportStatusDto(total, total-offline, offline);
	}

	@Override
	public List<AlarmCategoryDto> getAlarmCategory() {
		return AlarmCategoryDto.generate(alarmStatusRepository.fetchAlarmCategory());
	}

	@Override
	public List<AlarmSeverityDto> getAlarmSeverity() {
		return AlarmSeverityDto.generate(alarmStatusRepository.fetchAlarmSeverity());
	}

	@Override
	public List<AlarmStatus> getAlarmStatus(AlarmStatusDto alarmStatusDto) {
		
		List<AlarmStatus> alarmStatus;
		
		if(alarmStatusDto.isAnyFilterEmpty()) {
			alarmStatus = new ArrayList<AlarmStatus>();
		}
		else if(alarmStatusDto.isAllCategory() && alarmStatusDto.isAllSeverity() && alarmStatusDto.isAllSiteId()) {
			alarmStatus = (List<AlarmStatus>) alarmStatusRepository.findAll();
		} else {
			alarmStatus = alarmStatusRepository.fetchAlarmStatus(alarmStatusDto.getSiteId(), alarmStatusDto.getCategories(), alarmStatusDto.getSeverities(), 
					alarmStatusDto.isAllSiteId() ? null : ALL, alarmStatusDto.isAllCategory() ? null : ALL, alarmStatusDto.isAllSeverity() ? null : ALL);
		}
		return alarmStatus;
	}

}
