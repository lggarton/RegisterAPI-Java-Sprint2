package edu.uark.commands.transaction;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionCreateCommand implements ResultCommandInterface<Transaction> {
    @Override
    public Transaction execute() {
        //Validations

        //maybe needed?
        /*if(StringUtils.isBlank(this.apiTransaction.getTransactionType())) {
            throw new UnprocessableEntityException("transaction_type");
        }*/


        if(StringUtils.isBlank(this.apiTransaction.getCashierId())) {
            throw new UnprocessableEntityException("cashier_id");
        }

        TransactionEntity transactionEntity = new TransactionEntity(this.apiTransaction);
        transactionEntity.save();

        //Synchronize information generated by database
        this.apiTransaction.setRecordId(transactionEntity.getId());
        this.apiTransaction.setCashierId(transactionEntity.getCashierId());
        this.apiTransaction.setCreatedOn(transactionEntity.getCreatedOn());

        return this.apiTransaction;
    }

    //Properties
    private Transaction apiTransaction;
    public Transaction getApiTransaction() {
        return this.apiTransaction;
    }
    public TransactionCreateCommand setApiTransaction(Transaction apiTransaction) {
        this.apiTransaction = apiTransaction;
        return this;
    }

    private TransactionRepositoryInterface transactionRepository;
    public TransactionRepositoryInterface getTransactionRepository() {
        return this.transactionRepository;
    }
    public TransactionCreateCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
        this.transactionRepository = transactionRepository;
        return this;
    }

    public TransactionCreateCommand() {
        this.transactionRepository = new TransactionRepository();
    }
}
