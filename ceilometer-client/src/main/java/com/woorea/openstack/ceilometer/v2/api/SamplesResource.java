package com.woorea.openstack.ceilometer.v2.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.ceilometer.QueryFilter;
import com.woorea.openstack.ceilometer.v2.model.Sample;

import java.util.Iterator;

public class SamplesResource {

    private final OpenStackClient client;

    public SamplesResource(OpenStackClient client) {
        this.client = client;
    }

    public List list(String meterId) {
        return new List(meterId);
    }

    public List list(String meterId, java.util.List<QueryFilter> qf) {
        return new List(meterId, qf);
    }

    public class List extends OpenStackRequest<Sample[]> {

        public List(String meterId) {
            super(client, HttpMethod.GET, new StringBuilder("/meters/").append(meterId).toString(), null, Sample[].class);
        }

        public List(String meterId, java.util.List< QueryFilter > qf) {
            super(client, HttpMethod.GET, new StringBuilder("/meters/").append(meterId).toString(), null, Sample[].class);
            Iterator it = qf.iterator();
            for ( int i = 0; i < qf.size(); i++ ) {
                this.queryParam("q.field", qf.get(i).getField());
                this.queryParam("q.op", qf.get(i).getOp());
                this.queryParam("q.value", qf.get(i).getValue());
            }
        }
    }


}
