package com.digitrinity.service;

import com.digitrinity.dto.*;
import com.digitrinity.model.*;
import com.digitrinity.repository.HourlyPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SitePerformanceService_Impl implements SitePerformanceService {
@Autowired
HourlyPerformanceRepository hourlyPerformanceRepository;
    @Override
    public List<VHourlyPerformance> getHourlyPerformance(SitePerformanceDTO dto) {
        String siteId=dto.getSiteId();
        String startDate=dto.getStartDate();
        String endDate= dto.getEndDate();
        if(startDate==null){
            return null;
        }
        LocalDate localStartDate= LocalDate.parse(startDate);
        LocalDate localEndDate= LocalDate.parse(endDate);
        return hourlyPerformanceRepository.findAll(siteId,localStartDate,localEndDate);

    }

    @Override
    public List<VWeeklyPerformance> getWeeklyPerformance(SitePerformanceDTO dto) {
        return null;
    }

    @Override
    public List<VDailyPerformance> getDailyPerformance(SitePerformanceDTO dto) {
        return null;
    }

    @Override
    public List<VMonthlyPerformance> getMonthlyPerformance(SitePerformanceDTO dto) {
        return null;
    }

    @Override
    public List<VYearlyPerformance> getYearlyPerformance(SitePerformanceDTO dto) {
        return null;
    }

    @Override
    public List<VLifetimePerformance> getLifetimePerformance(SitePerformanceDTO dto) {
        return null;
    }
}
