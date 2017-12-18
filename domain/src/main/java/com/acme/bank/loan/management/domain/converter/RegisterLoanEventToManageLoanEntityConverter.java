package com.acme.bank.loan.management.domain.converter;

import com.acme.bank.loan.management.domain.entity.ManageLoanEntity;
import com.acme.bank.loan.management.domain.event.RegisterLoanEvent;
import org.springframework.stereotype.Component;

@Component
public class RegisterLoanEventToManageLoanEntityConverter extends AbstractConverter<RegisterLoanEvent, ManageLoanEntity> {

    @Override
    public ManageLoanEntity convert(RegisterLoanEvent event) {
        ManageLoanEntity entity = new ManageLoanEntity();
        entity.setUuid(event.getUuid());
        entity.setRegisteredTimestamp(event.getRegisteredTimestamp());
        return entity;
    }
}
