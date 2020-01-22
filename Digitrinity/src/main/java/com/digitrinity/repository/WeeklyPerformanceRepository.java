package com.digitrinity.repository;

import com.digitrinity.model.VHourlyPerformance;
import com.digitrinity.model.VWeeklyPerformance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeeklyPerformanceRepository extends JpaRepository<VWeeklyPerformance, String> {
    @Override
    List<VWeeklyPerformance> findAll();

    @Override
    List<VWeeklyPerformance> findAll(Sort sort);

    @Override
    List<VWeeklyPerformance> findAllById(Iterable<String> iterable);

    @Override
    VWeeklyPerformance getOne(String s);
}
