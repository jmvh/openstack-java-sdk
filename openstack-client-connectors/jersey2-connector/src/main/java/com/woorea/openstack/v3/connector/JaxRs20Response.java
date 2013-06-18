package com.woorea.openstack.v3.connector;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.v3.keystone.model.Token;

public class JaxRs20Response implements OpenStackResponse {
	
	private Response response;
	private String xAuthToken;
        
	public JaxRs20Response(Response response) {
		this.response = response;
                this.xAuthToken = null;
	}
        
        public JaxRs20Response(Response response, String xAuthToken) {
		this.response = response;
                this.xAuthToken = xAuthToken;
	}

	@Override
	public <T> T getEntity(Class<T> returnType) {
            T obj = response.readEntity(returnType);
            if(returnType == Token.class && xAuthToken != null) {
                ((Token) obj).setId(xAuthToken);
            }
            return obj;
	}

	@Override
	public InputStream getInputStream() {
            
		return (InputStream) response.getEntity();
	}

	@Override
	public String header(String name) {
		return response.getHeaderString(name);
	}

	@Override
	public Map<String, String> headers() {
		Map<String, String> headers = new HashMap<String, String>();
		for(String k : response.getHeaders().keySet()) {
			headers.put(k, response.getHeaderString(k));
		}
		return headers;
	}

}
