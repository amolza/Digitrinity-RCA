package com.digitrinity.web;

import com.digitrinity.dto.PowerTrackerReqDto;
import com.digitrinity.formBeans.DataTableResponse;
import com.digitrinity.service.PowerTrackerHybridReportService;
import com.digitrinity.service.PowerTrackerTeeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "power-tracker")
public class PowerTrackerController {

    @Autowired
    private PowerTrackerTeeReportService powerTrackerTeeReportService;

    @Autowired
    private PowerTrackerHybridReportService powerTrackerHybridReportService;

    @PostMapping(path = "/tee", produces = "application/json")
    public DataTableResponse getLatestReportData(@RequestBody PowerTrackerReqDto dataReportReqDto, HttpServletRequest request) {
        return new DataTableResponse(powerTrackerTeeReportService.getPowerReportData(request, dataReportReqDto));
    }

    @PostMapping(path = "/hybrid", produces = "application/json")
    public DataTableResponse getHybridReportData(@RequestBody PowerTrackerReqDto dataReportReqDto, HttpServletRequest request) {
        return new DataTableResponse(powerTrackerHybridReportService.getPowerReportData(request, dataReportReqDto));
    }
}
