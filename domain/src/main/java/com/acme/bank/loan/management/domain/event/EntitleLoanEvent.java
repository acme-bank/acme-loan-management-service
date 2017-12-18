package com.acme.bank.loan.management.domain.event;

import java.time.ZonedDateTime;
import java.util.UUID;

public class EntitleLoanEvent {

    private UUID uuid;
    private String details;
    private ZonedDateTime entitledTimestamp;

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

    public ZonedDateTime getEntitledTimestamp() {
        return entitledTimestamp;
    }

    public void setEntitledTimestamp(ZonedDateTime entitledTimestamp) {
        this.entitledTimestamp = entitledTimestamp;
    }
}
