package com.digitrinity.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitrinity.model.SiteMaster;

public interface SiteMasterRepository extends JpaRepository<SiteMaster, Long>{

	@Query("SELECT DISTINCT sm.smCustomerName from SiteMaster sm where sm.smSitetypeid IN (:siteTypes) AND sm.smCustomerId  IN (:customerId) order by sm.smCustomerName")
	List<String> fetchCustomerNames(Collection<Integer> siteTypes,List<String> customerId);
	
	@Query("SELECT DISTINCT (sm.smSitetypeid) from SiteMaster sm where sm.smSitetypeid IN (:siteTypes) AND sm.smCustomerId IN (:customerId) order by sm.smSitetypeid")
	List<Integer> fetchSiteTypeId(Collection<Integer> siteTypes,List<String> customerId);
	
	@Query("SELECT DISTINCT sm.smSitecode from SiteMaster sm where sm.smSitetypeid IN (:siteTypes) AND sm.smCustomerId IN (:customerId) order by sm.smSitecode")
	List<String> fetchSiteCode(Collection<Integer> siteTypes,List<String> customerId);

	
}
