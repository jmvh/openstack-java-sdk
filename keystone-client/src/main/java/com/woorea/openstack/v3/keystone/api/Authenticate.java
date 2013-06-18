package com.woorea.openstack.v3.keystone.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.v3.keystone.model.Authentication;
import com.woorea.openstack.v3.keystone.model.Token;
import com.woorea.openstack.v3.keystone.model.authentication.*;

public class Authenticate extends OpenStackRequest<Token> {

	private Authentication authentication;

	public Authenticate(Authentication authentication) {
		method(HttpMethod.POST);
		path("/auth/tokens");
		json(authentication);
		header("Accept", "application/json");
		header("x-auth-project-id",authentication.getTenantName());
		//returnType(Access.class);
		returnType(Token.class);
	}

	public Authenticate withTenantId(String tenantId) {
		authentication.setTenantId(tenantId);
		return this;
	}

	public Authenticate withTenantName(String tenantName) {
		authentication.setTenantName(tenantName);
		return this;
	}

	public class Builder {

		public Authenticate withUsernamePassword(String username, String password) {
			authentication = new UsernamePassword(username, password);
			return Authenticate.this;
		}

		public Authenticate withToken(String token) {
			authentication = new TokenAuthentication(token);
			return Authenticate.this;
		}

		public Authenticate withAccessKey(String accessKey, String secretKey) {
			authentication = new AccessKey(accessKey, secretKey);
			return Authenticate.this;
		}

	}

}
