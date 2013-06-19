package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Extensions;
import com.woorea.openstack.nova.model.QuotaSet;

public class QuotaSetsExtension {
    
    private final OpenStackClient CLIENT;
    
    public QuotaSetsExtension(OpenStackClient client) {
        CLIENT = client;
    }
    
    public Show show(String tenantId) {
        return new Show(tenantId);
    }
    
    public Update update(String tenantId, QuotaSet quotaSet) {
        return new Update(tenantId, quotaSet);
    }
    
    public Defaults defaults(String tenantId) {
        return new Defaults(tenantId);
    }
    
    public class Show extends OpenStackRequest<QuotaSet> {
        
        public Show(String tenantId) {
            //super(CLIENT, HttpMethod.GET, "/v2/"+tenantId+"/os-quota-sets/"+tenantId, null, QuotaSet.class);
            super(CLIENT, HttpMethod.GET, "/os-quota-sets/"+tenantId, null, QuotaSet.class);
        }
        
    }
    
    public class Update extends OpenStackRequest<QuotaSet> {
        
        public Update(String tenantId, QuotaSet quotaSet) {
            super(CLIENT, HttpMethod.POST, "/os-quota-sets/"+tenantId, Entity.json(quotaSet), QuotaSet.class);
        }
        
    }
    
    public class Defaults extends OpenStackRequest<QuotaSet> {
        
        public Defaults(String tenantId) {
            super(CLIENT, HttpMethod.GET, "/os-quota-sets/"+tenantId+"/defaults", null, QuotaSet.class);
        }
        
    }
    
}

