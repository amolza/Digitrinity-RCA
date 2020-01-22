package com.digitrinity.repository;

import com.digitrinity.model.VHourlyPerformance;
import com.digitrinity.model.VMonthlyPerformance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonthlyPerformanceRepository extends JpaRepository<VMonthlyPerformance, String> {
    @Override
    List<VMonthlyPerformance> findAll();

    @Override
    List<VMonthlyPerformance> findAll(Sort sort);

    @Override
    List<VMonthlyPerformance> findAllById(Iterable<String> iterable);

    @Override
    VMonthlyPerformance getOne(String s);
}
