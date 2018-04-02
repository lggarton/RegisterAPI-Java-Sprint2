package edu.uark.models.repositories.interfaces;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.TransactionEntity;
//Probably needs to be edited for however we want to look up the transactions
public interface TransactionRepositoryInterface extends BaseRepositoryInterface<TransactionEntity> {
	TransactionEntity byLookupCode(String lookupCode);
}

