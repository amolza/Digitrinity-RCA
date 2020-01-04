package com.digitrinity.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitrinity.dto.RawDataReportReqDto;
import com.digitrinity.formBeans.ServerSideDataTableResponse;
import com.digitrinity.model.RawDataReport;
import com.digitrinity.service.IRawDataReportService;

@RestController
@RequestMapping(value = "raw-report")
public class RawDataReportController {
	
	@Autowired
	private IRawDataReportService rawDataReportService;
	
	@PostMapping(path = "/raw-data", produces = "application/json")
	public ServerSideDataTableResponse getLatestReportData(@RequestBody RawDataReportReqDto dataReportReqDto) {
		Page<RawDataReport> fetchFilteredAndPaginatedReport = rawDataReportService.fetchFilteredAndPaginatedReport(dataReportReqDto);
		return new ServerSideDataTableResponse(fetchFilteredAndPaginatedReport.getContent(),fetchFilteredAndPaginatedReport.getTotalElements(), fetchFilteredAndPaginatedReport.getTotalElements(),dataReportReqDto.getDraw());
	}
}
