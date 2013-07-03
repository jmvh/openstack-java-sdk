package com.woorea.openstack.cinder.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 *
 * @author Jussi Hynninen <jussi.hynninen@csc.fi>
 */
@JsonRootName("quota_set")
public class QuotaSet {
    @JsonProperty("id")
    private String projectId;
    private int gigabytes;
    private int volumes;
    private int snapshots;

    public String getProjectId() {
        return projectId;
    }

    public int getGigabytes() {
        return gigabytes;
    }

    public int getVolumes() {
        return volumes;
    }

    public int getSnapshots() {
        return snapshots;
    }
}
