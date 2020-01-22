package com.digitrinity.repository;

import com.digitrinity.model.VHourlyPerformance;
import com.digitrinity.model.VLifetimePerformance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LifetimePerformanceRepository extends JpaRepository<VLifetimePerformance, String> {
    @Override
    List<VLifetimePerformance> findAll();

    @Override
    List<VLifetimePerformance> findAll(Sort sort);

    @Override
    List<VLifetimePerformance> findAllById(Iterable<String> iterable);

    @Override
    VLifetimePerformance getOne(String s);
}
