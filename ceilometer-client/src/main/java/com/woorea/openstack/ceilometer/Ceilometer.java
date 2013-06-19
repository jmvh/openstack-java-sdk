package com.woorea.openstack.ceilometer;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.ceilometer.v2.api.MetersResource;
import com.woorea.openstack.ceilometer.v2.api.ResourcesResource;
import com.woorea.openstack.ceilometer.v2.api.SamplesResource;
import com.woorea.openstack.ceilometer.v2.api.StatisticsResource;

public class Ceilometer extends OpenStackClient {
	
	private final MetersResource METERS;
	
	private final ResourcesResource RESOURCES;

    private final SamplesResource SAMPLES;

    private final StatisticsResource STATISTICS;
	
	public Ceilometer(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		METERS = new MetersResource(this);
		RESOURCES = new ResourcesResource(this);
        SAMPLES = new SamplesResource(this);
        STATISTICS = new StatisticsResource(this);
	}
	
	public Ceilometer(String endpoint) {
		this(endpoint, null);
		
	}
	
	public ResourcesResource resources() {
		return RESOURCES;
	}
	
	public MetersResource meters() {
		return METERS;
	}

    public SamplesResource samples() {
        return SAMPLES;
    }

}
