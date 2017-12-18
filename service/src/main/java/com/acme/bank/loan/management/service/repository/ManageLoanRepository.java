package com.acme.bank.loan.management.service.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.bank.loan.management.domain.entity.ManageLoanEntity;

@Repository
public interface ManageLoanRepository extends JpaRepository<ManageLoanEntity, Long> {

    ManageLoanEntity findByUuid(UUID uuid);

    List<ManageLoanEntity> findAllByPersonalId(String personalId);
}
