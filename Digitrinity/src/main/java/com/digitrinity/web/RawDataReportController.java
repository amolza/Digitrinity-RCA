package com.digitrinity.web;

import java.util.ArrayList;
import java.util.List;

import com.digitrinity.dto.EmailRawDataReportReqDto;
import com.digitrinity.util.ExcelViewCreatorRawReport;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "raw-report")
public class RawDataReportController {

    @Autowired
    private IRawDataReportService rawDataReportService;

    @PostMapping(path = "/raw-data", produces = "application/json")
    public ServerSideDataTableResponse getLatestReportData(@RequestBody RawDataReportReqDto dataReportReqDto, HttpServletRequest request) {
        Page<RawDataReport> rawDataReport = rawDataReportService.fetchFilteredAndPaginatedReport(dataReportReqDto, request);
        if (rawDataReport != null) {
            return new ServerSideDataTableResponse(rawDataReport.getContent(), rawDataReport.getTotalElements(), rawDataReport.getTotalElements(), dataReportReqDto.getDraw());
        } else {
            return new ServerSideDataTableResponse(new ArrayList<String>(), 0, 0, dataReportReqDto.getDraw());
        }

    }

    @PostMapping(path = "/email-raw-data")
    public boolean getLatestReportDataForExcel(@RequestBody EmailRawDataReportReqDto dataReportReqDto, HttpServletRequest request, HttpServletResponse response) {

    	return false;
    }
}
