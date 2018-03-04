package com.acme.bank.loan.domain.converter;

import com.acme.bank.loan.domain.entity.ManageLoanEntity;
import com.acme.bank.loan.domain.event.RegisterLoanEvent;
import org.springframework.stereotype.Component;

@Component
public class RegisterLoanEventToManageLoanEntityConverter extends AbstractConverter<RegisterLoanEvent, ManageLoanEntity> {

    @Override
    public ManageLoanEntity convert(RegisterLoanEvent registerLoanEvent) {
        ManageLoanEntity manageLoanEntity = new ManageLoanEntity();
        manageLoanEntity.setEventId(registerLoanEvent.getEventId());
        manageLoanEntity.setPersonId(registerLoanEvent.getPersonId());
        manageLoanEntity.setAmount(registerLoanEvent.getAmount());
        manageLoanEntity.setRegisteredTimestamp(registerLoanEvent.getRegisteredTimestamp());
        return manageLoanEntity;
    }
}
