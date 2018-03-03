package com.acme.bank.loan.domain.converter;

import com.acme.bank.loan.domain.entity.ManageLoanEntity;
import com.acme.bank.loan.domain.event.RegisterLoanEvent;
import org.springframework.stereotype.Component;

@Component
public class RegisterLoanEventToManageLoanEntityConverter extends AbstractConverter<RegisterLoanEvent, ManageLoanEntity> {

    @Override
    public ManageLoanEntity convert(RegisterLoanEvent event) {
        ManageLoanEntity manageLoanEntity = new ManageLoanEntity();
        manageLoanEntity.setEventId(event.getUuid());
        manageLoanEntity.setAmount(event.getAmount());
        manageLoanEntity.setRegisteredTimestamp(event.getRegisteredTimestamp());
        return manageLoanEntity;
    }
}
