package com.woorea.openstack.cinder;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.cinder.api.QuotaSetResource;
import com.woorea.openstack.cinder.api.VolumesResource;
import com.woorea.openstack.cinder.api.TypesResource;
import com.woorea.openstack.cinder.api.SnapshotsResource;

public class Cinder extends OpenStackClient {
	
	private final VolumesResource VOLUMES;
	private final TypesResource TYPES;
	private final SnapshotsResource SNAPSHOTS;
        private final QuotaSetResource QUOTAS;
        
	public Cinder(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		VOLUMES = new VolumesResource(this);
		TYPES = new TypesResource(this);
		SNAPSHOTS = new SnapshotsResource(this);
                QUOTAS = new QuotaSetResource(this);
	}
	
	public Cinder(String endpoint) {
		this(endpoint, null);
	}
	
	public VolumesResource volumes() {
		return VOLUMES;
	}
	
	public TypesResource types() {
		return TYPES;
	}
	
	public SnapshotsResource snapshots() {
		return SNAPSHOTS;
	}
        
        public QuotaSetResource quotas() {
            return QUOTAS;
        }
	
}
