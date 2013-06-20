package com.woorea.openstack.cinder.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Jussi Hynninen <jussi.hynninen@csc.fi>
 */
public class Specs {
    
    @JsonProperty("capabilities")
    private String capabilities;
    
    public String getCapabilities() {
        return capabilities;
    }
    
    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }
    
}
