package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Volumes implements Iterable<Volume>, Serializable {
    
    @JsonProperty("volumes")
    private List<Volume> volumes;
    
    public List<Volume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }
    
    @Override
    public Iterator<Volume> iterator() {
        return this.volumes.iterator();
    }
	
}
