package com.acme.bank.loan.service.stream;

import com.acme.bank.loan.domain.config.AcmeProperties;
import com.acme.bank.loan.domain.config.KafkaTopic;
import com.acme.bank.loan.domain.event.PendingLoanEvent;
import com.acme.bank.loan.service.helper.KafkaHelper;
import com.acme.bank.loan.service.service.ManageLoanService;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SuppressWarnings({"Duplicates", "unchecked", "unused"})
@Component
public class PendingLoanKafkaStream {

    private static final Logger LOGGER = LoggerFactory.getLogger(PendingLoanKafkaStream.class);

    private final AcmeProperties acmeProperties;
    private KafkaStreams streams;
    private final KafkaHelper kafkaHelper;
    private final ManageLoanService manageLoanService;

    @Autowired
    public PendingLoanKafkaStream(final AcmeProperties acmeProperties,
                                  final KafkaHelper kafkaHelper,
                                  final ManageLoanService manageLoanService) {
        this.acmeProperties = acmeProperties;
        this.kafkaHelper = kafkaHelper;
        this.manageLoanService = manageLoanService;
    }

    @PostConstruct
    public void startStream() {
        StreamsBuilder streamBuilder = new StreamsBuilder();
        streamBuilder.stream(KafkaTopic.PENDING_LOANS.getTopicName(), kafkaHelper.consumedWith(PendingLoanEvent.class))
                .foreach(this::save);

        streams = new KafkaStreams(streamBuilder.build(), acmeProperties.kafkaProperties(KafkaTopic.PENDING_LOANS));
        streams.start();
    }

    private void save(String key, PendingLoanEvent event) {
        LOGGER.info("Received event with key {} on topic {}", key, KafkaTopic.PENDING_LOANS.getTopicName());

        LOGGER.info("Saving event with key {} to database", key);
        manageLoanService.save(event);
    }

    @PreDestroy
    public void closeStream() {
        if (streams != null) {
            streams.close();
        }
    }
}
