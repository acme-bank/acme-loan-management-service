package com.acme.bank.loan.management.domain.event;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AugmentLoanEvent {

    private UUID uuid;
    private ZonedDateTime augmentedTimestamp;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public ZonedDateTime getAugmentedTimestamp() {
        return augmentedTimestamp;
    }

    public void setAugmentedTimestamp(ZonedDateTime augmentedTimestamp) {
        this.augmentedTimestamp = augmentedTimestamp;
    }
}
