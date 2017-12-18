package com.acme.bank.loan.management.domain.model;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ManageLoan {

    private UUID uuid;
    private Person person;
    private double amount;
    private LoanStatus loanStatus;
    private ZonedDateTime registeredTimestamp;
    private ZonedDateTime validatedTimestamp;
    private ZonedDateTime enrichedTimestamp;
    private ZonedDateTime pendingTimestamp;
    private ZonedDateTime augmentedTimestamp;
    private ZonedDateTime entitledTimestamp;
    private ZonedDateTime rejectedTimestamp;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
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
