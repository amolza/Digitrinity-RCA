package com.digitrinity.service;

import com.digitrinity.dto.PowerTrackerReqDto;
import com.digitrinity.model.VPowerTrackerHybrid;
import com.digitrinity.repository.PowerTrackerHybridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PowerTrackerHybridReportService_Impl implements PowerTrackerHybridReportService {
    private final String ALL = "All";
    @Autowired
    UserService userService;

    @Autowired
    PowerTrackerHybridRepository powerTrackerHybridRepository;

    @Override
    public List<VPowerTrackerHybrid> getPowerReportData(HttpServletRequest request, PowerTrackerReqDto latestReportDto) {
        List<VPowerTrackerHybrid> dataReports = new ArrayList<VPowerTrackerHybrid>();
        List<String> siteType = new ArrayList<>();
        List<Integer> customerId = new ArrayList<>();
        if (request.getUserPrincipal() != null) {
            siteType = userService.allSiteTypeForUser(request.getUserPrincipal().getName());
            customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
        }
        List<Integer> siteTypeInt = siteType.stream().map(Integer::parseInt).collect(Collectors.toList());
        if (latestReportDto.isAnyFilterEmpty()){
            return dataReports;
        }
        else if(latestReportDto.isAllClusters() && latestReportDto.isAllCustomers()
                && latestReportDto.isAllSiteId() && latestReportDto.isAllSiteTypes()
                && latestReportDto.isAllRegions() && latestReportDto.isAllZones() && latestReportDto.isAllDeviceType() && latestReportDto.isAllPowerSource()){
            dataReports = powerTrackerHybridRepository.findAll(siteTypeInt, customerId);
        }
        else{powerTrackerHybridRepository.findHybridReport(
                latestReportDto.isAllRegions() ? null : latestReportDto.getRegions(),
                latestReportDto.isAllZones() ? null : latestReportDto.getZones(),
                latestReportDto.isAllClusters() ? null : latestReportDto.getClusters(),
                latestReportDto.isAllSiteId() ? null : latestReportDto.getSiteId(),
                latestReportDto.isAllCustomers() ? null : latestReportDto.getCustomers(),
                latestReportDto.isAllSiteTypes() ? null : latestReportDto.getSiteType(),
                latestReportDto.isAllDeviceType() ? null : latestReportDto.getDeviceType(),
                latestReportDto.isAllPowerSource() ? null : latestReportDto.getPowerSource(),
                latestReportDto.isAllCustomers() ? null : ALL,
                latestReportDto.isAllSiteId() ? null : ALL,
                latestReportDto.isAllClusters() ? null : ALL,
                latestReportDto.isAllZones() ? null : ALL,
                latestReportDto.isAllRegions() ? null : ALL,
                latestReportDto.isAllDeviceType() ? null : ALL,
                latestReportDto.isAllSiteTypes() ? null : ALL,
                latestReportDto.isAllPowerSource() ? null : ALL);

        }
        return dataReports;
    }


}
