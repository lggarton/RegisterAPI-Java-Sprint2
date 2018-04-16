package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.entities.TransactionEntity;

public class Transaction {
    private UUID id;
    public UUID getRecordId() {
        return this.id;
    }
    public Transaction setRecordId(UUID record_id) {
        this.id = record_id;
        return this;
    }

    private String cashierId;
    public String getCashierId() {
        return this.cashierId;
    }
    public Transaction setCashierId(String cashier_id) {
        this.cashierId = cashier_id;
        return this;
    }

    private double totalAmount;
    public double getTotalAmount() {
        return this.totalAmount;
    }
    public Transaction setTotalAmount(double totalamount) {
        this.totalAmount = totalamount;
        return this;
    }

    private boolean isRefund;
    public boolean getIsRefund() {return this.isRefund; }
    public Transaction setIsRefund( boolean isrefund) {
        this.isRefund = isrefund;
        return this;
    }

    private UUID referenceId;
    public UUID getReferenceId() {
        return this.referenceId;
    }
    public Transaction setReferenceId(UUID referenceid) {
        this.referenceId = referenceid;
        return this;
    }

    private LocalDateTime createdOn;
    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }
    public Transaction setCreatedOn(LocalDateTime createdon) {
        this.createdOn = createdon;
        return this;
    }

    public Transaction() {
        this.id = new UUID(0,0);
        this.cashierId = StringUtils.EMPTY;
        this.totalAmount = 0.00;
        this.isRefund = false;
        this.referenceId = new UUID(0, 0);
        this.createdOn = LocalDateTime.now();
    }

    public Transaction(TransactionEntity transactionEntity) {
        this.id = transactionEntity.getId();
        this.cashierId = transactionEntity.getCashierId();
        this.totalAmount = transactionEntity.getTotalAmount();
        this.isRefund = transactionEntity.getIsRefund();
        this.referenceId = transactionEntity.getReferenceId();
        this.createdOn = transactionEntity.getCreatedOn();

    }
}
