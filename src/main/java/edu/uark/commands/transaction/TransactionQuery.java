package edu.uark.commands.transaction;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionQuery implements ResultCommandInterface<Transaction> {
    @Override
    public Transaction execute() {
        TransactionEntity transactionEntity = this.transactionRepository.get(this.reference_id);
        if(transactionEntity != null) {
            return new Transaction(transactionEntity);
        }
        else {
            throw new NotFoundException("transaction");
        }
    }

    //Properties
    private UUID reference_id;
    public UUID getReferenceId() {
        return this.reference_id;
    }
    public TransactionQuery setReferenceId(UUID reference_id) {
        this.reference_id = reference_id;
        return this;
    }

    private TransactionRepositoryInterface transactionRepository;

    public TransactionRepositoryInterface getTransactionRepository() {
        return this.transactionRepository;
    }
    public TransactionQuery setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
        this.transactionRepository = transactionRepository;
        return this;
    }

    public TransactionQuery() {
        this.transactionRepository = new TransactionRepository();
    }
}
