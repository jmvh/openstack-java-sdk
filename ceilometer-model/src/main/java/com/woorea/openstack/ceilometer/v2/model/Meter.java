package com.woorea.openstack.ceilometer.v2.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Meter {

	@JsonProperty("user_id")
	private String user;

    @JsonProperty("type")
    private String type;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("name")
    private String name;

	@JsonProperty("resource_id")
	private String resource;

	@JsonProperty("project_id")
	private String project;

	public String getUser() {
		return user;
	}

	public String getName() {
		return name;
	}

	public String getResource() {
		return resource;
	}

	public String getProject() {
		return project;
	}

	public String getType() {
		return type;
	}

    public String getUnit() {
        return unit;
    }

	@Override
	public String toString() {
		return "Meter [user=" + user + ", name=" + name + ", resource="
				+ resource + ", project=" + project + ", type=" + type + "]";
	}

}
