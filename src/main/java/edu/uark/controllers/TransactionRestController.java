package edu.uark.controllers;

import java.util.List;
import java.util.UUID;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.transaction.TransactionQuery;
import edu.uark.commands.transaction.TransactionCreateCommand;
import edu.uark.commands.transaction.TransactionUpdateCommand;
import edu.uark.commands.transaction.TransactionsQuery;
import edu.uark.models.api.Transaction;

@RestController
@RequestMapping(value = "/api/transaction")

public class TransactionRestController {

    //transactions query
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Transaction> getProducts() {
        return (new TransactionsQuery()).execute();
    }

    //transaction exist check
    @RequestMapping(value = "/{referenceid}", method = RequestMethod.GET)
    public Transaction getTransaction(@PathVariable UUID referenceid) {
        return (new TransactionQuery()).
                setRecordId(referenceid).
                execute();
    }

    //create transaction
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Transaction TransactionCreateCommand(@RequestBody Transaction transaction) {
        return(new TransactionCreateCommand()).
            setApiTransaction(transaction).
                    execute();
    }

    //update transaction
    @RequestMapping(value = "/{transactionId}", method = RequestMethod.PUT)
    public Transaction updateTransaction(@PathVariable UUID transactionId, @RequestBody Transaction transaction) {
        return(new TransactionUpdateCommand()).
                setTransactionId(transactionId).
                setApiTransaction(transaction).
                execute();
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Successful test. (TransactionRestController)";
    }
}
