package com.digitrinity.repository;

import com.digitrinity.model.Role;
import com.digitrinity.model.RoleUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<RoleUsers, Long>{
    @Override
    RoleUsers getOne(Long aLong);
}
