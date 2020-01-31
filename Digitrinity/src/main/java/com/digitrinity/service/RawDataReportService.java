package com.digitrinity.service;

import com.digitrinity.dto.HourlyReportDto;
import org.hibernate.secure.spi.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.digitrinity.dto.RawDataReportReqDto;
import com.digitrinity.model.RawDataReport;
import com.digitrinity.repository.RawDataReportRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class RawDataReportService implements IRawDataReportService {

	private final String ALL = "All";

	@Autowired
	private RawDataReportRepository rawDataReportRepository;
	@Autowired
	UserService userService;
	@Override
	public Page<RawDataReport> fetchFilteredAndPaginatedReport(RawDataReportReqDto dataReportReqDto, HttpServletRequest request) {
		String date= dataReportReqDto.getDate();
		String startDate = date.split("-")[0].trim().replaceAll("/", "-");
		String endDate = date.split("-")[1].trim().replaceAll("/", "-");
		List<String> siteType = new ArrayList<>();
		List<Integer> customerId=new ArrayList<>();

		if (request.getUserPrincipal() != null) {
			siteType= userService.allSiteTypeForUser(request.getUserPrincipal().getName());
			customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
		}

		Page<RawDataReport> reportData = null;

		PageRequest pageRequest = PageRequest.of(dataReportReqDto.getPage(), dataReportReqDto.getLength());

		if (dataReportReqDto.isAnyFilterEmpty()) {
			return null;
		} else if (dataReportReqDto.isAllClusters() && dataReportReqDto.isAllDeviceType()
				&& dataReportReqDto.isAllSiteId() && dataReportReqDto.isAllSiteTypes()
				&& dataReportReqDto.isAllRegions() && dataReportReqDto.isAllZones()) {
			reportData = rawDataReportRepository.findAll(siteType,pageRequest,startDate,endDate,customerId);
		} else {
			/*reportData = rawDataReportRepository.fetchFilteredPaginatedRawData(
					dataReportReqDto.getClusters(),
					dataReportReqDto.getSiteId(),
					dataReportReqDto.isAllSiteId() ? null : ALL,
					dataReportReqDto.isAllClusters() ? null : ALL,
					siteType,
					pageRequest,
					startDate,
					endDate,
					customerId);*/

			reportData=	rawDataReportRepository.fetchFilteredPaginatedRawDataNew(
					dataReportReqDto.isAllRegions()?null : dataReportReqDto.getRegions(),
					dataReportReqDto.isAllZones() ? null : dataReportReqDto.getZones(),
					dataReportReqDto.isAllClusters() ? null : dataReportReqDto.getClusters(),
					dataReportReqDto.isAllSiteId() ? null : dataReportReqDto.getSiteId(),
					dataReportReqDto.isAllSiteTypes() ? null : dataReportReqDto.getSiteType(),
					dataReportReqDto.isAllSiteId() ? null : ALL,
					dataReportReqDto.isAllClusters() ? null : ALL,
					dataReportReqDto.isAllZones() ? null : ALL,
					dataReportReqDto.isAllRegions() ? null : ALL,
					customerId,
					dataReportReqDto.isAllSiteTypes() ? null : ALL,
					pageRequest,
					startDate,
					endDate);
		}
		return reportData;
	}

	@Override
	public List<RawDataReport> fetchFilteredReportForDownload(RawDataReportReqDto dataReportReqDto, HttpServletRequest request) {
		String date= dataReportReqDto.getDate();
		String startDate = date.split("-")[0].trim().replaceAll("/", "-");
		String endDate = date.split("-")[1].trim().replaceAll("/", "-");
		List<String> siteType = new ArrayList<>();
		List<Integer> customerId=new ArrayList<>();

		if (request.getUserPrincipal() != null) {
			siteType= userService.allSiteTypeForUser(request.getUserPrincipal().getName());
			customerId = userService.getCustomerIdOfUser(request.getUserPrincipal().getName());
		}

		if (dataReportReqDto.isAnyFilterEmpty()) {
			return null;
		} else if (dataReportReqDto.isAllClusters() && dataReportReqDto.isAllDeviceType()
				&& dataReportReqDto.isAllSiteId() && dataReportReqDto.isAllSiteTypes()
				&& dataReportReqDto.isAllRegions() && dataReportReqDto.isAllZones()) {
			return rawDataReportRepository.findAll(siteType,startDate,endDate,customerId);
		} else {
			return rawDataReportRepository.fetchFilteredPaginatedRawData(dataReportReqDto.getClusters(),
					dataReportReqDto.getSiteId(), dataReportReqDto.isAllSiteId() ? null : ALL,
					dataReportReqDto.isAllClusters() ? null : ALL, siteType,startDate,endDate,customerId);
		}

	}

}
