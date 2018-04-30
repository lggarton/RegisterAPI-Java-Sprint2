package edu.uark.commands.transactionEntry;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.api.TransactionEntry;
import edu.uark.models.entities.TransactionEntryEntity;
import edu.uark.models.repositories.TransactionEntryRepository;
import edu.uark.models.repositories.interfaces.TransactionEntryRepositoryInterface;

public class TransactionEntryQuery implements ResultCommandInterface<TransactionEntry> {
    @Override
    public TransactionEntry execute() {
        TransactionEntryEntity transactionEntryEntity = this.transactionEntryRepository.get(this.id);
        if(transactionEntryEntity != null) {
            return new TransactionEntry(transactionEntryEntity);
        }
        else {
            throw new NotFoundException("transactionEntry");
        }
    }

    //Properties
    private UUID id;
    public UUID getRecordId() {
        return this.id;
    }
    public TransactionEntryQuery setRecordId(UUID id) {
        this.id = id;
        return this;
    }

    private TransactionEntryRepositoryInterface transactionEntryRepository;

    public TransactionEntryRepositoryInterface getTransactionRepository() {
        return this.transactionEntryRepository;
    }
    public TransactionEntryQuery setTransactionEntryRepository(TransactionEntryRepositoryInterface transactionEntryRepository) {
        this.transactionEntryRepository = transactionEntryRepository;
        return this;
    }

    public TransactionEntryQuery() {
        this.transactionEntryRepository = new TransactionEntryRepository();
    }
}

