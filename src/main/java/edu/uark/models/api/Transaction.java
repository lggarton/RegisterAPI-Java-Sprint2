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

    private String cashierid;
    public String getCashierId() {
        return this.cashierid;
    }
    public Transaction setCashierId(String cashier_id) {
        this.cashierid = cashier_id;
        return this;
    }

    private double totalamount;
    public double getTotalAmount() {
        return this.totalamount;
    }
    public Transaction setTotalAmount(double totalamount) {
        this.totalamount = totalamount;
        return this;
    }

    private boolean isrefund;
    public boolean getIsRefund() {return this.isrefund; }
    public Transaction setIsRefund( boolean isrefund) {
        this.isrefund = isrefund;
        return this;
    }

    /*----------------------------------------------------------------------------------------------------------------*/
    /*A variable we planned for representing ("inStock||onBackorder||outOfStock") but is not in the SQL definition    */
    /*----------------------------------------------------------------------------------------------------------------*/
    /*

    private String transactiontype;
    public String getTransactionType() {
        return this.transactiontype;
    }
    public Transaction setTransactionType(String transactiontype) {
        this.transactiontype = transactiontype;
        return this;
    }

    */


    private UUID referenceid;
    public UUID getReferenceId() {
        return this.referenceid;
    }
    public Transaction setReferenceId(UUID referenceid) {
        this.referenceid = referenceid;
        return this;
    }

    private LocalDateTime createdon;
    public LocalDateTime getCreatedOn() {
        return this.createdon;
    }
    public Transaction setCreatedOn(LocalDateTime createdon) {
        this.createdon = createdon;
        return this;
    }

    public Transaction() {
        this.id = new UUID(0,0);
        this.cashierid = StringUtils.EMPTY;
        this.totalamount = 0;
        this.isrefund = false;
        //this.transactiontype = StringUtils.EMPTY;
        this.referenceid = new UUID(0, 0);
        this.createdon = LocalDateTime.now();
    }

    public Transaction(TransactionEntity transactionEntity) {
        this.id = transactionEntity.getRecordId();
        this.cashierid = transactionEntity.getCashierId();
        this.totalamount = transactionEntity.getTotalAmount();
        this.isrefund = transactionEntity.getIsRefund();
        //this.transactiontype = transactionEntity.getTransactionType();
        this.referenceid = transactionEntity.getReferenceId();
        this.createdon = transactionEntity.getCreatedOn();

    }
}
