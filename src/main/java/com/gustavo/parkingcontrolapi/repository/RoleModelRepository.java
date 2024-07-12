package com.gustavo.parkingcontrolapi.repository;

import com.gustavo.parkingcontrolapi.enums.RoleName;
import com.gustavo.parkingcontrolapi.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleModelRepository extends JpaRepository<RoleModel, UUID> {
    RoleModel findByRoleName(RoleName roleName);

}