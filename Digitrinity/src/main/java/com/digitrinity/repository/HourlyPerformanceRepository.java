package com.digitrinity.repository;


import com.digitrinity.model.VHourlyPerformance;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface HourlyPerformanceRepository extends JpaRepository<VHourlyPerformance, String> {


    @Query(value = "SELECT ldr FROM VHourlyPerformance ldr WHERE (ldr.smSiteCode = (:siteId)) AND ldr.dateHour >=(:startDate) AND ldr.dateHour <=(:endDate)")
    List<VHourlyPerformance> findAll(String siteId, LocalDate startDate, LocalDate endDate);

    @Override
    List<VHourlyPerformance> findAll(Sort sort);

    @Override
    List<VHourlyPerformance> findAllById(Iterable<String> iterable);

    @Override
    VHourlyPerformance getOne(String s);
}
