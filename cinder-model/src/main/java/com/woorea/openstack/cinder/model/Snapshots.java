package com.woorea.openstack.cinder.model;

import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class Snapshots implements Iterable {
    @JsonProperty("snapshots")
    private List<AnonymousSnapshot> snapshots;

    public List<AnonymousSnapshot> getSnapshots() {
        return snapshots;
    }

    @Override
    public Iterator iterator() {
        return snapshots.iterator();
    }
    
}