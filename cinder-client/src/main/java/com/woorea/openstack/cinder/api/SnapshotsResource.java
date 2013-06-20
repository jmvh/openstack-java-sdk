package com.woorea.openstack.cinder.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Snapshot;
import com.woorea.openstack.cinder.model.Snapshots;

public class SnapshotsResource {
    
    private final OpenStackClient CLIENT;
    
    public SnapshotsResource(OpenStackClient client) {
        CLIENT = client;
    }
    
    public Create create(String tenantId, Snapshot partialSnapshot) {
        return new Create(tenantId,partialSnapshot);
    }
    
    public List list(String tenantId, boolean detail) {
        return new List(tenantId, detail);
    }
    
    public Show show(String tenantId, String snapshotId) {
        return new Show(tenantId, snapshotId);
    }
    
    public Update update(String tenantId, Snapshot snapshot) {
        return new Update(tenantId, snapshot);
    }
    
    public class Create extends OpenStackRequest<Snapshot> {
        
        public Create(String tenantId, Snapshot partialSnapshot) {
            super(CLIENT, HttpMethod.POST,"/snapshots",Entity.json(partialSnapshot),Snapshot.class);
            this.queryParam("tenant_id", tenantId);
            this.queryParam("volume_id", partialSnapshot.getVolumeId());
            //TODO API documentation describes this very ambiguously
            //this.queryParam("snapshot", partialSnapshot);
        }
    }
    
    public class List extends OpenStackRequest<Snapshots> {
        
        public List(String tenantId, boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/snapshots/detail" : "/snapshots", null, Snapshots.class);
            this.queryParam("tenant_id", tenantId);
        }
    }
    
    public class Show extends OpenStackRequest<Snapshot> {
        
        public Show(String tenantId, String snapshotId) {
            super(CLIENT, HttpMethod.GET, "/snapshots/"+snapshotId, null, Snapshot.class);
            this.queryParam("tenant_id", tenantId);
            this.queryParam("snapshot_id", snapshotId);
        }
    }
    
    public class Update extends OpenStackRequest<Snapshot> {
        
        public Update(String tenantId, Snapshot snapshot) {
            super(CLIENT, HttpMethod.PUT, "/snapshots/"+snapshot.getId(), Entity.json(snapshot), Snapshot.class);
            this.queryParam("tenant_id", tenantId);
            this.queryParam("snapshot_id", snapshot.getId());
        }
    }
    
    public class Delete extends OpenStackRequest<Void> {

        public Delete(String tenantId, String snapshotId) {
            super(CLIENT, HttpMethod.DELETE, "/snapshots/"+snapshotId, null, Void.class);
            this.queryParam("tenant_id", tenantId);
            this.queryParam("snapshot_id", snapshotId);
        }
    }

}