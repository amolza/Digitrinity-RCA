package com.digitrinity.repository;

import com.digitrinity.model.CustomerRole;
import com.digitrinity.model.RoleUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRoleRepository extends JpaRepository<CustomerRole, Long>{
    @Override
    CustomerRole getOne(Long aLong);
}
