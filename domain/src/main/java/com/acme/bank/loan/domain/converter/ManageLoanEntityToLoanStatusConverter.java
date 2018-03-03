package com.acme.bank.loan.domain.converter;

import com.acme.bank.loan.domain.entity.ManageLoanEntity;
import com.acme.bank.loan.domain.model.LoanStatus;
import org.springframework.stereotype.Component;

@Component
public class ManageLoanEntityToLoanStatusConverter extends AbstractConverter<ManageLoanEntity, LoanStatus> {

    @Override
    public LoanStatus convert(ManageLoanEntity entity) {
        if (isRegistered(entity)) {
            return LoanStatus.REGISTERED;
        } else if (isValidated(entity)) {
            return LoanStatus.VALIDATED;
        } else if (isEnriched(entity)) {
            return LoanStatus.ENRICHED;
        } else if (isPending(entity)) {
            return LoanStatus.PENDING;
        } else if (isAugmented(entity)) {
            return LoanStatus.AUGMENTED;
        } else if (isEntitled(entity)) {
            return LoanStatus.ENTITLED;
        } else if (isRejected(entity)) {
            return LoanStatus.REJECTED;
        } else {
            return null;
        }
    }

    private boolean isRegistered(ManageLoanEntity entity) {
        return entity.getRegisteredTimestamp() != null &&
                entity.getValidatedTimestamp() == null &&
                entity.getEnrichedTimestamp() == null &&
                entity.getPendingTimestamp() == null &&
                entity.getAugmentedTimestamp() == null &&
                entity.getEntitledTimestamp() == null &&
                entity.getRejectedTimestamp() == null;
    }

    private boolean isValidated(ManageLoanEntity entity) {
        return entity.getValidatedTimestamp() != null &&
                entity.getEnrichedTimestamp() == null &&
                entity.getPendingTimestamp() == null &&
                entity.getAugmentedTimestamp() == null &&
                entity.getEntitledTimestamp() == null &&
                entity.getRejectedTimestamp() == null;
    }

    private boolean isEnriched(ManageLoanEntity entity) {
        return entity.getEnrichedTimestamp() != null &&
                entity.getPendingTimestamp() == null &&
                entity.getAugmentedTimestamp() == null &&
                entity.getEntitledTimestamp() == null &&
                entity.getRejectedTimestamp() == null;
    }

    private boolean isPending(ManageLoanEntity entity) {
        return entity.getPendingTimestamp() != null &&
                entity.getAugmentedTimestamp() == null &&
                entity.getEntitledTimestamp() == null &&
                entity.getRejectedTimestamp() == null;
    }

    private boolean isAugmented(ManageLoanEntity entity) {
        return entity.getAugmentedTimestamp() != null &&
                entity.getEntitledTimestamp() == null &&
                entity.getRejectedTimestamp() == null;
    }

    private boolean isEntitled(ManageLoanEntity entity) {
        return entity.getEntitledTimestamp() != null &&
                entity.getRejectedTimestamp() == null;
    }

    private boolean isRejected(ManageLoanEntity entity) {
        return entity.getEntitledTimestamp() == null &&
                entity.getRejectedTimestamp() != null;
    }
}
