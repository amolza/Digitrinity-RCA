package com.digitrinity.repository;

import com.digitrinity.model.LatestDataReport;
import com.digitrinity.model.VPowerTrackerTee;
import com.digitrinity.model.ZoneMaster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PowerTrackerTeeRepository extends CrudRepository<VPowerTrackerTee, Long> {

	@Query(value = "SELECT ldr FROM VPowerTrackerTee ldr WHERE (ldr.smsitetypeid IN (:siteTypes)) AND ldr.customerId IN (:customerId)")
	List<VPowerTrackerTee> findAll(@Param("siteTypes") Collection<Integer> siteTypes, @Param("customerId") List<Integer> customerId);
}
