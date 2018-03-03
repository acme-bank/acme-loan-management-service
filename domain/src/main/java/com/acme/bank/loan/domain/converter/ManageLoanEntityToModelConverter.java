package com.acme.bank.loan.domain.converter;

import com.acme.bank.loan.domain.entity.ManageLoanEntity;
import com.acme.bank.loan.domain.model.LoanStatus;
import com.acme.bank.loan.domain.model.ManageLoan;
import org.springframework.stereotype.Component;

@Component
public class ManageLoanEntityToModelConverter extends AbstractConverter<ManageLoanEntity, ManageLoan> {

    @Override
    public ManageLoan convert(ManageLoanEntity entity) {
        ManageLoan model = new ManageLoan();
        model.setEventId(entity.getEventId());
        model.setLoanStatus(conversionService.convert(entity, LoanStatus.class));
        model.setRegisteredTimestamp(entity.getRegisteredTimestamp());
        model.setValidatedTimestamp(entity.getValidatedTimestamp());
        model.setEnrichedTimestamp(entity.getEnrichedTimestamp());
        model.setPendingTimestamp(entity.getPendingTimestamp());
        model.setAugmentedTimestamp(entity.getAugmentedTimestamp());
        model.setEntitledTimestamp(entity.getEntitledTimestamp());
        model.setRejectedTimestamp(entity.getRejectedTimestamp());
        return model;
    }
}
