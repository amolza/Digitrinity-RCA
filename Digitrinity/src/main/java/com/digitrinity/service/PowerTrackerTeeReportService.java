package com.digitrinity.service;

import com.digitrinity.dto.*;
import com.digitrinity.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface PowerTrackerTeeReportService {

	public List<VPowerTrackerTee> getPowerReportData(HttpServletRequest request,PowerTrackerReqDto reqDto);

}
