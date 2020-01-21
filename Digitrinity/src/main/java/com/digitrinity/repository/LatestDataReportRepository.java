package com.digitrinity.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digitrinity.model.LatestDataReport;

public interface LatestDataReportRepository extends JpaRepository<LatestDataReport, Date> {

	@Query(value = "SELECT ldr FROM LatestDataReport ldr WHERE ((:siteTypeAll) is null or ldr.siteTypeId IN (:siteTypes)) AND ((:zonesAll) is null or ldr.zone IN (:zones)) AND "
			+ "((:clustersAll) is null or ldr.clusterName IN (:customers)) AND ((:sitesAll) is null or ldr.smSiteCode IN (:siteids)) "
			+ " AND ((:customersAll) is null or ldr.customerName IN (:customers)) AND ((:regionsAll) is null or ldr.region IN (:regions)) AND ((:offline) is null or ldr.isOffline IN (:offline))")
	List<LatestDataReport> findLatestReport(@Param("regions") Collection<String> regions
			,@Param("zones") Collection<String> zones
			,@Param("clusters") Collection<String> clusters
			,@Param("siteids") Collection<String> sites
			,@Param("customers") Collection<String> customers
			,@Param("siteTypes") Collection<String> siteTypes
			,@Param("siteTypeAll") String siteTypesAll
			,@Param("customersAll") String customersAll
			,@Param("sitesAll") String sitesAll
			,@Param("clustersAll") String clustersAll
			,@Param("zonesAll") String zonesAll
			,@Param("regionsAll") String regionsAll
			,@Param("offline") Integer siteStatusAll
	);
	
	
	@Query(value = "SELECT ldr FROM LatestDataReport ldr WHERE (ldr.smSiteCode IN (:siteids))")
	List<LatestDataReport> findLatestReport1(@Param("siteids") Collection<String> siteTypes);
	
	@Query(value = "SELECT count(ldr.smSiteCode) FROM LatestDataReport ldr WHERE (ldr.age > (:age))")
	Long countByAge(String age);

	@Query(value = "SELECT ldr FROM LatestDataReport ldr WHERE (ldr.siteTypeId IN (:siteTypes))")
	List<LatestDataReport> findAll(@Param("siteTypes") Collection<String> siteTypes);
}
