/**
 *
 */
package com.digitrinity.service;

import com.digitrinity.dto.*;
import com.digitrinity.model.*;
import com.digitrinity.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public List<CustomerDto> getCustomerNames(HttpServletRequest request) {
        List<String> siteType = new ArrayList<>();
        List<Integer> customerId = new ArrayList<>();
        if (request.getUserPrincipal() != null) {
            siteType = userService.allSiteTypeForUser(request.getUserPrincipal().getName());
            customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
        }
        List<String> customerIdString = new ArrayList<>();
        for(Integer s : customerId) customerIdString.add(String.valueOf(s));
        List<Integer> siteTypeInt = siteType.stream().map(Integer::parseInt).collect(Collectors.toList());
        return CustomerDto.generate(siteMasterRepository.fetchCustomerNames(siteTypeInt, customerIdString));


    }

    @Override
    public List<SiteTypeDto> getSiteType(HttpServletRequest request) {
        List<String> siteType = new ArrayList<>();
        List<Integer> customerId = new ArrayList<>();
        List<String> customerIdString = new ArrayList<>();
        if (request.getUserPrincipal() != null) {
            siteType = userService.allSiteTypeForUser(request.getUserPrincipal().getName());
            customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
        }

        for(Integer s : customerId) customerIdString.add(String.valueOf(s));

        List<Integer> siteTypeInt = siteType.stream().map(Integer::parseInt).collect(Collectors.toList());
        return SiteTypeDto.generate(siteMasterRepository.fetchSiteTypeId(siteTypeInt, customerIdString));
    }

    @Override
    public List<SiteCodeDto> getSiteCode(HttpServletRequest request) {
        List<String> siteType = new ArrayList<>();
        List<Integer> customerId = new ArrayList<>();
        if (request.getUserPrincipal() != null) {
            siteType = userService.allSiteTypeForUser(request.getUserPrincipal().getName());
            customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
        }
        List<String> customerIdString = new ArrayList<>();
        for(Integer s : customerId) customerIdString.add(String.valueOf(s));
        List<Integer> siteTypeInt = siteType.stream().map(Integer::parseInt).collect(Collectors.toList());
        return SiteCodeDto.generate(siteMasterRepository.fetchSiteCode(siteTypeInt, customerIdString));
    }

    @Override
    public List<ClusterMaster> getClusters(HttpServletRequest request) {
        return clusterMasterRepository.findAllByOrderByCrNameAsc();
    }

    @Override
    public List<ZoneMaster> getZones(HttpServletRequest request) {
        return zoneMasterRepository.findAllByOrderByZnZoneAsc();
    }

    @Override
    public List<RegionMaster> getRegions(HttpServletRequest request) {
        return regionMasterRepository.findAllByOrderByRgRegionAsc();
    }

    @Override
    public List<LatestDataReport> getFilteredLatestReportData(LatestReportDto latestReportDto, HttpServletRequest request) {
        List<String> siteType = new ArrayList<>();
        List<Integer> customerId = new ArrayList<>();
        if (request.getUserPrincipal() != null) {
            siteType = userService.allSiteTypeForUser(request.getUserPrincipal().getName());
            customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
        }
        return getFilteredLatestReportData(latestReportDto, siteType, customerId);
    }

    @Override
    public List<LatestDataReport> getFilteredLatestReportData(LatestReportDto latestReportDto, List<String> siteType, List<Integer> customerId) {
        List<LatestDataReport> dataReports = new ArrayList<LatestDataReport>();
        if (latestReportDto.isAnyFilterEmpty()) {
            return dataReports;
        } else if (latestReportDto.isAllClusters() && latestReportDto.isAllCustomers()
                && latestReportDto.isAllSiteId() && latestReportDto.isAllSiteTypes()
                && latestReportDto.isAllRegions() && latestReportDto.isAllZones() && latestReportDto.isAllSiteStatus()) {
            dataReports = latestDataReportRepository.findAll(siteType, customerId);
        } else {
            dataReports = latestDataReportRepository.findLatestReport(
                    latestReportDto.isAllRegions() ? null : latestReportDto.getRegions(),
                    latestReportDto.isAllZones() ? null : latestReportDto.getZones(),
                    latestReportDto.isAllClusters() ? null : latestReportDto.getClusters(),
                    latestReportDto.isAllSiteId() ? null : latestReportDto.getSiteId(),
                    latestReportDto.isAllCustomers() ? null : latestReportDto.getCustomers(),
                    latestReportDto.isAllSiteTypes() ? null : latestReportDto.getSiteType(),
                    latestReportDto.isAllCustomers() ? null : ALL,
                    latestReportDto.isAllSiteId() ? null : ALL,
                    latestReportDto.isAllClusters() ? null : ALL,
                    latestReportDto.isAllZones() ? null : ALL,
                    latestReportDto.isAllRegions() ? null : ALL,
                    latestReportDto.isAllSiteStatus()?null:latestReportDto.getSiteStatus(),
                    customerId,
                    latestReportDto.isAllSiteTypes() ? null : ALL);
        }
        return dataReports.stream().filter(dataReport -> Objects.nonNull(dataReport)).collect(Collectors.toList());
    }

    @Override
    public List<HourlyReportGroup> getLatestHourlReportData(HourlyReportDto requestDto, HttpServletRequest request) {
        String date = requestDto.getDate();
        List<String> siteType = new ArrayList<>();
        List<Integer> customerId = new ArrayList<>();
        if (request.getUserPrincipal() != null) {
            siteType = userService.allSiteTypeForUser(request.getUserPrincipal().getName());
            customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
        }
        String startDate = date.split("-")[0].trim().replaceAll("/", "-");
        String endDate = date.split("-")[1].trim().replaceAll("/", "-");
        if (requestDto.isAnyFilterEmpty()) {
            return new ArrayList<HourlyReportGroup>();
        }
        if (requestDto.isAllDeviceTypes() && requestDto.isAllSiteId() && requestDto.isAllSiteTypes()) {
            return hourlyReportRepository.latestHourlyDateGroupBy(startDate, endDate, siteType, customerId);
        } else {
            return hourlyReportRepository.filteredLatestHourlyDateGroupBy(startDate, endDate,
                    requestDto.getSiteType(),
                    requestDto.isAllDeviceTypes() ? null : ALL,
                    requestDto.getDeviceType(),
                    requestDto.isAllSiteId() ? null : ALL,
                    requestDto.getSiteId(), customerId);
        }
    }

    @Override
    public List<String> fetchDeviceTypes(HttpServletRequest request) {
        List<String> deviceTypes = hourlyReportRepository.fetchDeviceTypes();
        return deviceTypes;
    }

    @Override
    public LatestReportStatusDto getLatestReportStatus(HttpServletRequest request) {
        List<String> siteType = new ArrayList<>();
        List<Integer> customerId = new ArrayList<>();
        if (request.getUserPrincipal() != null) {
            siteType = userService.allSiteTypeForUser(request.getUserPrincipal().getName());
            customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
        }
        long total = latestDataReportRepository.countByAge("-1", siteType, customerId);
        long offline = latestDataReportRepository.countByAge("4", siteType, customerId);
        return new LatestReportStatusDto(total, total - offline, offline);
    }

    @Override
    public List<AlarmCategoryDto> getAlarmCategory(HttpServletRequest request) {
        return AlarmCategoryDto.generate(alarmStatusRepository.fetchAlarmCategory());
    }

    @Override
    public List<AlarmSeverityDto> getAlarmSeverity(HttpServletRequest request) {
        return AlarmSeverityDto.generate(alarmStatusRepository.fetchAlarmSeverity());
    }

    @Override
    public List<AlarmStatus> getAlarmStatus(AlarmStatusDto alarmStatusDto, HttpServletRequest request) {
        List<String> siteType = new ArrayList<>();
        List<Integer> customerId = new ArrayList<>();
        if (request.getUserPrincipal() != null) {
            siteType = userService.allSiteTypeForUser(request.getUserPrincipal().getName());
            customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
        }
        List<AlarmStatus> alarmStatus;
        if (alarmStatusDto.isAnyFilterEmpty()) {
            alarmStatus = new ArrayList<AlarmStatus>();
        } else if (alarmStatusDto.isAllCategory() && alarmStatusDto.isAllSeverity() && alarmStatusDto.isAllSiteId()) {
            alarmStatus = (List<AlarmStatus>) alarmStatusRepository.findAll(siteType, customerId);
        } else {
            alarmStatus = alarmStatusRepository.fetchAlarmStatus(alarmStatusDto.getSiteId(), alarmStatusDto.getCategories(), alarmStatusDto.getSeverities(),
                    alarmStatusDto.isAllSiteId() ? null : ALL, alarmStatusDto.isAllCategory() ? null : ALL, alarmStatusDto.isAllSeverity() ? null : ALL, siteType, customerId);
        }
        return alarmStatus;
    }

}
