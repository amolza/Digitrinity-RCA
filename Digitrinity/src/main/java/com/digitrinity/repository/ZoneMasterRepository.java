package com.digitrinity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.digitrinity.model.ZoneMaster;

public interface ZoneMasterRepository extends CrudRepository<ZoneMaster, Long> {

	List<ZoneMaster> findAllByOrderByZnZoneAsc();
}
