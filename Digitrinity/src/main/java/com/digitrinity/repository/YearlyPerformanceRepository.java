package com.digitrinity.repository;

import com.digitrinity.model.VHourlyPerformance;
import com.digitrinity.model.VYearlyPerformance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YearlyPerformanceRepository extends JpaRepository<VYearlyPerformance, String> {
    @Override
    List<VYearlyPerformance> findAll();

    @Override
    List<VYearlyPerformance> findAll(Sort sort);

    @Override
    List<VYearlyPerformance> findAllById(Iterable<String> iterable);

    @Override
    VYearlyPerformance getOne(String s);
}
