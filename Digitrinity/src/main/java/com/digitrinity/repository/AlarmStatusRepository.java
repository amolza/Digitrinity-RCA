package com.digitrinity.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.digitrinity.model.AlarmStatus;
import com.digitrinity.model.ClusterMaster;
import com.digitrinity.model.LatestDataReport;

public interface AlarmStatusRepository extends CrudRepository<AlarmStatus, String> {

    @Query("SELECT DISTINCT almcategory from AlarmStatus order by almcategory")
    List<String> fetchAlarmCategory();

    @Query("SELECT DISTINCT alPinCriticality from AlarmStatus order by alPinCriticality")
    List<String> fetchAlarmSeverity();


    @Query(value = "SELECT ldr FROM AlarmStatus ldr WHERE ((:sitesAll) is null or ldr.smSiteCode IN (:siteids)) "
            + " AND ((:categoryAll) is null or ldr.almcategory IN (:category)) AND ((:severityAll) is null or ldr.alPinCriticality IN (:severity)) " +
			"AND (ldr.smSiteTypeId IN (:siteTypes))")
    List<AlarmStatus> fetchAlarmStatus(
            @Param("siteids") Collection<String> sites
            , @Param("category") Collection<String> categories
            , @Param("severity") Collection<String> severity
            , @Param("sitesAll") String sitesAll
            , @Param("categoryAll") String categoryAll
            , @Param("severityAll") String severityAll,
            @Param("siteTypes") Collection<String> siteTypes
    );

    List<AlarmStatus> findAllByOrderByAlOpentimeDesc();

    @Query(value = "SELECT ldr FROM AlarmStatus ldr WHERE (ldr.smSiteTypeId IN (:siteTypes))")
    List<AlarmStatus> findAll(@Param("siteTypes") Collection<String> siteTypes);
}
