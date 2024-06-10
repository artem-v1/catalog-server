package com.server.catalog.DTO;

import java.io.Serializable;

public class ReferenceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1521986003968637441L;
	
    private long referenceId;
    private String scope;
    private String key;
    private String value;
    private String icon;
    private Integer sortOrder;
    
	public ReferenceDTO() {
		super();
	}

	public ReferenceDTO(long referenceId, String scope, String key, String value, String icon, Integer sortOrder) {
		super();
		this.referenceId = referenceId;
		this.scope = scope;
		this.key = key;
		this.value = value;
		this.icon = icon;
		this.sortOrder = sortOrder;
	}

	public long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(long referenceId) {
		this.referenceId = referenceId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	
    

}
