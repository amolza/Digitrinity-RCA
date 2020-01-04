package com.digitrinity.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitrinity.model.RawDataReport;

public interface RawDataReportRepository extends PagingAndSortingRepository<RawDataReport, String> {

}
