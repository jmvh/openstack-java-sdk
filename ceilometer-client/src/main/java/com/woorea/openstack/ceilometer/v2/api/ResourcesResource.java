package com.woorea.openstack.ceilometer.v2.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.ceilometer.QueryFilter;
import com.woorea.openstack.ceilometer.v2.model.Resource;

import java.util.Iterator;

public class ResourcesResource {
	
	private OpenStackClient client;
	
	public ResourcesResource(OpenStackClient client) {
		this.client = client;
	}

    public List list() {
        return new List();
    }

    /**
     * Response type is always an array of Resource objects even if queried with resourceId.
     * Ceilometer V2 Web API return type for querying with resourceId is a single Resource object.
     */
    public class List extends OpenStackRequest<Resource[]> {
        public List() {
            super(client, HttpMethod.GET, "/resources", null, Resource[].class);
        }

        public List(java.util.List<QueryFilter> qf) {
            super(client, HttpMethod.GET, "/resources/", null, Resource[].class);
            Iterator it = qf.iterator();
            for ( int i = 0; i < qf.size(); i++ ) {
                this.queryParam("q.field", qf.get(i).getField());
                this.queryParam("q.op", qf.get(i).getOp());
                this.queryParam("q.value", qf.get(i).getValue());
            }
        }

        public List(String resourceId) {
            super(client, HttpMethod.GET, new StringBuilder("/resources/").append(resourceId).toString(), null, Resource[].class);
        }
    }
/*
	public class ResourceList extends QueriableCeilometerCommand<ResourceList, List<Resources>> {

		public ResourceList() {
			OpenStackRequest request = new OpenStackRequest();
			//return query(target.path("resources")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Resource>>() {});
		}

	}
	
	public class ResourceShow extends OpenStackRequest {

		private String id;
			
		public ResourceShow id(String id) {
			this.id = id;
			return this;
		}
		
		public ResourceShow(OpenStackClient client) {
//			if(id == null) {
//				throw new UnsupportedOperationException("resource id is mandatory");
//			}
//			return target.path("resources").path(id).request(MediaType.APPLICATION_JSON).get(Resource.class);
		}
    */
}
