package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.entities.TransactionEntity;

public class Transaction {
    private UUID record_id;
    public UUID getRecordId() {
        return this.record_id;
    }
    public Transaction setRecordId(UUID record_id) {
        this.record_id = record_id;
        return this;
    }

    private String cashier_id;
    public String getCashierId() {
        return this.cashier_id;
    }
    public Transaction setCashierId(String cashier_id) {
        this.cashier_id = cashier_id;
        return this;
    }

    private double total_amount;
    public double getTotalAmount() {
        return this.total_amount;
    }
    public Transaction setTotalAmount(double total_amount) {
        this.total_amount = total_amount;
        return this;
    }

    private String transaction_type;
    public String getTransactionType() {
        return this.transaction_type;
    }
    public Transaction setTransactionType(String transaction_type) {
        this.transaction_type = transaction_type;
        return this;
    }

    private UUID reference_id;
    public UUID getReferenceId() {
        return this.reference_id;
    }
    public Transaction setReferenceId(UUID reference_id) {
        this.reference_id = reference_id;
        return this;
    }

    private LocalDateTime created_on;
    public LocalDateTime getCreatedOn() {
        return this.created_on;
    }
    public Transaction setCreatedOn(LocalDateTime created_on) {
        this.created_on = created_on;
        return this;
    }

    public Transaction() {
        this.record_id = new UUID(0,0);
        this.cashier_id = StringUtils.EMPTY;
        this.total_amount = 0;
        this.transaction_type = StringUtils.EMPTY;
        this.reference_id = new UUID(0, 0);
        this.created_on = LocalDateTime.now();
    }

    public Transaction(TransactionEntity transactionEntity) {
        this.record_id = transactionEntity.getRecordId();
        this.cashier_id = transactionEntity.getCashierId();
        this.total_amount = transactionEntity.getTotalAmount();
        this.transaction_type = transactionEntity.getTransactionType();
        this.reference_id = transactionEntity.getReferenceId();
        this.created_on = transactionEntity.getCreatedOn();

    }
}
