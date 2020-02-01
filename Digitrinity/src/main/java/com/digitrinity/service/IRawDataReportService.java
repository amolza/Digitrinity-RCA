package com.digitrinity.service;

import com.digitrinity.dto.RawDataReportReqDto;
import com.digitrinity.model.RawDataReport;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IRawDataReportService {

	Page<RawDataReport> fetchFilteredAndPaginatedReport(RawDataReportReqDto dataReportReqDto, HttpServletRequest request);
	List<RawDataReport> fetchFilteredReportForDownload(RawDataReportReqDto requestDto, HttpServletRequest request);
	List<String> fetchAll();
}
