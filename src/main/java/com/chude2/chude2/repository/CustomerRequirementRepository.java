package com.chude2.chude2.repository;

import com.chude2.chude2.entity.CustomerEntity;
import com.chude2.chude2.entity.CustomerRequirementEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRequirementRepository extends JpaRepository<CustomerRequirementEntity, Long> {
}
