package com.acme.bank.loan.management.service.config;

import com.acme.bank.loan.management.domain.converter.CountryConverter;
import com.acme.bank.loan.management.domain.converter.GenderConverter;
import com.acme.bank.loan.management.domain.converter.UUIDConverter;
import com.acme.bank.loan.management.domain.converter.ZonedDateTimeConverter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.acme.bank.loan.management.service.repository"})
@EntityScan(basePackageClasses = {
        Jsr310JpaConverters.class,
        ZonedDateTimeConverter.class,
        UUIDConverter.class,
        CountryConverter.class,
        GenderConverter.class},
        basePackages = {"com.acme.bank.loan.management.domain.entity"})
@Configuration
public class DatabaseConfig {

}
