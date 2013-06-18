package com.woorea.openstack.v3.keystone.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

public abstract class Authentication implements Serializable {

	@JsonIgnore
	private String tenantId;
	@JsonIgnore
	private String tenantName;

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return the tenantName
	 */
	public String getTenantName() {
		return tenantName;
	}

	/**
	 * @param tenantName the tenantName to set
	 */
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
}
