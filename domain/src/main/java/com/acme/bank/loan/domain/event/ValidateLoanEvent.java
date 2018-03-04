package com.acme.bank.loan.domain.event;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ValidateLoanEvent {

    private UUID eventId;
    private ZonedDateTime validatedTimestamp;

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public ZonedDateTime getValidatedTimestamp() {
        return validatedTimestamp;
    }

    public void setValidatedTimestamp(ZonedDateTime validatedTimestamp) {
        this.validatedTimestamp = validatedTimestamp;
    }
}
