package com.tvt.lifungbetest.repository;

import com.tvt.lifungbetest.enums.ERole;
import com.tvt.lifungbetest.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(ERole name);
}
