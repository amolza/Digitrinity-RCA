package com.digitrinity.repository;

import com.digitrinity.model.VDailyPerformance;
import com.digitrinity.model.VHourlyPerformance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyPerformanceRepository extends JpaRepository<VDailyPerformance, String> {
    @Override
    List<VDailyPerformance> findAll();

    @Override
    List<VDailyPerformance> findAll(Sort sort);

    @Override
    List<VDailyPerformance> findAllById(Iterable<String> iterable);

    @Override
    VDailyPerformance getOne(String s);
}
