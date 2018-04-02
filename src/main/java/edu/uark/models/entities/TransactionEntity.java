package edu.uark.models.entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;

public class TransactionEntity extends BaseEntity<TransactionEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.active = rs.getBoolean(TransactionFieldNames.ACTIVE);
		this.password = rs.getString(TransactionFieldNames.PASSWORD);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.ACTIVE, this.active);
		record.put(TransactionFieldNames.PASSWORD, this.password);

		return record;
	}

	private String password;
	public String getPassword() {
		return this.password;
	}
	public EmployeeEntity setPassword(String password) {
		if (!StringUtils.equals(this.password, password)) {
			this.password = password;
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		}
		
		return this;
	}

	private boolean active;
	public boolean getActive() {
		return this.active;
	}
	public TransactionEntity setActive(boolean active) {
		if (this.active != active) {
			this.active = active;
			this.propertyChanged(TransactionFieldNames.ACTIVE);
		}
		
		return this;
	}
	
	public Transaction synchronize(Transaction apiTransaction) {
		this.setActive(apiTransaction.getActive());
		if (!StringUtils.isBlank(apiTransaction.getPassword())) {
			this.setPassword(
					TransactionEntity.hashPassword(
					apiTransaction.getPassword()));
		}
		
		apiTransaction.setId(this.getId());
		apiTransaction.setPassword(StringUtils.EMPTY); //Only send the password over the network when modifying the database.
		apiTransaction.setCreatedOn(this.getCreatedOn());
		
		return apiTransaction;
	}
	
	public static String hashPassword(String password) {
		String hashedPassword;

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes());
			hashedPassword = new String(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			hashedPassword = StringUtils.EMPTY;
		}
		
		return hashedPassword;
	}
	
	public TransactionEntity() {
		super(DatabaseTable.TRANSACTION);
		
		this.active = false;
		this.password = StringUtils.EMPTY;
	}

	public TransactionEntity(Transaction apiTransaction) {
		super(DatabaseTable.TRANSACTION);
		
		this.active = apiTransaction.getActive();
		this.password = TransactionEntity.hashPassword(
			apiTransaction.getPassword());
	}
}
