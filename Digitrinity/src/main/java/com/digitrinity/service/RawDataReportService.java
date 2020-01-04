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

	@Autowired
	private RawDataReportRepository rawDataReportRepository;
	
	@Override
	public Page<RawDataReport> fetchFilteredAndPaginatedReport(RawDataReportReqDto dataReportReqDto) {
		Page<RawDataReport> findAll = rawDataReportRepository.findAll(PageRequest.of(dataReportReqDto.getPage(), dataReportReqDto.getLength()));
		return findAll;
	}

}
