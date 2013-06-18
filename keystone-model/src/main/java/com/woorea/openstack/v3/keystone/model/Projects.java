package com.woorea.openstack.v3.keystone.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Projects implements Iterable<Project>, Serializable {
 
	
	private List<Project> projects = new ArrayList<Project>();
	
	public Projects() {
		
	}

	public void addProject(Project project) {
		projects.add(project);
	}
	
	public void deleteProject(Project project) {
		projects.remove(project);
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public Iterator<Project> iterator() {
		return projects.iterator();
	}

}
