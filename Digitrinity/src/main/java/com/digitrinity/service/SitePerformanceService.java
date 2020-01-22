package com.digitrinity.service;

import com.digitrinity.dto.*;
import com.digitrinity.model.*;

import java.util.List;

public interface SitePerformanceService {

    public List<VHourlyPerformance> getHourlyPerformance(SitePerformanceDTO dto);

    public List<VWeeklyPerformance> getWeeklyPerformance(SitePerformanceDTO dto);

    public List<VDailyPerformance> getDailyPerformance(SitePerformanceDTO dto);

    public List<VMonthlyPerformance> getMonthlyPerformance(SitePerformanceDTO dto);

    public List<VYearlyPerformance> getYearlyPerformance(SitePerformanceDTO dto);

    public List<VLifetimePerformance> getLifetimePerformance(SitePerformanceDTO dto);

}
