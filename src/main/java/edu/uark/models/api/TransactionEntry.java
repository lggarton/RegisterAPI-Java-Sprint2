package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.entities.TransactionEntryEntity;

public class TransactionEntry {
    private UUID id;
    public UUID getId() {
        return this.id;
    }
    public TransactionEntry setId(UUID id) {
        this.id = id;
        return this;
    }

    private UUID entryId;
    public UUID getEntryId() {
        return this.entryId;
    }
    public TransactionEntry setEntryId(UUID entryId) {
        this.entryId = entryId;
        return this;
    }

    private String lookupCode;
    public String getLookupCode() {
        return this.lookupCode;
    }
    public TransactionEntry setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
        return this;
    }

    private int quantity;
    public int getQuantity() { return this.quantity; }
    public TransactionEntry setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    private double price;
    public double getPrice() { return this.price; }
    public TransactionEntry setPrice(double price) {
        this.price = price;
        return this;
    }

    private LocalDateTime createdOn;
    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }
    public TransactionEntry setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public TransactionEntry() {
        this.id = new UUID(0, 0);
        this.entryId = new UUID(0, 0);
        this.lookupCode = "";
        this.quantity = 0;
        this.price = 0.00;
    }

    public TransactionEntry(TransactionEntryEntity transactionEntry) {
        this.id = transactionEntry.getId();
        this.entryId = transactionEntry.getEntryId();
        this.lookupCode = transactionEntry.getLookupCode();
        this.quantity = transactionEntry.getQuantity();
        this.price = transactionEntry.getPrice();
    }
}
