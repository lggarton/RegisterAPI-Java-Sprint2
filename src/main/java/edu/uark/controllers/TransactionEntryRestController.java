package edu.uark.controllers;

import java.util.UUID;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.transactionEntry.TransactionEntryCreateCommand;
import edu.uark.commands.transactionEntry.TransactionEntryQuery;
import edu.uark.models.api.TransactionEntry;
@RestController
@RequestMapping(value = "/api/transactionentry")

public class TransactionEntryRestController {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TransactionEntry createTransactionEntry(@RequestBody TransactionEntry transactionEntry ) {
        return (new TransactionEntryCreateCommand()).
                setApiTransactionEntry(transactionEntry).
                execute();
    }

    @RequestMapping(value = "/{recordId}", method = RequestMethod.GET)
    public TransactionEntry getTransactionEntry(@PathVariable UUID recordId) {
        return (new TransactionEntryQuery()).
                setRecordId(recordId).
                execute();
    }
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Successful test. (TransactionEntryRestController)";
    }
}
