package com.woorea.openstack.v3.keystone.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.v3.base.client.OpenStackClient;
import com.woorea.openstack.v3.base.client.OpenStackRequest;
import com.woorea.openstack.v3.keystone.model.Authentication;
import com.woorea.openstack.v3.keystone.model.Token;
import com.woorea.openstack.v3.keystone.model.Trust;
import com.woorea.openstack.v3.keystone.model.authentication.AccessKey;
import com.woorea.openstack.v3.keystone.model.authentication.TokenAuthentication;
import com.woorea.openstack.v3.keystone.model.authentication.UsernamePassword;

public class TokensResource {
	
	private final OpenStackClient CLIENT;
	
	public TokensResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public Authenticate.Builder authenticate() {
		return new Authenticate().new Builder();
	}
	
	public Authenticate authenticate(Authentication authentication) {
		return new Authenticate(authentication);
	}
	
	public Validate validate(Token token) {
		return new Validate(token);
	}

	public class Authenticate extends OpenStackRequest<Token> {
		
		private Authentication authentication;
		
		public Authenticate() {
			
		}
		
		public Authenticate(Authentication authentication) {
			super(CLIENT, HttpMethod.POST, "/auth/tokens", Entity.json(authentication), Token.class);
			this.authentication = authentication;
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
				Authentication authentication = new UsernamePassword(username, password);
				return new Authenticate(authentication);
			}
			
			public Authenticate withToken(String token) {
				Authentication authentication = new TokenAuthentication(token);
				CLIENT.token(token);
				return new Authenticate(authentication);
			}
			
			public Authenticate withTrust(String token, Trust trust) {
				TokenAuthentication authentication = new TokenAuthentication(token);
				CLIENT.token(token);
				authentication.getScope().getTrust().setId(trust.getId());
				return new Authenticate(authentication);
			}
			
			public Authenticate withAccessKey(String accessKey, String secretKey) {
				Authentication authentication = new AccessKey(accessKey, secretKey);
				return new Authenticate(authentication);
			}
			
		}

	}
	
	public class Validate extends OpenStackRequest<Token> {

		public Validate(Token token) {
			super(CLIENT, HttpMethod.GET, "/auth/tokens", null, Token.class);
			header("X-Subject-Token",token.getId());
		}
	}
}
