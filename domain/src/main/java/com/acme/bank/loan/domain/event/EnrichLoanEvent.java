package com.acme.bank.loan.domain.event;

import java.time.ZonedDateTime;
import java.util.UUID;

public class EnrichLoanEvent {

    private UUID eventId;
    private ZonedDateTime enrichedTimestamp;

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public ZonedDateTime getEnrichedTimestamp() {
        return enrichedTimestamp;
    }

    public void setEnrichedTimestamp(ZonedDateTime enrichedTimestamp) {
        this.enrichedTimestamp = enrichedTimestamp;
    }
}
