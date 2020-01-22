package com.digitrinity.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.digitrinity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitrinity.dto.AlarmCategoryDto;
import com.digitrinity.dto.AlarmSeverityDto;
import com.digitrinity.dto.AlarmStatusDto;
import com.digitrinity.dto.ClusterDto;
import com.digitrinity.dto.CustomerDto;
import com.digitrinity.dto.DataSet;
import com.digitrinity.dto.DeviceTypeDto;
import com.digitrinity.dto.HourlyReportDto;
import com.digitrinity.dto.LatestReportDto;
import com.digitrinity.dto.LatestReportStatusDto;
import com.digitrinity.dto.RegionDto;
import com.digitrinity.dto.SiteCodeDto;
import com.digitrinity.dto.SiteTypeDto;
import com.digitrinity.dto.ZoneDto;
import com.digitrinity.formBeans.DataTableResponse;
import com.digitrinity.model.ClusterMaster;
import com.digitrinity.model.HourlyReportGroup;
import com.digitrinity.model.RegionMaster;
import com.digitrinity.model.ZoneMaster;
import com.digitrinity.service.IDashboardReportService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "dashboard")
public class DashboardReportController {

	@Autowired
	private IDashboardReportService dashboardReportService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	UserService userService;
	@GetMapping(path = "/latest-data", produces = "application/json")
	public DataTableResponse getLatestReportData() {
		return new DataTableResponse(dashboardReportService.getLatestReportData());
	}

	@PostMapping(path = "/latest-data1", produces = "application/json")
	public DataTableResponse getLatestReportData1(@RequestBody LatestReportDto latestReportDto, HttpServletRequest request) {

		return new DataTableResponse(dashboardReportService.getFilteredLatestReportData(latestReportDto,request));
	}

	@GetMapping(path = "/customer-master", produces = "application/json")
	public List<CustomerDto> getSiteMaster(HttpServletRequest request) {
		return dashboardReportService.getCustomerNames();
	}

	@GetMapping(path = "/site-code-master", produces = "application/json")
	public List<SiteCodeDto> getSiteCodeMaster(HttpServletRequest request) {
		return dashboardReportService.getSiteCode(request);
	}

	@GetMapping(path = "/site-type-master", produces = "application/json")
	public List<SiteTypeDto> getSiteTypeMaster(HttpServletRequest request) {
		return dashboardReportService.getSiteType(request);
	}

	@GetMapping(path = "/cluster-master", produces = "application/json")
	public List<ClusterDto> getClusters(HttpServletRequest request) {
		List<ClusterMaster> clusters = dashboardReportService.getClusters(request);
		List<ClusterDto> collectDto = clusters.stream().map(cluster -> {
			return modelMapper.map(cluster, ClusterDto.class);
		}).collect(Collectors.toList());
		return collectDto;
	}

	@GetMapping(path = "/zone-master", produces = "application/json")
	public List<ZoneDto> getZones(HttpServletRequest request) {
		List<ZoneMaster> clusters = dashboardReportService.getZones(request);
		List<ZoneDto> collectDto = clusters.stream().map(cluster -> {
			return modelMapper.map(cluster, ZoneDto.class);
		}).collect(Collectors.toList());
		return collectDto;
	}

	@GetMapping(path = "/region-master", produces = "application/json")
	public List<RegionDto> getRegions(HttpServletRequest request) {
		List<RegionMaster> clusters = dashboardReportService.getRegions(request);
		List<RegionDto> collectDto = clusters.stream().map(cluster -> {
			return modelMapper.map(cluster, RegionDto.class);
		}).collect(Collectors.toList());
		return collectDto;
	}

	@PostMapping(path = "/hourly-report", produces = "application/json")
	public HourlyReportDto getHourlyReportData(@RequestBody HourlyReportDto requestDto,HttpServletRequest request) {
		List<HourlyReportGroup> hourlyReport = dashboardReportService.getLatestHourlReportData(requestDto,request);
		return convert(hourlyReport);
	}

