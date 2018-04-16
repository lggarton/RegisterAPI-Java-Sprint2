package edu.uark.controllers;

import java.util.UUID;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.transaction.TransactionQuery;
import edu.uark.commands.transaction.TransactionCreateCommand;
import edu.uark.models.api.Transaction;

@RestController
@RequestMapping(value = "/api/transaction")

public class TransactionRestController {

    //transaction exist check
    @RequestMapping(value = "/{reference_id}", method = RequestMethod.GET)
    public Transaction getTransaction(@PathVariable UUID referenceid) {
        return (new TransactionQuery()).
                setRecordId(referenceid).
                execute();
    }

    //create transaction
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Transaction TransactionCreateCommand(@RequestBody Transaction transaction) {
        return(new TransactionCreateCommand()).
            setApiTransaction(transaction).
                    execute();
    }
}
