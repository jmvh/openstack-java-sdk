package com.woorea.openstack.cinder.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("volume_type")
public class Type {
    
    private String id;
    private String name;
    @JsonProperty("extra_specs")
    private Specs extraSpecs;

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

    public Specs getExtraSpecs() {
        return extraSpecs;
    }

    public void setExtraSpecs(Specs extraSpecs) {
        this.extraSpecs = extraSpecs;
    }
    
}