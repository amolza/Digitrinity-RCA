package com.digitrinity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.digitrinity.model.ClusterMaster;

public interface ClusterMasterRepository extends CrudRepository<ClusterMaster, Long> {
	
	List<ClusterMaster> findAllByOrderByCrNameAsc();
}
