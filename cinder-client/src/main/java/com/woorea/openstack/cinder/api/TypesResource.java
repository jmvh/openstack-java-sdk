package com.woorea.openstack.cinder.api;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Type;
import com.woorea.openstack.cinder.model.Types;

public class TypesResource {
    
    private final OpenStackClient CLIENT;
    
    public TypesResource(OpenStackClient client) {
        CLIENT = client;
    }
    
    public List list(String tenantId) {
        return new List(tenantId);
    }
    
    public Show show(String tenantId, String volumeTypeId) {
        return new Show(tenantId, volumeTypeId);
    }
    
    public class List extends OpenStackRequest<Types> {
        
        public List(String tenantId) {
            super(CLIENT, HttpMethod.GET, "/types", null, Types.class);
            this.queryParam("tenant_id", tenantId);
        }
    }
    
    public class Show extends OpenStackRequest<Type> {
        
        public Show(String tenantId, String volumeTypeId) {
            super(CLIENT, HttpMethod.GET, "/types/"+volumeTypeId, null, Type.class);
            this.queryParam("tenant_id", tenantId);
            this.queryParam("volume_type_id", volumeTypeId);
        }
    }
}

