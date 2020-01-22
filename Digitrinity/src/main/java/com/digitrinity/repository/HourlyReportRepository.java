package com.digitrinity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digitrinity.model.HourlyReport;
import com.digitrinity.model.HourlyReportGroup;

public interface HourlyReportRepository extends JpaRepository<HourlyReport, String> {

    @Query("SELECT new com.digitrinity.model.HourlyReportGroup(date, sum(mdgEnergy) as mdgEnergy, sum(dgEnergy) as dgEnergy, "
            + "sum(batteryDisEnergy) as batteryDisEnergy,sum(batteryChargingEnergy) as batteryChargingEnergy, "
            + "sum(teleEnergy) as teleEnergy,sum(inverterEnergy) as inverterEnergy, "
            + "sum(communityLoadEnergy) as communityLoadEnergy,sum(solarOutputEnergy) as solarOutputEnergy, "
            + "sum(solarInputEnergy) as solarInputEnergy) FROM HourlyReport "
            + " where tranDate >= :startDate and tranDate <= :endDate and siteTypeId IN (:siteTypes)"
            + "group by date order by date desc")
    List<HourlyReportGroup> latestHourlyDateGroupBy(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("siteTypes") List<String> siteTypes);


    @Query("SELECT new com.digitrinity.model.HourlyReportGroup(date, sum(mdgEnergy) as mdgEnergy, sum(dgEnergy) as dgEnergy, "
            + "sum(batteryDisEnergy) as batteryDisEnergy,sum(batteryChargingEnergy) as batteryChargingEnergy, "
            + "sum(teleEnergy) as teleEnergy,sum(inverterEnergy) as inverterEnergy, "
            + "sum(communityLoadEnergy) as communityLoadEnergy,sum(solarOutputEnergy) as solarOutputEnergy, "
            + "sum(solarInputEnergy) as solarInputEnergy) FROM HourlyReport "
            + " where tranDate >= :startDate and tranDate < :endDate "
            + "AND (siteTypeId IN (:siteTypes)) "
            + "AND ((:deviceTypeAll) is null or deviceType IN (:deviceTypes))"
            + "AND ((:sitesAll) is null or smSiteCode IN (:siteids))"
            + "group by date,siteTypeId,deviceType,smSiteCode,siteTypeId order by date desc")
    List<HourlyReportGroup> filteredLatestHourlyDateGroupBy(@Param("startDate") String startDate, @Param("endDate") String endDate
            , @Param("siteTypes") List<String> siteTypes
            , @Param("deviceTypeAll") String deviceTypeAll, @Param("deviceTypes") List<String> deviceTypes
            , @Param("sitesAll") String sitesAll, @Param("siteids") List<String> siteids
    );

    @Query("SELECT DISTINCT deviceType from HourlyReport order by deviceType")
    List<String> fetchDeviceTypes();
}
