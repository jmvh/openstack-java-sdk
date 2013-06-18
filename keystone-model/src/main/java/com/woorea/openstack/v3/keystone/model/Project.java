package com.woorea.openstack.v3.keystone.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import com.woorea.openstack.keystone.model.Link;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Project implements Serializable {

	@JsonProperty("domain_id")
	private String domainId;
	@JsonProperty("enabled")
	private Boolean enabled;
	@JsonProperty("id")
	private String id;
	@JsonProperty("links")
	private List<Link> links;
	@JsonProperty("name")
	private String name;	
	
	
	public Project(String name, String domainId, Boolean enabled) {
		this.name = name;
		this.domainId = domainId;
		this.enabled = enabled;
	}

	public Project() { }

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

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
