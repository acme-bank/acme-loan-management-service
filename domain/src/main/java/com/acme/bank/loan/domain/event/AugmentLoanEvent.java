package com.acme.bank.loan.domain.event;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AugmentLoanEvent {

    private UUID eventId;
    private ZonedDateTime augmentedTimestamp;

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public ZonedDateTime getAugmentedTimestamp() {
        return augmentedTimestamp;
    }

    public void setAugmentedTimestamp(ZonedDateTime augmentedTimestamp) {
        this.augmentedTimestamp = augmentedTimestamp;
    }
}
