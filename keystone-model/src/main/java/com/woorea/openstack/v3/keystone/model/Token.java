package com.woorea.openstack.v3.keystone.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.deser.std.UntypedObjectDeserializer;
import com.woorea.openstack.keystone.model.Link;

@JsonRootName("token")
public final class Token implements Serializable {
	
	//TODO Include optional project and catalog attributes
	//TODO Implement extras class, now it's just a placeholder
	
	// Map header X-Subject-Token here
	@JsonProperty("id")
	private String id;
	@JsonProperty("issued_at")
	private Calendar issuedAt;
	@JsonProperty("expires_at")
	private Calendar expiresAt;
	@JsonProperty("methods")
	private List<String> methods;
	@JsonProperty("user")
	private User user;
	@JsonProperty("extras")
	private Extras extras;
	@JsonProperty("roles")
	private List<Role> roles;
	@JsonProperty("OS-TRUST:trust")
	private OsTrust trust;
	@JsonProperty("project")
	private Project project;
	@JsonProperty("project_id")
	private String projectId;
	@JsonProperty("name")
	private String name;
	//TODO Handle catalog properly, not just as generic objects
	@JsonProperty("catalog")
	@JsonDeserialize(using = UntypedObjectDeserializer.class)
	private List<Object> catalog;
	
	public final class User implements Serializable {
		
		@JsonProperty("domain")
		private Domain domain;
		@JsonProperty("id")
		private String id;
		@JsonProperty("name")
		private String name;
		@JsonProperty("email")
		private String email;
		@JsonProperty("links")
		private List<Link> links;

		public final class Domain implements Serializable {
			
			@JsonProperty("id")
			private String id;
			@JsonProperty("links")
			private List<Link> links;
			@JsonProperty("name")
			private String name;
			
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public List<Link> getLinks() {
				return links;
			}
			public void setLinks(List<Link> links) {
				this.links = links;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
		}

		public Domain getDomain() {
			return domain;
		}

		public void setDomain(Domain domain) {
			this.domain = domain;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Link> getLinks() {
			return links;
		}

		public void setLinks(List<Link> links) {
			this.links = links;
		}
		
	}
	
	public class Extras implements Serializable {
		public Extras() {
			
		}
	}
	
	public class Role implements Serializable {
		
		@JsonProperty("project_id")
		private String projectId;
		@JsonProperty("id")
		private String id;
		@JsonProperty("name")
		private String name;
		
		@JsonCreator
		public Role() {
			
		}

		public String getProjectId() {
			return projectId;
		}

		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public class OsTrust implements Serializable {
		
		private String id;
		private boolean impersonation;
		private HashMap<String,String> links;
		private TrustUser trustee_user;
		private TrustUser trustor_user;
		
		public OsTrust() { }
		
		public class TrustUser implements Serializable {
			private String id;
			private HashMap<String,String> links;
			
			public TrustUser() { }

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public HashMap<String, String> getLinks() {
				return links;
			}

			public void setLinks(HashMap<String, String> links) {
				this.links = links;
			}
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public boolean isImpersonation() {
			return impersonation;
		}

		public void setImpersonation(boolean impersonation) {
			this.impersonation = impersonation;
		}

		public HashMap<String, String> getLinks() {
			return links;
		}

		public void setLinks(HashMap<String, String> links) {
			this.links = links;
		}

		public TrustUser getTrustee_user() {
			return trustee_user;
		}

		public void setTrustee_user(TrustUser trustee_user) {
			this.trustee_user = trustee_user;
		}

		public TrustUser getTrustor_user() {
			return trustor_user;
		}

		public void setTrustor_user(TrustUser trustor_user) {
			this.trustor_user = trustor_user;
		}
	}
	
	public class Project implements Serializable {
		@JsonProperty("domain")
		private Domain domain;
	    private String id;
	    private String name;
		
		public Project() {
			
		}
		
		public class Domain implements Serializable {
		    private String id;
		    private String name;
		    
		    public Domain() {
		    	
		    }

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
		}

		public Domain getDomain() {
			return domain;
		}

		public void setDomain(Domain domain) {
			this.domain = domain;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Calendar issuedAt) {
		this.issuedAt = issuedAt;
	}

	public Calendar getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Calendar expiresAt) {
		this.expiresAt = expiresAt;
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public Extras getExtras() {
		return extras;
	}

	public void setExtras(Extras extras) {
		this.extras = extras;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public OsTrust getTrust() {
		return trust;
	}

	public void setTrust(OsTrust trust) {
		this.trust = trust;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", Issued_at=" + issuedAt + ", expires=" + expiresAt + "]";
	}

}