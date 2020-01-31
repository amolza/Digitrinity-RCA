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


	@Query(value = "SELECT ldr FROM VPowerTrackerTee ldr WHERE ((:regionsAll) is null or ldr.region IN (:regions)) AND ((:zonesAll) is null or ldr.zone IN (:zones))" +
			"AND ((:clustersAll) is null or ldr.clusterName IN (:clusters)) AND ((:sitesAll) is null or ldr.smSiteCode IN (:siteids)) AND ((:customersAll) is null or ldr.customerName IN (:customers))" +
			"AND ((:siteTypesAll) is null or ldr.sitetypeid IN (:siteTypes))AND ((:deviceTypeAll) is null or ldr.devicetype IN (:deviceTypes))" +
			"AND ((:powerSourceAll) is null or ldr.powersource IN (:powerSource)) AND ldr.customerId IN (:customerId)")
	List<VPowerTrackerTee> findTeeReport(
			@Param("regions") List<String> regions
			,@Param("zones") List<String> zones
			,@Param("clusters") List<String> clusters
			,@Param("siteids") List<String> sites
			,@Param("customers") List<String> customers
			,@Param("siteTypes") List<String> siteTypes
			,@Param("deviceTypes") List<String> deviceTypes
			,@Param("powerSource") List<String> powerSource
			,@Param("customersAll") String customersAll
			,@Param("sitesAll") String sitesAll
			,@Param("clustersAll") String clustersAll
			,@Param("zonesAll") String zonesAll
			,@Param("regionsAll") String regionsAll
			,@Param("deviceTypeAll") String deviceTypeAll
			,@Param("customerId") List<Integer> customerId
			,@Param("siteTypesAll") String siteTypesAll
			,@Param("powerSourceAll") String powerSourceAll
	);


}
