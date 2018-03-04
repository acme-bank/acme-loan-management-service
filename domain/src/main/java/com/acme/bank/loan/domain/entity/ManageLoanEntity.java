package com.acme.bank.loan.domain.entity;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Table(name = "MANAGE_LOAN")
@Entity
public class ManageLoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID eventId;
    private UUID personId;
    private double amount;
    private String details;
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

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
