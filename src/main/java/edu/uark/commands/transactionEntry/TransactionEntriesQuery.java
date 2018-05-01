package edu.uark.commands.transactionEntry;

import java.util.List;
import java.util.stream.Collectors;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.TransactionEntry;
import edu.uark.models.repositories.TransactionEntryRepository;
import edu.uark.models.repositories.interfaces.TransactionEntryRepositoryInterface;

public class TransactionEntriesQuery implements ResultCommandInterface<List<TransactionEntry>> {
    @Override
    public List<TransactionEntry> execute() {
        return this.transactionEntryRepository.
            all().
            stream().
            map(mp -> (new TransactionEntry(mp))).
            collect(Collectors.toList());
        }

    //Properties
    private TransactionEntryRepositoryInterface transactionEntryRepository;
    public TransactionEntryRepositoryInterface getTransactionEntryRepository() {
        return this.transactionEntryRepository;
    }
    public TransactionEntriesQuery setTransactionEntryRepository(TransactionEntryRepositoryInterface transactionEntryRepository) {
        this.transactionEntryRepository = transactionEntryRepository;
        return this;
    }

    public TransactionEntriesQuery() {
        this.transactionEntryRepository = new TransactionEntryRepository();
    }
}
