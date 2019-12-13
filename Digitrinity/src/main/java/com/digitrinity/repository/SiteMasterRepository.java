package com.digitrinity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitrinity.model.SiteMaster;

public interface SiteMasterRepository extends JpaRepository<SiteMaster, Long>{

	@Query("SELECT DISTINCT smCustomerName from SiteMaster order by smCustomerName")
	List<String> fetchCustomerNames();
	
	@Query("SELECT DISTINCT smSitetypeid from SiteMaster order by smSitetypeid")
	List<Integer> fetchSiteTypeId();
	
	@Query("SELECT DISTINCT smSitecode from SiteMaster order by smSitecode")
	List<String> fetchSiteCode();
	
	
}
