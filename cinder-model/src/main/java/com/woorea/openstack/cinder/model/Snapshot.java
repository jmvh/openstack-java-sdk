package com.woorea.openstack.cinder.model;

import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 *
 * @author Jussi Hynninen <jussi.hynninen@csc.fi>
 */
@JsonRootName("snapshot")
public class Snapshot extends AnonymousSnapshot {
    
    public Snapshot() {
        super();
    }
    
    public Snapshot(String name, String description,
                    String volumeId, boolean force) {
        super(name, description, volumeId, force);
    }
}
