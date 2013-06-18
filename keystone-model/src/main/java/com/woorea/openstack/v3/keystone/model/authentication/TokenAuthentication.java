package com.woorea.openstack.v3.keystone.model.authentication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import com.woorea.openstack.v3.keystone.model.Authentication;

@JsonRootName("auth")
public class TokenAuthentication extends Authentication {
	
	@JsonProperty("identity")
	private Identity identity = new Identity();
	@JsonProperty("scope")
	private Scope scope = new Scope();
	
	public static final class Identity {

		@JsonProperty("methods")
		private List<String> methods = new ArrayList<String>();
		
		@JsonProperty("token")
		private Token token = new Token();
		
		public Identity() {
			methods.add(new String("token"));
		}
		
		public static final class Token {

			@JsonProperty("id")
			private String id = new String();
			
			public Token() { }
			
			public String getId() {	
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}

		}
		
		public Token getToken() {
			return token;
		}

		public void setToken(Token token) {
			this.token = token;
		}
		
	}
	
	public class Scope implements Serializable {
        
		@JsonProperty("OS-TRUST:trust")
		private Trust trust = new Trust();
		
		public class Trust implements Serializable {

			@JsonProperty("id")
			private String id;
			
			public Trust() { }
			
			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}
			
			
        }

		public Trust getTrust() {
			return trust;
		}

		public void setTrust(Trust trust) {
			this.trust = trust;
		}
	}
	
	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public TokenAuthentication(String token) {
		identity.getToken().setId(token);
	}
	
}
