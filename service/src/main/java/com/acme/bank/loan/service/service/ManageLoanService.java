package com.acme.bank.loan.service.service;

import com.acme.bank.loan.domain.entity.ManageLoanEntity;
import com.acme.bank.loan.domain.entity.PersonEntity;
import com.acme.bank.loan.domain.event.*;
import com.acme.bank.loan.domain.model.ManageLoan;
import com.acme.bank.loan.domain.model.Person;
import com.acme.bank.loan.service.repository.ManageLoanRepository;
import com.acme.bank.loan.service.repository.PersonRepository;
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
                .map(this::convertManageLoanEntityToModel)
                .collect(Collectors.toList());
    }

    public List<ManageLoan> find(UUID personId) {
        List<ManageLoanEntity> entities = manageLoanRepository.findAllByPersonId(personId);
        return entities.stream()
                .map(this::convertManageLoanEntityToModel)
                .collect(Collectors.toList());
    }

    public ManageLoan get(UUID eventId) {
        ManageLoanEntity entity = manageLoanRepository.findByEventId(eventId);
        return convertManageLoanEntityToModel(entity);
    }

    public void save(RegisterLoanEvent event) {
        ManageLoanEntity manageLoanEntity = conversionService.convert(event, ManageLoanEntity.class);
        manageLoanRepository.save(manageLoanEntity);
    }

    public void save(ValidateLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByEventId(event.getEventId());
        entity.setValidatedTimestamp(event.getValidatedTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(EnrichLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByEventId(event.getEventId());
        entity.setEnrichedTimestamp(event.getEnrichedTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(PendingLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByEventId(event.getEventId());
        entity.setPendingTimestamp(event.getPendingTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(AugmentLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByEventId(event.getEventId());
        entity.setAugmentedTimestamp(event.getAugmentedTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(EntitleLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByEventId(event.getEventId());
        entity.setDetails(event.getDetails());
        entity.setEntitledTimestamp(event.getEntitledTimestamp());
        manageLoanRepository.save(entity);
    }

    public void save(RejectLoanEvent event) {
        ManageLoanEntity entity = manageLoanRepository.findByEventId(event.getEventId());
        entity.setDetails(event.getDetails());
        entity.setRejectedTimestamp(event.getRejectedTimestamp());
        manageLoanRepository.save(entity);
    }

    private ManageLoan convertManageLoanEntityToModel(ManageLoanEntity manageLoanEntity) {
        PersonEntity personEntity = personRepository.findByPersonId(manageLoanEntity.getPersonId());
        ManageLoan model = conversionService.convert(manageLoanEntity, ManageLoan.class);
        model.setPerson(conversionService.convert(personEntity, Person.class));
        return model;
    }
}
