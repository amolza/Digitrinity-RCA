package com.digitrinity.service;

import com.digitrinity.dto.PowerTrackerReqDto;
import com.digitrinity.model.VPowerTrackerHybrid;
import com.digitrinity.model.VPowerTrackerTee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PowerTrackerHybridReportService {

    public List<VPowerTrackerHybrid> getPowerReportData(HttpServletRequest request, PowerTrackerReqDto reqDto);

}
