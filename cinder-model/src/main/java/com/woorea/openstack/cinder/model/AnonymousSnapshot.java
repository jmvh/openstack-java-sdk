package com.woorea.openstack.cinder.model;

import java.util.Calendar;
import org.codehaus.jackson.annotate.JsonProperty;

public abstract class AnonymousSnapshot {
    
    // Attributes with setters needed for creating a request
    private String name;
    private String description;
    @JsonProperty("volume_id")
    private String volumeId;
    private boolean force;
    // Rest of the attributes in response
    private String status;
    @JsonProperty("created_at")
    private Calendar createdAt;
    private Metadata metadata;
    private int size;
    private String id;
    @JsonProperty("os-extended-snapshot-attributes:progress")
    private String extAttrProgress;
    @JsonProperty("os-extended-snapshot-attributes:project_id")
    private String extAttrProjectId;

    public AnonymousSnapshot() { }
    
    public AnonymousSnapshot(String name, String description,
                          String volumeId, boolean force) {
        this.name = name;
        this.description = description;
        this.volumeId = volumeId;
        this.force = force;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public boolean isForce() {
        return force;
    }

    public String getStatus() {
        return status;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public int getSize() {
        return size;
    }

    public String getId() {
        return id;
    }
    
    public String getExtAttrProgress() {
        return extAttrProgress;
    }

    public String getExtAttrProjectId() {
        return extAttrProjectId;
    }
    
}