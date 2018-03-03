package com.acme.bank.loan.service.repository;

import com.acme.bank.loan.domain.entity.ManageLoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ManageLoanRepository extends JpaRepository<ManageLoanEntity, Long> {

    ManageLoanEntity findByEventId(UUID eventId);

    List<ManageLoanEntity> findAllByPersonId(UUID personId);
}
