package com.digitrinity.service;

import com.digitrinity.dto.PowerTrackerReqDto;
import com.digitrinity.model.VPowerTrackerTee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PowerTrackerTeeReportService {

	public List<VPowerTrackerTee> getPowerReportData(HttpServletRequest request,PowerTrackerReqDto reqDto);
}
