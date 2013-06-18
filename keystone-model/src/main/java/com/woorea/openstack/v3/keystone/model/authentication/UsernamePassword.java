package com.woorea.openstack.v3.keystone.model.authentication;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import com.woorea.openstack.v3.keystone.model.Authentication;

@JsonRootName("auth")
public class UsernamePassword extends Authentication {
	
	@JsonProperty("identity")
	private Identity identity = new Identity();
	
	public static final class Identity {
		
		@JsonProperty("methods")
		private List<String> methods = new ArrayList<String>();
		
		@JsonProperty("password")
		private PasswordCredentials passwordCredentials = new PasswordCredentials();

		public Identity() {
			methods.add(new String("password"));
		}
		
		public static final class PasswordCredentials {

			@JsonProperty("user")
			private User user = new User();

			private static final class User {

				@JsonProperty("id")
				private String id;
				@JsonProperty("password")
				private String password;

				public String getId() {
					return id;
				}
				public void setId(String id) {
					this.id = id;
				}
				public String getPassword() {
					return password;
				}
				public void setPassword(String password) {
					this.password = password;
				}

			}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

		}
		
		public PasswordCredentials getPasswordCredentials() {
			return this.passwordCredentials;
		}
		
		public void setPasswordCredentials(PasswordCredentials passwordCredentials) {
			this.passwordCredentials = passwordCredentials;
		}
	}
	
	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public UsernamePassword(String username, String password) {
		identity.getPasswordCredentials().getUser().setId(username);
		identity.getPasswordCredentials().getUser().setPassword(password);
	}
}
