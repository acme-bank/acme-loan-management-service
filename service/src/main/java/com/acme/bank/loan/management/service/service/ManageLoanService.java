package com.acme.bank.loan.management.service.service;

import com.acme.bank.loan.management.domain.entity.ManageLoanEntity;
import com.acme.bank.loan.management.domain.entity.PersonEntity;
import com.acme.bank.loan.management.domain.event.AugmentLoanEvent;
import com.acme.bank.loan.management.domain.event.EnrichLoanEvent;
import com.acme.bank.loan.management.domain.event.EntitleLoanEvent;
import com.acme.bank.loan.management.domain.event.PendingLoanEvent;
import com.acme.bank.loan.management.domain.event.RegisterLoanEvent;
import com.acme.bank.loan.management.domain.event.RejectLoanEvent;
import com.acme.bank.loan.management.domain.event.ValidateLoanEvent;
import com.acme.bank.loan.management.domain.model.ManageLoan;
import com.acme.bank.loan.management.service.repository.ManageLoanRepository;
import com.acme.bank.loan.management.service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ManageLoanService {

    private final ManageLoanRepository manageLoanRepository;
    private final PersonRepository personRepository;
    private final ConversionService conversionService;

    @Autowired
    public ManageLoanService(final ManageLoanRepository manageLoanRepository,
                             final PersonRepository personRepository,
                             final ConversionService conversionService) {
        this.manageLoanRepository = manageLoanRepository;
        this.personRepository = personRepository;
        this.conversionService = conversionService;
    }

    public List<ManageLoan> find() {
        List<ManageLoanEntity> entities = manageLoanRepository.findAll();
        return entities.stream()
                .map(this::convertManageLoanEntity)
                .collect(Collectors.toList());
    }

    public List<ManageLoan> find(String personalId) {
        List<ManageLoanEntity> entities = manageLoanRepository.findAllByPersonalId(personalId);
        return entities.stream()
                .map(this::convertManageLoanEntity)
                .collect(Collectors.toList());
    }

    public ManageLoan get(UUID uuid) {
        ManageLoanEntity entity = manageLoanRepository.findByUuid(uuid);
        return convertManageLoanEntity(entity);
    }

    public void save(RegisterLoanEvent event) {
        ManageLoanEntity manageLoanEntity = conversionService.convert(event, ManageLoanEntity.class);
        PersonEntity personEntity = personRepository.findByPersonalId(event.getPersonalId());
        manageLoanEntity.setPerson(personEntity);
        manageLoanRepository.save(manageLoanEntity);
    }

    public void save(ValidateLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByUuid(event.getUuid());
        entity.setValidatedTimestamp(event.getValidatedTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(EnrichLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByUuid(event.getUuid());
        entity.setEnrichedTimestamp(event.getEnrichedTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(PendingLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByUuid(event.getUuid());
        entity.setPendingTimestamp(event.getPendingTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(AugmentLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByUuid(event.getUuid());
        entity.setAugmentedTimestamp(event.getAugmentedTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(EntitleLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByUuid(event.getUuid());
        entity.setDetails(event.getDetails());
        entity.setEntitledTimestamp(event.getEntitledTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(RejectLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByUuid(event.getUuid());
        entity.setDetails(event.getDetails());
        entity.setRejectedTimestamp(event.getRejectedTimestamp());
        manageLoanRepository.save(entity);
    }

    private ManageLoan convertManageLoanEntity(ManageLoanEntity entity) {
        return conversionService.convert(entity, ManageLoan.class);
    }
}
