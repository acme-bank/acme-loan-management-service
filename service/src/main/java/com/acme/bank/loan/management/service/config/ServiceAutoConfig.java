package com.acme.bank.loan.management.service.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
        "com.acme.bank.loan.management.service"
})
@Configurable
public class ServiceAutoConfig {

}
