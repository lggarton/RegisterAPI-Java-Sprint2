package edu.uark.models.repositories.interfaces;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.TransactionEntryEntity;
import java.util.UUID;

public interface TransactionEntryRepositoryInterface extends BaseRepositoryInterface<TransactionEntryEntity>{
    TransactionEntryEntity byEntryId(UUID entryId);
}
