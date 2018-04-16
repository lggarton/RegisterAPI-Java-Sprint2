package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.TransactionEntry;
import edu.uark.models.entities.fieldnames.TransactionEntryFieldNames;

public class TransactionEntryEntity extends BaseEntity<TransactionEntryEntity> {
    @Override
    protected void fillFromRecord(ResultSet rs) throws SQLException {
        this.entryId = (UUID) rs.getObject(TransactionEntryFieldNames.ENTRY_ID);
        this.lookupCode = rs.getString(TransactionEntryFieldNames.LOOKUP_CODE);
        this.quantity = rs.getInt(TransactionEntryFieldNames.QUANTITY);
        this.price = rs.getDouble(TransactionEntryFieldNames.PRICE);
    }

    @Override
    protected Map<String, Object> fillRecord(Map<String, Object> record) {
        record.put(TransactionEntryFieldNames.ENTRY_ID, this.entryId);
        record.put(TransactionEntryFieldNames.LOOKUP_CODE, this.lookupCode);
        record.put(TransactionEntryFieldNames.QUANTITY, this.quantity);
        record.put(TransactionEntryFieldNames.PRICE, this.price);

        return record;
    }

    private UUID entryId;
    public UUID getEntryId() {return this.entryId;}
    public TransactionEntryEntity setEntryId(UUID entryId) {
        if(this.entryId != entryId) {
            this.entryId = entryId;
            this.propertyChanged(TransactionEntryFieldNames.ENTRY_ID);
        }
        return this;
    }

    private String lookupCode;
    public String getLookupCode() { return this.lookupCode;}
    public TransactionEntryEntity setLookupCode(String lookupCode) {
        if(!StringUtils.equals(this.lookupCode, lookupCode)) {
            this.lookupCode = lookupCode;
            this.propertyChanged(TransactionEntryFieldNames.LOOKUP_CODE);
        }
        return this;
    }

    private int quantity;
    public int getQuantity() { return this.quantity;}
    public TransactionEntryEntity setQuantity(int quantity) {
        if(this.quantity != quantity) {
            this.quantity = quantity;
            this.propertyChanged(TransactionEntryFieldNames.QUANTITY);
        }
        return this;
    }

    private double price;
    public double getPrice() { return this.price; }
    public TransactionEntryEntity setPrice(double price) {
        if(this.price != price) {
            this.price = price;
            this.propertyChanged(TransactionEntryFieldNames.PRICE);
        }
        return this;
    }

    public TransactionEntry synchronize(TransactionEntry apiTransactionEntry) {
        this.setEntryId(apiTransactionEntry.getEntryId());
        this.setLookupCode(apiTransactionEntry.getLookupCode());
        this.setPrice(apiTransactionEntry.getPrice());
        this.setQuantity(apiTransactionEntry.getQuantity());

        apiTransactionEntry.setId(this.getId());
        return apiTransactionEntry;
    }

    public TransactionEntryEntity() {
        super(DatabaseTable.TRANSACTION_ENTRY);

        this.entryId = new UUID(0, 0);
        this.lookupCode = StringUtils.EMPTY;
        this.quantity = 0;
        this.price = 0.00;
    }

    public TransactionEntryEntity(TransactionEntry apiTransactionEntry) {
        super(DatabaseTable.TRANSACTION_ENTRY);

        this.entryId = apiTransactionEntry.getEntryId();
        this.lookupCode = apiTransactionEntry.getLookupCode();
        this.quantity = apiTransactionEntry.getQuantity();
        this.price = apiTransactionEntry.getPrice();
    }
}
