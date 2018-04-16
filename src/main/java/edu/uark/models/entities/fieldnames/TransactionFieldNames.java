package edu.uark.models.entities.fieldnames;

import edu.uark.dataaccess.entities.BaseFieldNames;

//Naming conventions are based on TransactionTable.sql
//Id ("record_id") and created on are handled by BaseFieldNames from which this is extended

public class TransactionFieldNames extends BaseFieldNames {
	public static final String CASHIER_ID = "cashierid";
	public static final String TOTAL_AMOUNT = "totalamount";
	public static final String IS_REFUND = "isrefund";
	public static final String REFERENCE_ID = "referenceid";
}
