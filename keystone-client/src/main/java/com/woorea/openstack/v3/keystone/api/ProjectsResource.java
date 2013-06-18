package com.woorea.openstack.v3.keystone.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.v3.base.client.OpenStackClient;
import com.woorea.openstack.v3.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Roles;
import com.woorea.openstack.keystone.model.Users;
import com.woorea.openstack.v3.keystone.model.Project;
import com.woorea.openstack.v3.keystone.model.Projects;

public class ProjectsResource {
	
	// TODO go through all the methods and ensure they are valid - this is just a very straightforward
	// conversion from the old TenantsResource class 
	
	private OpenStackClient client;
	
	public ProjectsResource(OpenStackClient client) {
		this.client = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Create create(Project project) {
		return new Create(project);
	}
	
	public Show show(String id) {
		return new Show(id);
	}
	
	public Update update(String id, Project project) {
		return new Update(id, project);
	}
	
	public Delete delete(String id) {
		return new Delete(id);
	}
	
	public ListUsers listUsers(String tenantId) {
		return new ListUsers(tenantId);
	}
	
	public AddUser addUser(String tenantId, String userId, String roleId) {
		return new AddUser(tenantId, userId, roleId);
	}
	
	public RemoveUser removeUser(String tenantId, String userId, String roleId) {
		return new RemoveUser(tenantId, userId, roleId);
	}
	
	public ListUserRoles listUserRoles(String tenantId, String userId) {
		return new ListUserRoles(tenantId, userId);
	}

	public class List extends OpenStackRequest<Projects> {
		
		public List() {
			super(client, HttpMethod.GET, "/projects", null, Projects.class);
		}

	}
	
	public class Create extends OpenStackRequest<Project> {

		private Project project;
		
		public Create(Project project) {
			super(client, HttpMethod.POST, "/projects", Entity.json(project), Project.class);
			this.project = project;
		}
		
	}
	
	public class Show extends OpenStackRequest<Project> {
		
		public Show(String id) {
			super(client, HttpMethod.GET, new StringBuilder("/projects/").append(id).toString(), null, Project.class);
		}

	}
	
	public class Update extends OpenStackRequest<Project> {
		
		private Project project;
		
		public Update(String id, Project project) {
			super(client, HttpMethod.PUT, new StringBuilder("/projects/").append(id).toString(), Entity.json(project), Project.class);
			this.project = project;
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(client, HttpMethod.DELETE, new StringBuilder("/projects/").append(id).toString(), null, Void.class);
		}
		
	}
	
	public class ListUsers extends OpenStackRequest<Users> {
		
		public ListUsers(String projectId) {
			super(client, HttpMethod.GET, new StringBuilder("/projects/").append(projectId).append("/users").toString(), null, Users.class);
		}

	}
	
	public class AddUser extends OpenStackRequest<Void> {
		
		public AddUser(String projectId, String userId, String roleId) {
			super(client, HttpMethod.PUT, new StringBuilder("/projects/").append(projectId).append("/users").append(userId).append("/roles/OS-KSADM").append(roleId).toString(), null, Void.class);
		}

	}
	
	public class RemoveUser extends OpenStackRequest<Void> {
		
		public RemoveUser(String projectId, String userId, String roleId) {
			super(client, HttpMethod.DELETE, new StringBuilder("/projects/").append(projectId).append("/users").append(userId).append("/roles/OS-KSADM").append(roleId).toString(), null, Void.class);
		}

	}
	
	public class ListUserRoles extends OpenStackRequest<Roles> {
		
		public ListUserRoles(String projectId, String userId) {
			super(client, HttpMethod.GET, new StringBuilder("/projects/").append(projectId).append("/users").append(userId).append("/roles").toString(), null, Roles.class);
		}

	}
	
}
