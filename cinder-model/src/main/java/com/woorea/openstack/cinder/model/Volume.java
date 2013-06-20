package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.HashMap;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("volume")
public class Volume implements Serializable {

    // Attributes with setters needed for creating a request
    private String name;
    private String description;
    private int size;
    @JsonProperty("volume_type")
    private String volumeType;
    @JsonProperty("availability_zone")
    private String availabilityZone;
    private Metadata metadata;
    // Rest of the attributes in response
    private String id;
    private HashMap<String,String> links;
    
    
    public Volume() { }
    public Volume(String name, String description,
                  int size, String volumeName,
                  String availabilityZone, String metadata) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.volumeType = volumeName;
        this.availabilityZone = availabilityZone;
        this.metadata = new Metadata();
        this.metadata.setContents(metadata);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getSize() {
        return size;
    }

    public String getVolumeType() {
        return volumeType;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, String> getLinks() {
        return links;
    }
    
}
