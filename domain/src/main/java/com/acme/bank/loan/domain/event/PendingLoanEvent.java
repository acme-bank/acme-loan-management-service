package com.acme.bank.loan.domain.event;

import java.time.ZonedDateTime;
import java.util.UUID;

public class PendingLoanEvent {

    private UUID eventId;
    private ZonedDateTime pendingTimestamp;

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public ZonedDateTime getPendingTimestamp() {
        return pendingTimestamp;
    }

    public void setPendingTimestamp(ZonedDateTime pendingTimestamp) {
        this.pendingTimestamp = pendingTimestamp;
    }
}
