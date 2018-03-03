package com.acme.bank.loan.domain.config;

public enum KafkaTopic {

    REGISTERED_LOANS("registered-loans"),
    VALIDATED_LOANS("validated-loans"),
    ENRICHED_LOANS("enriched-loans"),
    ENTITLED_LOANS("entitled-loans"),
    PENDING_LOANS("pending-loans"),
    AUGMENTED_LOANS("augmented-loans"),
    REJECTED_LOANS("rejected-loans");

    private String topicName;

    KafkaTopic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
