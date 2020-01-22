package com.digitrinity.repository;

import com.digitrinity.model.HourlyReport;
import com.digitrinity.model.HourlyReportGroup;
import com.digitrinity.model.VHourlyPerformance;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HourlyPerformanceRepository extends JpaRepository<VHourlyPerformance, String> {
    @Override
    List<VHourlyPerformance> findAll();

    @Override
    List<VHourlyPerformance> findAll(Sort sort);

    @Override
    List<VHourlyPerformance> findAllById(Iterable<String> iterable);

    @Override
    VHourlyPerformance getOne(String s);
}
