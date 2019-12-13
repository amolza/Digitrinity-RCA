package com.digitrinity.web;

import java.util.List;
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
import com.digitrinity.dto.LatestReportDto;
import com.digitrinity.dto.RegionDto;
import com.digitrinity.dto.SiteCodeDto;
import com.digitrinity.dto.SiteTypeDto;
import com.digitrinity.dto.ZoneDto;
import com.digitrinity.formBeans.DataTableResponse;
import com.digitrinity.model.ClusterMaster;
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
	
	@GetMapping(path="/latest-data", produces = "application/json")
	public DataTableResponse getLatestReportData() {
		return new DataTableResponse(dashboardReportService.getLatestReportData());
	}
	
	@PostMapping(path="/latest-data1", produces = "application/json")
	public DataTableResponse getLatestReportData1(@RequestBody LatestReportDto latestReportDto) {
		return new DataTableResponse(dashboardReportService.getFilteredLatestReportData(latestReportDto));
	}
	
	@GetMapping(path="/customer-master", produces = "application/json")
	public List<CustomerDto> getSiteMaster(){		
		return dashboardReportService.getCustomerNames();
	}
	
	@GetMapping(path="/site-code-master", produces = "application/json")
	public List<SiteCodeDto> getSiteCodeMaster(){		
		return dashboardReportService.getSiteCode();
	}
	
	@GetMapping(path="/site-type-master", produces = "application/json")
	public List<SiteTypeDto> getSiteTypeMaster(){		
		return dashboardReportService.getSiteType();
	}
	
	@GetMapping(path="/cluster-master", produces = "application/json")
	public List<ClusterDto> getClusters(){	
		List<ClusterMaster> clusters = dashboardReportService.getClusters();
		List<ClusterDto> collectDto = clusters.stream().map(cluster -> {
			return modelMapper.map(cluster, ClusterDto.class);
		}).collect(Collectors.toList());
		return collectDto;
	}
	
	@GetMapping(path="/zone-master", produces = "application/json")
	public List<ZoneDto> getZones(){	
		List<ZoneMaster> clusters = dashboardReportService.getZones();
		List<ZoneDto> collectDto = clusters.stream().map(cluster -> {
			return modelMapper.map(cluster, ZoneDto.class);
		}).collect(Collectors.toList());
		return collectDto;
	}
	
	@GetMapping(path="/region-master", produces = "application/json")
	public List<RegionDto> getRegions(){	
		List<RegionMaster> clusters = dashboardReportService.getRegions();
		List<RegionDto> collectDto = clusters.stream().map(cluster -> {
			return modelMapper.map(cluster, RegionDto.class);
		}).collect(Collectors.toList());
		return collectDto;
	}
}
