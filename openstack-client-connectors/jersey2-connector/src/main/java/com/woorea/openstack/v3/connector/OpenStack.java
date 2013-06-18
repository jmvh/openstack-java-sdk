package com.woorea.openstack.v3.connector;

import java.io.IOException;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.ContextResolver;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.jackson.JacksonFeature;

public class OpenStack {

	public static Client CLIENT;

	public static ObjectMapper DEFAULT_MAPPER;

	public static ObjectMapper WRAPPED_MAPPER;

	static {
		initialize();
	}

	private static void initialize() {

		try {

			SSLContext context = null;
			context = SSLContext.getInstance("SSL");
			context.init(null, null, null);

			SslConfigurator sslConfig = SslConfigurator.newInstance();

			CLIENT = ClientBuilder.newBuilder().sslContext(sslConfig.createSSLContext()).build();

			DEFAULT_MAPPER = new ObjectMapper();

			DEFAULT_MAPPER.setSerializationInclusion(Inclusion.NON_NULL);
			DEFAULT_MAPPER.enable(SerializationConfig.Feature.INDENT_OUTPUT);
			DEFAULT_MAPPER.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

			WRAPPED_MAPPER = new ObjectMapper();

			WRAPPED_MAPPER.setSerializationInclusion(Inclusion.NON_NULL);
			WRAPPED_MAPPER.enable(SerializationConfig.Feature.INDENT_OUTPUT);
			WRAPPED_MAPPER.enable(SerializationConfig.Feature.WRAP_ROOT_VALUE);
			WRAPPED_MAPPER.enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);
			WRAPPED_MAPPER.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
                        WRAPPED_MAPPER.disable(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS);

			CLIENT.register(new JacksonFeature()).register(new ContextResolver<ObjectMapper>() {

				public ObjectMapper getContext(Class<?> type) {
					return type.getAnnotation(JsonRootName.class) == null ? DEFAULT_MAPPER : WRAPPED_MAPPER;
				}

			});

			CLIENT.register(new ClientRequestFilter() {

				public void filter(ClientRequestContext requestContext) throws IOException {
					requestContext.getHeaders().remove("Content-Language");
					requestContext.getHeaders().remove("Content-Encoding");
				}
			});

			CLIENT.register(new ClientResponseFilter(){

				@Override
				public void filter(ClientRequestContext reqContext,
						ClientResponseContext respContext) throws IOException {
					if(respContext.getHeaderString("X-Subject-Token") != null) {
						CLIENT.property("X-Auth-Token",respContext.getHeaderString("X-Subject-Token"));
					}
				}
					
			});

		} catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

}
