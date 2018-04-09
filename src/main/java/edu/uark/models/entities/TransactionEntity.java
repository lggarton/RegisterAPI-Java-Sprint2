package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
//not sure what to do with createdOn elements rn
public class TransactionEntity extends BaseEntity<TransactionEntity> {

	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.record_id = ((UUID) rs.getObject(TransactionFieldNames.RECORD_ID));
        this.cashier_id = rs.getString(TransactionFieldNames.CASHIER_ID);
        this.total_amount = rs.getDouble(TransactionFieldNames.TOTAL_AMOUNT);
        this.transaction_type = rs.getString(TransactionFieldNames.TRANSACTION_TYPE);
        this.reference_id = ((UUID) rs.getObject(TransactionFieldNames.REFERENCE_ID));
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.RECORD_ID, this.record_id);
		record.put(TransactionFieldNames.CASHIER_ID, this.cashier_id);
		record.put(TransactionFieldNames.TOTAL_AMOUNT, this.total_amount);
		record.put(TransactionFieldNames.TRANSACTION_TYPE, this.transaction_type);
		record.put(TransactionFieldNames.REFERENCE_ID, this.reference_id);
		return record;
	}

	private UUID record_id;
	public UUID getRecordId() {
		return this.record_id;
	}
	public TransactionEntity setRecordId(UUID record_id) {
		if (!this.record_id.equals(record_id)) {
			this.record_id = record_id;
			this.propertyChanged(TransactionFieldNames.RECORD_ID);
		}
		
		return this;
	}
	
	private String cashier_id;
	public String getCashierId() {
		return this.cashier_id;
	}
	public TransactionEntity setCashierId(String cashier_id) {
		if (!StringUtils.equals(this.cashier_id, cashier_id)) {
			this.cashier_id = cashier_id;
			this.propertyChanged(TransactionFieldNames.CASHIER_ID);
		}
		
		return this;
	}
	
	private double total_amount;
	public double getTotalAmount() {
		return this.total_amount;
	}
	public TransactionEntity setTotalAmount(double total_amount) {
		if (this.total_amount != total_amount) {
			this.total_amount = total_amount;
			this.propertyChanged(TransactionFieldNames.TOTAL_AMOUNT);
		}
		
		return this;
	}
	
	private String transaction_type;
	public String getTransactionType() {
		return this.transaction_type;
	}
	public TransactionEntity setTransactionType(String transaction_type) {
		if (!StringUtils.equals(this.transaction_type, transaction_type)) {
			this.transaction_type = transaction_type;
			this.propertyChanged(TransactionFieldNames.TRANSACTION_TYPE);
		}
		
		return this;
	}
	
	private UUID reference_id;
	public UUID getReferenceId() {
		return this.reference_id;
	}
	public TransactionEntity setReferenceId(UUID reference_id) {
		if (!this.reference_id.equals(reference_id)) {
			this.reference_id = reference_id;
			this.propertyChanged(TransactionFieldNames.REFERENCE_ID);
		}
		
		return this;
	}
	
	public Transaction synchronize(Transaction apiTransaction) {
		//set apiTransaction.set(this.get[whatever]);
		this.setRecordId(apiTransaction.getRecordId());
		this.setCashierId(apiTransaction.getCashierId());
		this.setTotalAmount(apiTransaction.getTotalAmount());
		this.setTransactionType(apiTransaction.getTransactionType());
		this.setReferenceId(apiTransaction.getReferenceId());
		
		apiTransaction.setCreatedOn(this.getCreatedOn());
		
		return apiTransaction;
	}
	
	
	public TransactionEntity() {
		super(DatabaseTable.TRANSACTION);
		this.record_id = new UUID(0,0);
        this.cashier_id = StringUtils.EMPTY;
        this.total_amount = 0;
        this.transaction_type = StringUtils.EMPTY;
        this.reference_id = new UUID(0, 0);
	}

	public TransactionEntity(Transaction apiTransaction) {
		super(DatabaseTable.TRANSACTION);
		this.record_id = apiTransaction.getRecordId();
        this.cashier_id = apiTransaction.getCashierId();
        this.total_amount = apiTransaction.getTotalAmount();
        this.transaction_type = apiTransaction.getTransactionType();
        this.reference_id = apiTransaction.getReferenceId();
	}
}
