package com.acme.bank.loan.management.service.stream;

import com.acme.bank.loan.management.domain.config.AcmeProperties;
import com.acme.bank.loan.management.domain.event.RegisterLoanEvent;
import com.acme.bank.loan.management.service.helper.KafkaHelper;
import com.acme.bank.loan.management.service.service.ManageLoanService;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;

@SuppressWarnings({"Duplicates", "unchecked", "unused"})
@Component
public class RegisterLoanKafkaStream {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterLoanKafkaStream.class);

    private String applicationName;
    private final AcmeProperties acmeProperties;
    private KafkaStreams streams;
    private final KafkaHelper kafkaHelper;
    private final ManageLoanService manageLoanService;

    @Autowired
    public RegisterLoanKafkaStream(@Value("${spring.application.name}") String applicationName,
                                   final AcmeProperties acmeProperties,
                                   final KafkaHelper kafkaHelper,
                                   final ManageLoanService manageLoanService) {
        this.applicationName = applicationName;
        this.acmeProperties = acmeProperties;
        this.kafkaHelper = kafkaHelper;
        this.manageLoanService = manageLoanService;
    }

    @PostConstruct
    public void startStream() {
        AcmeProperties.Kafka.Topics topics = acmeProperties.getKafka().getTopics();

        StreamsBuilder streamBuilder = new StreamsBuilder();
        streamBuilder.stream(topics.getRegisterLoan(), kafkaHelper.consumedWith(RegisterLoanEvent.class))
                .foreach(this::save);

        streams = new KafkaStreams(streamBuilder.build(), properties());
        streams.start();
    }

    private void save(String key, RegisterLoanEvent event) {
        AcmeProperties.Kafka.Topics topics = acmeProperties.getKafka().getTopics();

        LOGGER.info("Received event with key {} on topic {}", key, topics.getRegisterLoan());

        LOGGER.info("Saving event with key {} to database", key);
        manageLoanService.save(event);
    }

    private Properties properties() {
        AcmeProperties.Kafka.Topics topics = acmeProperties.getKafka().getTopics();
        return kafkaHelper.properties(applicationName.concat("-").concat(topics.getRegisterLoan()));
    }

    @PreDestroy
    public void closeStream() {
        if (streams != null) {
            streams.close();
        }
    }
}
