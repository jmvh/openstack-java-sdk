package com.woorea.openstack.v3.base.client;

import com.woorea.openstack.base.client.OpenStackResponse;

public interface OpenStackClientConnector {

	public <T> OpenStackResponse request(OpenStackRequest<T> request);

}