	private HourlyReportDto convert(List<HourlyReportGroup> hourlyReport) {
		HourlyReportDto hourlyReportDto = new HourlyReportDto();
		hourlyReportDto.getLabels()
				.addAll(hourlyReport.stream().map(HourlyReportGroup::getDate).collect(Collectors.toList()));
		hourlyReportDto.getDataSets().add(new DataSet("Battery Discharge Energy", getColor(),
				hourlyReport.stream().map(HourlyReportGroup::getBatteryDisEnergy).collect(Collectors.toList())));
		hourlyReportDto.getDataSets().add(new DataSet("MDG Energy", getColor(),
				hourlyReport.stream().map(HourlyReportGroup::getMdgEnergy).collect(Collectors.toList())));
		hourlyReportDto.getDataSets().add(new DataSet("DG Energy", getColor(),
				hourlyReport.stream().map(HourlyReportGroup::getDgEnergy).collect(Collectors.toList())));
		hourlyReportDto.getDataSets().add(new DataSet("Battery Charging Energy", getColor(),
				hourlyReport.stream().map(HourlyReportGroup::getBatteryChargingEnergy).collect(Collectors.toList())));
		hourlyReportDto.getDataSets().add(new DataSet("Tele Energy", getColor(),
				hourlyReport.stream().map(HourlyReportGroup::getTeleEnergy).collect(Collectors.toList())));
		hourlyReportDto.getDataSets().add(new DataSet("Inverter Energy", getColor(),
				hourlyReport.stream().map(HourlyReportGroup::getInverterEnergy).collect(Collectors.toList())));
		hourlyReportDto.getDataSets().add(new DataSet("Community Load Energy", getColor(),
				hourlyReport.stream().map(HourlyReportGroup::getCommunityLoadEnergy).collect(Collectors.toList())));
		hourlyReportDto.getDataSets().add(new DataSet("Solar Output Energy", getColor(),
				hourlyReport.stream().map(HourlyReportGroup::getSolarOutputEnergy).collect(Collectors.toList())));
		hourlyReportDto.getDataSets().add(new DataSet("Solar Input Energy", getColor(),
				hourlyReport.stream().map(HourlyReportGroup::getSolarInputEnergy).collect(Collectors.toList())));
		return hourlyReportDto;
	}

	private String getColor() {
		Random random = new Random();

		int nextInt = random.nextInt(0xffffff + 1);

		return String.format("#%06x", nextInt);
	}

	@GetMapping(path = "/device-type-master", produces = "application/json")
	public List<DeviceTypeDto> getDeviceType(HttpServletRequest request) {
		return convertDeviceTypes(dashboardReportService.fetchDeviceTypes(request));
	}

	private List<DeviceTypeDto> convertDeviceTypes(List<String> deviceType) {
		List<String> types = deviceType.stream().filter(obj -> obj != null).collect(Collectors.toList());
		return types.stream().map( obj -> {
			return new DeviceTypeDto(obj);
		}).collect(Collectors.toList());
	}
	
	@GetMapping(path = "/latest-report-status", produces = "application/json")
	public LatestReportStatusDto getLatestReportStatus(HttpServletRequest request) {
		List<String> siteType = new ArrayList<>();
		if (request.getUserPrincipal() != null) {
			siteType= userService.allSiteTypeForUser(request.getUserPrincipal().getName());
		}
		return dashboardReportService.getLatestReportStatus(siteType);
	}
	
	@GetMapping(path = "/alarm-category", produces = "application/json")
	public List<AlarmCategoryDto> getAlarmCategory(HttpServletRequest request) {
		return dashboardReportService.getAlarmCategory(request);
	}
	
	@GetMapping(path = "/alarm-severity", produces = "application/json")
	public List<AlarmSeverityDto> getAlarmSeverity(HttpServletRequest request) {
		return dashboardReportService.getAlarmSeverity(request);
	}
	
	@PostMapping(path = "/alarm-status", produces = "application/json")
	public DataTableResponse getAlarmStatus(@RequestBody AlarmStatusDto latestReportDto,HttpServletRequest request) {
		return new DataTableResponse(dashboardReportService.getAlarmStatus(latestReportDto,request));
	}
	
}
