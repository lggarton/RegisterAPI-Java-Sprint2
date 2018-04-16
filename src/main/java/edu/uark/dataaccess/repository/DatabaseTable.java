package edu.uark.dataaccess.repository;

public enum DatabaseTable {
	NONE(""),
	PRODUCT("product"),
	EMPLOYEE("employee"),
<<<<<<< HEAD
	TRANSACTION("transaction");
=======
	TRANSACTION("transaction"),
	TRANSACTION_ENTRY("transactionentry");
>>>>>>> 4d6e469847ee64a6ac4e5dcdba89c930c5e51c6e
	
	public String getLabel() {
		return label;
	}
	
	private final String label;
	
	private DatabaseTable(String label) {
		this.label = label;
	}
}
