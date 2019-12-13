package com.digitrinity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitrinity.model.RegionMaster;

public interface RegionMasterRepository extends JpaRepository<RegionMaster, Long>{
	List<RegionMaster> findAllByOrderByRgRegionAsc();
}
