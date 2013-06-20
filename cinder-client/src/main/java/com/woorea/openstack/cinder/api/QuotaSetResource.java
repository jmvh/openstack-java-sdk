package com.woorea.openstack.cinder.api;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.QuotaSet;

public class QuotaSetResource {
    
    private final OpenStackClient CLIENT;
    
    public QuotaSetResource(OpenStackClient client) {
        CLIENT = client;
    }
    
    public Show show(String tenantId) {
        return new Show(tenantId);
    }
    
    public class Show extends OpenStackRequest<QuotaSet> {
        
        public Show(String tenantId) {
            super(CLIENT, HttpMethod.GET, "/os-quota-sets/"+tenantId, null, QuotaSet.class);
        }
    }
}

