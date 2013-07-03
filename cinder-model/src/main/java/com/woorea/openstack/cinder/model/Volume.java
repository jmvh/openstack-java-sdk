package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

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
    private String status;
    private List<Attachment> attachments;
    @JsonProperty("display_name")
    private String displayName;
    private boolean bootable;
    private Calendar created_at;
    @JsonProperty("display_description")
    private String displayDescription;
    @JsonProperty("snapshot_id")
    private String snapshotId;
    @JsonProperty("source_volid")
    private String sourceVolId;
    
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

    public String getStatus() {
        return status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isBootable() {
        return bootable;
    }

    public Calendar getCreated_at() {
        return created_at;
    }

    public String getDisplayDescription() {
        return displayDescription;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public String getSourceVolId() {
        return sourceVolId;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public static class Attachment {
        private String device;
        @JsonProperty("server_id")
        private String serverId;
        private String id;
        @JsonProperty("volume_id")
        private String volumeId;
        public Attachment() {
        }

        public String getDevice() {
            return device;
        }

        public String getServerId() {
            return serverId;
        }

        public String getId() {
            return id;
        }

        public String getVolumeId() {
            return volumeId;
        }
        
    }
    
}
