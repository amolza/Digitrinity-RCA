package com.digitrinity.web;

import com.digitrinity.dto.PowerTrackerReqDto;
import com.digitrinity.dto.RawDataReportReqDto;
import com.digitrinity.formBeans.DataTableResponse;
import com.digitrinity.formBeans.ServerSideDataTableResponse;
import com.digitrinity.model.RawDataReport;
import com.digitrinity.model.VPowerTrackerTee;
import com.digitrinity.service.IRawDataReportService;
import com.digitrinity.service.PowerTrackerTeeReportService;
import com.digitrinity.util.ExcelViewCreatorRawReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "power-tracker")
public class PowerTrackerController {
	
	@Autowired
	private PowerTrackerTeeReportService powerTrackerTeeReportService;

	@PostMapping(path = "/tee", produces = "application/json")
	public DataTableResponse getLatestReportData(@RequestBody PowerTrackerReqDto dataReportReqDto, HttpServletRequest request) {
		return new DataTableResponse( powerTrackerTeeReportService.getPowerReportData(request,dataReportReqDto));
	}

}
