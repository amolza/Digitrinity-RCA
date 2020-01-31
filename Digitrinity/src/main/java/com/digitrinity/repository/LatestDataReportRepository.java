package com.digitrinity.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digitrinity.model.LatestDataReport;

public interface LatestDataReportRepository extends JpaRepository<LatestDataReport, Date> {

	@Query(value = "SELECT ldr FROM LatestDataReport ldr WHERE ((:siteTypesAll) is null or ldr.siteTypeName IN (:siteTypes)) AND ((:zonesAll) is null or ldr.zone IN (:zones)) AND "
			+ "((:clustersAll) is null or ldr.clusterName IN (:clusters)) AND ((:sitesAll) is null or ldr.smSiteCode IN (:siteids)) "
			+ " AND ((:customersAll) is null or ldr.customerName IN (:customers)) AND ((:regionsAll) is null or ldr.region IN (:regions)) AND ((:offline) is null or  ldr.isOffline = (:offline))" +
			" AND ldr.customerId IN (:customerId)")
	List<LatestDataReport> findLatestReport(
			@Param("regions") Collection<String> regions
			,@Param("zones") Collection<String> zones
			,@Param("clusters") Collection<String> clusters
			,@Param("siteids") Collection<String> sites
			,@Param("customers") Collection<String> customers
			,@Param("siteTypes") Collection<String> siteTypes
			,@Param("customersAll") String customersAll
			,@Param("sitesAll") String sitesAll
			,@Param("clustersAll") String clustersAll
			,@Param("zonesAll") String zonesAll
			,@Param("regionsAll") String regionsAll
			,@Param("offline") Integer siteStatus
			,@Param("customerId") List<Integer> customerId
			,@Param("siteTypesAll") String siteTypesAll
	);
	
	
	@Query(value = "SELECT ldr FROM LatestDataReport ldr WHERE (ldr.smSiteCode IN (:siteids) AND ldr.customerId IN (:customerId))")
	List<LatestDataReport> findLatestReport1(@Param("siteids") Collection<String> siteTypes,@Param("customerId") List<Integer> customerId);
	
	@Query(value = "SELECT count(ldr.smSiteCode) FROM LatestDataReport ldr WHERE (ldr.age > (:age) and ldr.siteTypeId IN (:siteTypes)) AND ldr.customerId IN (:customerId)")
	Long countByAge(String age,Collection<String> siteTypes, List<Integer> customerId);

	@Query(value = "SELECT ldr FROM LatestDataReport ldr WHERE (ldr.siteTypeId IN (:siteTypes)) AND ldr.customerId IN (:customerId)")
	List<LatestDataReport> findAll(@Param("siteTypes") Collection<String> siteTypes,@Param("customerId") List<Integer> customerId);
}
