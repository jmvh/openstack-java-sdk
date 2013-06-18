package com.woorea.openstack.v3.keystone;

import com.woorea.openstack.v3.base.client.OpenStackClient;
import com.woorea.openstack.v3.base.client.OpenStackClientConnector;
import com.woorea.openstack.v3.keystone.api.EndpointsResource;
import com.woorea.openstack.v3.keystone.api.RolesResource;
import com.woorea.openstack.v3.keystone.api.ServicesResource;
import com.woorea.openstack.v3.keystone.api.UsersResource;
import com.woorea.openstack.v3.keystone.api.ProjectsResource;
import com.woorea.openstack.v3.keystone.api.TokensResource;
import com.woorea.openstack.v3.keystone.api.TrustsResource;

public class Keystone extends OpenStackClient {
	
	private final TokensResource TOKENS;
	
	private final ProjectsResource PROJECTS;
	
	private final UsersResource USERS;
	
	private final RolesResource ROLES;
	
	private final ServicesResource SERVICES;
	
	private final EndpointsResource ENDPOINTS;
	
	private final TrustsResource TRUSTS;
	
	public Keystone(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		TOKENS = new TokensResource(this);
		PROJECTS = new ProjectsResource(this);
		USERS = new UsersResource(this);
		ROLES = new RolesResource(this);
		SERVICES = new ServicesResource(this);
		ENDPOINTS = new EndpointsResource(this);
		TRUSTS = new TrustsResource(this);
	}
	
	public Keystone(String endpoint) {
		this(endpoint, null);
	}
	
	public TokensResource tokens() {
		return TOKENS;
	}
	
	public ProjectsResource projects() {
		return PROJECTS;
	}
	
	public UsersResource users() {
		return USERS;
	}
	
	public RolesResource roles() {
		return ROLES;
	}
	
	public ServicesResource services() {
		return SERVICES;
	}
	
	public EndpointsResource endpoints() {
		return ENDPOINTS;
	}

	public TrustsResource trusts() {
		return TRUSTS;
	}
	
}
