package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.ProductFieldNames;

public class ProductEntity extends BaseEntity<ProductEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.count = rs.getInt(ProductFieldNames.COUNT);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.COUNT, this.count);
		
		return record;
	}

	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public ProductEntity setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	
	private double price;
	public double getPrice() {
		return this.price;
	}
		
	private String status;
	public String getStatus() {
		return this.status;
	}
	
	public ProductEntity setQuantity(int quantity) {
		if (this.quantity != quantity) {
			this.quantity = quantity;
			this.propertyChanged(ProductFieldNames.QUANTITY);
		}
		
		return this;
	}
	
	public ProductEntity setPrice(double price) {
		if (this.price != price) {
			this.price = price;
			this.propertyChanged(ProductFieldNames.PRICE);
		}
		
		return this;
	}
	
	public ProductEntity setStatus(String status) {
		if (this.status != status) {
			this.status = status;
			this.propertyChanged(ProductFieldNames.STATUS);
		}
		
		return this;
	}
	
	public Product synchronize(Product apiProduct) {
		this.setCount(apiProduct.getCount());
		this.setLookupCode(apiProduct.getLookupCode());
		
		apiProduct.setId(this.getId());
		apiProduct.setCreatedOn(this.getCreatedOn());
		
		return apiProduct;
	}
	
	public ProductEntity() {
		super(DatabaseTable.PRODUCT);
		
		this.count = -1;
		this.lookupCode = StringUtils.EMPTY;
	}
	
	public ProductEntity(Product apiProduct) {
		super(DatabaseTable.PRODUCT);
		
		this.count = apiProduct.getCount();
		this.lookupCode = apiProduct.getLookupCode();
	}
}
