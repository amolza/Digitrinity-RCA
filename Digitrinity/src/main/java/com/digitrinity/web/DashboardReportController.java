package com.digitrinity.web;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitrinity.dto.ClusterDto;
import com.digitrinity.dto.CustomerDto;
import com.digitrinity.dto.DataSet;
import com.digitrinity.dto.DeviceTypeDto;
import com.digitrinity.dto.HourlyReportDto;
import com.digitrinity.dto.LatestReportDto;
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

@RestController
@RequestMapping(value = "dashboard")
public class DashboardReportController {

	@Autowired
	private IDashboardReportService dashboardReportService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(path = "/latest-data", produces = "application/json")
	public DataTableResponse getLatestReportData() {
		return new DataTableResponse(dashboardReportService.getLatestReportData());
	}

	@PostMapping(path = "/latest-data1", produces = "application/json")
	public DataTableResponse getLatestReportData1(@RequestBody LatestReportDto latestReportDto) {
		return new DataTableResponse(dashboardReportService.getFilteredLatestReportData(latestReportDto));
	}

	@GetMapping(path = "/customer-master", produces = "application/json")
	public List<CustomerDto> getSiteMaster() {
		return dashboardReportService.getCustomerNames();
	}

	@GetMapping(path = "/site-code-master", produces = "application/json")
	public List<SiteCodeDto> getSiteCodeMaster() {
		return dashboardReportService.getSiteCode();
	}

	@GetMapping(path = "/site-type-master", produces = "application/json")
	public List<SiteTypeDto> getSiteTypeMaster() {
		return dashboardReportService.getSiteType();
	}

	@GetMapping(path = "/cluster-master", produces = "application/json")
	public List<ClusterDto> getClusters() {
		List<ClusterMaster> clusters = dashboardReportService.getClusters();
		List<ClusterDto> collectDto = clusters.stream().map(cluster -> {
			return modelMapper.map(cluster, ClusterDto.class);
		}).collect(Collectors.toList());
		return collectDto;
	}

	@GetMapping(path = "/zone-master", produces = "application/json")
	public List<ZoneDto> getZones() {
		List<ZoneMaster> clusters = dashboardReportService.getZones();
		List<ZoneDto> collectDto = clusters.stream().map(cluster -> {
			return modelMapper.map(cluster, ZoneDto.class);
		}).collect(Collectors.toList());
		return collectDto;
	}

	@GetMapping(path = "/region-master", produces = "application/json")
	public List<RegionDto> getRegions() {
		List<RegionMaster> clusters = dashboardReportService.getRegions();
		List<RegionDto> collectDto = clusters.stream().map(cluster -> {
			return modelMapper.map(cluster, RegionDto.class);
		}).collect(Collectors.toList());
		return collectDto;
	}

	@PostMapping(path = "/hourly-report", produces = "application/json")
	public HourlyReportDto getHourlyReportData(@RequestBody HourlyReportDto requestDto) {
		List<HourlyReportGroup> hourlyReport = dashboardReportService.getLatestHourlReportData(requestDto);
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
	public List<DeviceTypeDto> getDeviceType() {
		return convertDeviceTypes(dashboardReportService.fetchDeviceTypes());
	}

	private List<DeviceTypeDto> convertDeviceTypes(List<String> deviceType) {
		List<String> types = deviceType.stream().filter(obj -> obj != null).collect(Collectors.toList());
		return types.stream().map( obj -> {
			return new DeviceTypeDto(obj);
		}).collect(Collectors.toList());
	}
}
