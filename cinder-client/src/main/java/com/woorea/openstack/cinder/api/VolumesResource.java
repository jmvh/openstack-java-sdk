package com.woorea.openstack.cinder.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Volume;
import com.woorea.openstack.cinder.model.Volumes;

public class VolumesResource {
    
    private final OpenStackClient CLIENT;
    
    public VolumesResource(OpenStackClient client) {
        CLIENT = client;
    }
    
    public Create create(String tenantId, Volume volume) {
        return new Create(tenantId,volume);
    }
    
    public Show show(String tenantId, String volumeId) {
        return new Show(tenantId,volumeId);
    }
    
    public List list(String tenantId, boolean detail) {
        return new List(tenantId,detail);
    }
    
    public Update update(String tenantId, Volume volume) {
        return new Update(tenantId, volume);
    }

    public Delete delete(String tenantId, String volumeId) {
        return new Delete(tenantId, volumeId);
    }
    
    public class Create extends OpenStackRequest<Volume> {
        
        public Create(String tenantId,Volume volume) {
            super(CLIENT, HttpMethod.POST, "/volumes",Entity.json(volume), Volume.class);
            this.queryParam("tenant_id", tenantId);
        }
    }
    
    public class Show extends OpenStackRequest<Volume> {
        
        public Show(String tenantId,String volumeId) {
            super(CLIENT, HttpMethod.GET, "/volumes"+volumeId,null, Volume.class);
            this.queryParam("tenant_id", tenantId);
        }
    }
    
    public class List extends OpenStackRequest<Volumes> {
        
        public List(String tenantId, boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/volumes/detail" : "/volumes", null, Volumes.class);
            this.queryParam("tenant_id", tenantId);
        }
    }
    
    public class Update extends OpenStackRequest<Volume> {
        
        public Update(String tenantId, Volume volume) {
            super(CLIENT, HttpMethod.PUT, "/volumes"+volume.getId(), Entity.json(volume), Volume.class);
            this.queryParam("tenant_id", tenantId);
            this.queryParam("volume_id", volume.getId());
        }
    }
    
    public class Delete extends OpenStackRequest<Void> {
        
        public Delete(String tenantId, String volumeId) {
            super(CLIENT, HttpMethod.DELETE, "/volumes"+volumeId,null,Void.class);
            this.queryParam("tenant_id", tenantId);
            this.queryParam("volume_id", volumeId);
        }
        
    }
    
}

