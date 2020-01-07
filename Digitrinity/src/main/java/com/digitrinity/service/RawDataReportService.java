package com.digitrinity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.digitrinity.dto.RawDataReportReqDto;
import com.digitrinity.model.RawDataReport;
import com.digitrinity.repository.RawDataReportRepository;

@Service
public class RawDataReportService implements IRawDataReportService {

	private final String ALL = "All";

	@Autowired
	private RawDataReportRepository rawDataReportRepository;

	@Override
	public Page<RawDataReport> fetchFilteredAndPaginatedReport(RawDataReportReqDto dataReportReqDto) {

		Page<RawDataReport> reportData = null;

		PageRequest pageRequest = PageRequest.of(dataReportReqDto.getPage(), dataReportReqDto.getLength());

		if (dataReportReqDto.isAnyFilterEmpty()) {
			return null;
		} else if (dataReportReqDto.isAllClusters() && dataReportReqDto.isAllDeviceType()
				&& dataReportReqDto.isAllSiteId() && dataReportReqDto.isAllSiteTypes()
				&& dataReportReqDto.isAllRegions() && dataReportReqDto.isAllZones()) {
			reportData = rawDataReportRepository.findAll(pageRequest);
		} else {
			reportData = rawDataReportRepository.fetchFilteredPaginatedRawData(dataReportReqDto.getClusters(),
					dataReportReqDto.getSiteId(), dataReportReqDto.isAllSiteId() ? null : ALL,
					dataReportReqDto.isAllClusters() ? null : ALL, pageRequest);
		}

		return reportData;
	}

}
