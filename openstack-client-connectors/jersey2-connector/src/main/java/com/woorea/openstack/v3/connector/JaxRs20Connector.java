package com.woorea.openstack.v3.connector;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.filter.LoggingFilter;

import com.woorea.openstack.v3.base.client.OpenStackClientConnector;
import com.woorea.openstack.v3.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.base.client.OpenStackResponseException;
import com.woorea.openstack.v3.keystone.model.Token;
import java.util.Iterator;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class JaxRs20Connector implements OpenStackClientConnector {
    
    protected Client client = OpenStack.CLIENT;
    
    @Override
    public <T> OpenStackResponse request(OpenStackRequest<T> request) {
        Iterator<Map.Entry<String, List<Object>>> iter = request.queryParams().entrySet().iterator();
        UriBuilder ub = UriBuilder.fromUri(request.endpoint());
        ub.path(request.path());
        while(iter.hasNext()) {
            Map.Entry<String, List<Object>> param = iter.next();
            for(Object obj : param.getValue()) {
                ub.queryParam(param.getKey(), obj);
            }
        }
        WebTarget target = client.target(ub);
        
        for(Map.Entry<String, List<Object> > entry : request.queryParams().entrySet()) {
            for (Object o : entry.getValue()) {
                target = target.queryParam(entry.getKey(), o);
            }
        }
        
        target.register(new LoggingFilter(Logger.getLogger("os"), 10000));
        Invocation.Builder invocation = target.request();
        
        for(Map.Entry<String, List<Object>> h : request.headers().entrySet()) {
            StringBuilder sb = new StringBuilder();
            for(Object v : h.getValue()) {
                sb.append(String.valueOf(v));
            }
            invocation.header(h.getKey(), sb);
        }
        
        Entity<?> entity = (request.entity() == null) ? null :
                Entity.entity(request.entity().getEntity(), request.entity().getContentType());
        
        try {
            if (entity != null) {
                Response response = invocation.method(request.method().name(), entity);
                if(request.returnType() == Token.class) {
                    return new JaxRs20Response(
                            response,
                            client.getConfiguration()
                            .getProperty("X-Auth-Token")
                            .toString()
                            );
                }
                return new JaxRs20Response(response);
            } else {
                return new JaxRs20Response(invocation.method(request.method().name()));
            }
        } catch (ClientErrorException e) {
            throw new OpenStackResponseException(e.getResponse()
                    .getStatusInfo().toString(), e.getResponse().getStatus());
        }
    }
    
}
