package com.woorea.openstack.v3.keystone.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.v3.keystone.model.Token;

/**
 * Command for validating a token
 * @author jhynnine
 *
 */
/**
 * Command for revoking a token
 * @author jhynnine
 *
 */
public class Revoke extends OpenStackRequest<Void> {

	public Revoke(Token token) {
		method(HttpMethod.DELETE);
		path("/auth/tokens");
		json(token);
		header("Accept", "application/json");
		header("X-Subject-Token",token.getId());
		returnType(Void.class);
	}
}
