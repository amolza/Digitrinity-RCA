package com.digitrinity.service;

import java.util.List;

import com.digitrinity.dto.HourlyReportDto;
import com.digitrinity.model.HourlyReportGroup;
import org.springframework.data.domain.Page;

import com.digitrinity.dto.RawDataReportReqDto;
import com.digitrinity.model.RawDataReport;

import javax.servlet.http.HttpServletRequest;

public interface IRawDataReportService {

	Page<RawDataReport> fetchFilteredAndPaginatedReport(RawDataReportReqDto dataReportReqDto, HttpServletRequest request);
	List<RawDataReport> fetchFilteredReportForDownload(RawDataReportReqDto requestDto, HttpServletRequest request);

}
