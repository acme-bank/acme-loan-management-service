package com.acme.bank.loan.management.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Table(name = "MANAGE_LOAN")
@Entity
public class ManageLoanEntity {

    @Id
    private Long id;
    private UUID uuid;
    private String details;
    @ManyToOne
    private PersonEntity person;
    private ZonedDateTime registeredTimestamp;
    private ZonedDateTime validatedTimestamp;
    private ZonedDateTime enrichedTimestamp;
    private ZonedDateTime pendingTimestamp;
    private ZonedDateTime augmentedTimestamp;
    private ZonedDateTime entitledTimestamp;
    private ZonedDateTime rejectedTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public ZonedDateTime getRegisteredTimestamp() {
        return registeredTimestamp;
    }

    public void setRegisteredTimestamp(ZonedDateTime registeredTimestamp) {
        this.registeredTimestamp = registeredTimestamp;
    }

    public ZonedDateTime getValidatedTimestamp() {
        return validatedTimestamp;
    }

    public void setValidatedTimestamp(ZonedDateTime validatedTimestamp) {
        this.validatedTimestamp = validatedTimestamp;
    }

    public ZonedDateTime getEnrichedTimestamp() {
        return enrichedTimestamp;
    }

    public void setEnrichedTimestamp(ZonedDateTime enrichedTimestamp) {
        this.enrichedTimestamp = enrichedTimestamp;
    }

    public ZonedDateTime getPendingTimestamp() {
        return pendingTimestamp;
    }

    public void setPendingTimestamp(ZonedDateTime pendingTimestamp) {
        this.pendingTimestamp = pendingTimestamp;
    }

    public ZonedDateTime getAugmentedTimestamp() {
        return augmentedTimestamp;
    }

    public void setAugmentedTimestamp(ZonedDateTime augmentedTimestamp) {
        this.augmentedTimestamp = augmentedTimestamp;
    }

    public ZonedDateTime getEntitledTimestamp() {
        return entitledTimestamp;
    }

    public void setEntitledTimestamp(ZonedDateTime entitledTimestamp) {
        this.entitledTimestamp = entitledTimestamp;
    }

    public ZonedDateTime getRejectedTimestamp() {
        return rejectedTimestamp;
    }

    public void setRejectedTimestamp(ZonedDateTime rejectedTimestamp) {
        this.rejectedTimestamp = rejectedTimestamp;
    }
}
