package com.woorea.openstack.v3.keystone.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.woorea.openstack.v3.keystone.model.util.TrustDateDeserializer;
import com.woorea.openstack.v3.keystone.model.util.TrustDateSerializer;

@JsonRootName("trust")
public class Trust implements Serializable {

	@JsonProperty("expires_at")
	@JsonDeserialize(using = TrustDateDeserializer.class)
	@JsonSerialize(using = TrustDateSerializer.class)
	private Calendar expiresAt;
	private String id;
	private boolean impersonation;
	//private List<Link> links;
	private HashMap<String,String> links;
	@JsonProperty("project_id")
	private String projectId;

	public static final class Role implements Serializable {
		private String id;
		//private List<Link> links;
		private HashMap<String,String> links;
		private String name;

		public String getId() {
			return id;
		}
		//public List<Link> getLinks() {
		public HashMap<String,String> getLinks() {
			return links;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		} 
	}

	private List<Role> roles;
	@JsonProperty("roles_links")
	//private List<Link> rolesLinks;
	private HashMap<String,String> rolesLinks;
	@JsonProperty("trustee_user_id")
	private String trusteeUserId;
	@JsonProperty("trustor_user_id")
	private String trustorUserId;

	public Calendar getExpiresAt() {
		return expiresAt;
	}
	public String getId() {
		return id;
	}
	public boolean isImpersonation() {
		return impersonation;
	}
	//public List<Link> getLinks() {
	public HashMap<String,String> getLinks() {
		return links;
	}
	public String getProjectId() {
		return projectId;
	}
	public List<Role> getRoles() {
		return roles;
	}
	//public List<Link> getRolesLinks() {
	public HashMap<String,String> getRolesLinks() {
		return rolesLinks;
	}
	public String getTrusteeUserId() {
		return trusteeUserId;
	}

	public String getTrustorUserId() {
		return trustorUserId;
	}
	public void setExpiresAt(Calendar expiresAt) {
		this.expiresAt = expiresAt;
	}
	public void setImpersonation(boolean impersonation) {
		this.impersonation = impersonation;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setTrusteeUserId(String trusteeUserId) {
		this.trusteeUserId = trusteeUserId;
	}
	public void setTrustorUserId(String trustorUserId) {
		this.trustorUserId = trustorUserId;
	}

	public String toString() {
		return "Trust [expiresAt=" + expiresAt
				+ ", id=" + id
				+ ", impersonation=" + impersonation
				+ ", links=" + links
				+ ", projectId=" + projectId
				+ ", roles=" + roles
				+ ", rolesLinks=" + rolesLinks
				+ ", trusteeUserId=" + trusteeUserId
				+ ", trustorUserId=" + trustorUserId
				+ "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setLinks(HashMap<String, String> links) {
		this.links = links;
	}
	public void setRolesLinks(HashMap<String, String> rolesLinks) {
		this.rolesLinks = rolesLinks;
	}

}
