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

//createdon and id fields are handled by the BaseEntity from which TransactionEntity is extended

public class TransactionEntity extends BaseEntity<TransactionEntity> {

	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.cashierId = rs.getString(TransactionFieldNames.CASHIER_ID);
		this.totalAmount = rs.getDouble(TransactionFieldNames.TOTAL_AMOUNT);
		this.isRefund = rs.getBoolean(TransactionFieldNames.IS_REFUND);
		this.transactionType = rs.getInt(TransactionFieldNames.IS_REFUND);
		this.referenceId = (UUID) rs.getObject(TransactionFieldNames.REFERENCE_ID);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.CASHIER_ID, this.cashierId);
		record.put(TransactionFieldNames.TOTAL_AMOUNT, this.totalAmount);
		record.put(TransactionFieldNames.IS_REFUND, this.isRefund);
		record.put(TransactionFieldNames.TRANSACTION_TYPE, this.transactionType);
		record.put(TransactionFieldNames.REFERENCE_ID, this.referenceId);

		return record;
	}

	private String cashierId;
	public String getCashierId() {
		return this.cashierId;
	}
	public TransactionEntity setCashierId(String cashierId) {
		if (!StringUtils.equals(this.cashierId, cashierId)) {
			this.cashierId = cashierId;
			this.propertyChanged(TransactionFieldNames.CASHIER_ID);
		}
		
		return this;
	}

	private double totalAmount;
	public double getTotalAmount() {
		return this.totalAmount;
	}
	public TransactionEntity setTotalAmount(double totalAmount) {
		if (this.totalAmount != totalAmount) {
			this.totalAmount = totalAmount;
			this.propertyChanged(TransactionFieldNames.TOTAL_AMOUNT);
		}
		
		return this;
	}

	private boolean isRefund;
	public boolean getIsRefund() { return this.isRefund; }
	public TransactionEntity setIsRefund(boolean isRefund) {
		if(this.isRefund != isRefund) {
			this.isRefund = isRefund;
			this.propertyChanged(TransactionFieldNames.IS_REFUND);
		}
		return this;
	}

	private int transactionType;
	public int getTransactionType() { return this.transactionType; }
	public TransactionEntity setTransactionType(int transactionType) {
		if(this.transactionType != transactionType) {
			this.transactionType = transactionType;
			this.propertyChanged(TransactionFieldNames.TRANSACTION_TYPE);
		}
		return this;
	}

	private UUID referenceId;
	public UUID getReferenceId() {return this.referenceId; }
	public TransactionEntity setReferenceId(UUID referenceId) {
		if(!this.referenceId.equals(referenceId)) {
			this.referenceId = referenceId;
			this.propertyChanged(TransactionFieldNames.REFERENCE_ID);
		}
		return this;
	}

	public Transaction synchronize(Transaction apiTransaction) {
		this.setCashierId(apiTransaction.getCashierId());
		this.setTotalAmount(apiTransaction.getTotalAmount());
		this.setIsRefund(apiTransaction.getIsRefund());
		this.setTransactionType(apiTransaction.getTransactionType());
		this.setReferenceId(apiTransaction.getReferenceId());

		apiTransaction.setRecordId(this.getId());
		apiTransaction.setCreatedOn(this.getCreatedOn());
		return apiTransaction;
	}

	
	
	public TransactionEntity() {
		super(DatabaseTable.TRANSACTION);

		this.cashierId = StringUtils.EMPTY;
		this.totalAmount = 0.00;
		this.transactionType = 0;
		this.referenceId = new UUID(0, 0);
	}

	public TransactionEntity(Transaction apiTransaction) {
		super(DatabaseTable.TRANSACTION);
		
		this.cashierId = apiTransaction.getCashierId();
		this.totalAmount = apiTransaction.getTotalAmount();
		this.transactionType = apiTransaction.getTransactionType();
		this.referenceId = apiTransaction.getReferenceId();
	}
}
