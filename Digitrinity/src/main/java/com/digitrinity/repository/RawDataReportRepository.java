package com.digitrinity.repository;

import java.util.Collection;
import java.util.List;

import com.digitrinity.model.LatestDataReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.digitrinity.model.RawDataReport;

public interface RawDataReportRepository extends PagingAndSortingRepository<RawDataReport, String> {

    /*
     * @Query(value =
     * "SELECT ldr FROM RawDataReport ldr WHERE ((:siteTypeAll) is null or ldr.siteTypeId IN (:siteTypes)) AND ((:zonesAll) is null or ldr.zone IN (:zones)) AND "
     * +
     * "((:deviceTypeAll) is null or ldr.deviceType IN (:customers)) AND ((:sitesAll) is null or ldr.smSiteCode IN (:siteids)) "
     * +
     * " AND ((:customersAll) is null or ldr.customerName IN (:deviceTypes)) AND ((:regionsAll) is null or ldr.region IN (:regions))"
     * ) List<LatestDataReport> findLatestReport(@Param("regions")
     * Collection<String> regions ,@Param("zones") Collection<String> zones
     * ,@Param("clusters") Collection<String> clusters ,@Param("siteids")
     * Collection<String> sites ,@Param("deviceTypes") Collection<String>
     * deviceTypes ,@Param("siteTypes") Collection<String> siteTypes
     * ,@Param("siteTypeAll") String siteTypesAll ,@Param("customersAll") String
     * customersAll ,@Param("sitesAll") String sitesAll ,@Param("deviceTypeAll")
     * String deviceTypeAll ,@Param("zonesAll") String zonesAll
     * ,@Param("regionsAll") String regionsAll ); Page<RawDataReport>
     * fetchFilteredPaginatedRawData();
     */

    @Query(value = "SELECT ldr FROM RawDataReport ldr WHERE ((:sitesAll) is null or ldr.siteId IN (:siteids)) "
            + " AND ((:clusterAll) is null or ldr.cluster IN (:clusters)) AND (ldr.siteType) IN (:siteTypeID)  AND ldr.tranTime >= :startDate AND " +
            "ldr.tranTime < :endDate AND ldr.customerId IN (:customerId)")
    Page<RawDataReport> fetchFilteredPaginatedRawData(@Param("clusters") Collection<String> clusters
            , @Param("siteids") Collection<String> sites
            , @Param("sitesAll") String sitesAll
            , @Param("clusterAll") String clusterAll
            , @Param("siteTypeID") Collection<String> siteTypeID
            , Pageable pageable, @Param("startDate") String startDate, @Param("endDate") String endDate
            , @Param("customerId") List<Integer> customerId
    );

    @Query(value = "SELECT ldr FROM RawDataReport ldr WHERE ((:sitesAll) is null or ldr.siteId IN (:siteids)) "
            + " AND ((:clusterAll) is null or ldr.cluster IN (:clusters)) AND (ldr.siteType) IN (:siteTypeID)  AND ldr.tranTime >= :startDate AND " +
            "ldr.tranTime < :endDate AND ldr.customerId IN (:customerId)")
    Page<RawDataReport> fetchFilteredPaginatedRawDataNew(
            @Param("regions") Collection<String> regions
            ,@Param("zones") Collection<String> zones
            ,@Param("clusters") Collection<String> clusters
            ,@Param("siteids") Collection<String> sites
            ,@Param("siteTypes") Collection<String> siteTypes
            ,@Param("sitesAll") String sitesAll
            ,@Param("clustersAll") String clustersAll
            ,@Param("zonesAll") String zonesAll
            ,@Param("regionsAll") String regionsAll
            ,@Param("offline") Integer siteStatus
            ,@Param("customerId") List<Integer> customerId
            ,@Param("siteTypesAll") String siteTypesAll
    );



    @Query(value = "SELECT ldr FROM RawDataReport ldr WHERE (ldr.siteType IN (:siteTypeID) AND ldr.tranTime >= :startDate AND ldr.tranTime < :endDate AND ldr.customerId IN (:customerId))")
    Page<RawDataReport> findAll(@Param("siteTypeID") Collection<String> siteTypes, Pageable pageable, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("customerId") List<Integer> customerId);

    @Query(value = "SELECT ldr FROM RawDataReport ldr WHERE ((:sitesAll) is null or ldr.siteId IN (:siteids)) "
            + " AND ((:clusterAll) is null or ldr.cluster IN (:clusters)) AND (ldr.siteType) IN (:siteTypeID)  AND ldr.tranTime >= :startDate AND ldr.tranTime < :endDate AND ldr.customerId IN (:customerId)")
    List<RawDataReport> fetchFilteredPaginatedRawData(@Param("clusters") Collection<String> clusters
            , @Param("siteids") Collection<String> sites
            , @Param("sitesAll") String sitesAll
            , @Param("clusterAll") String clusterAll
            , @Param("siteTypeID") Collection<String> siteTypeID
            , @Param("startDate") String startDate, @Param("endDate") String endDate
            , @Param("customerId") List<Integer> customerId
    );

    @Query(value = "SELECT ldr FROM RawDataReport ldr WHERE (ldr.siteType IN (:siteTypeID) AND ldr.tranTime >= :startDate AND ldr.tranTime < :endDate AND ldr.customerId IN (:customerId))")
    List<RawDataReport> findAll(@Param("siteTypeID") Collection<String> siteTypes,@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("customerId") List<Integer> customerId);
}
