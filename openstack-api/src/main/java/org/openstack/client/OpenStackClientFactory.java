package org.openstack.client;

import javax.ws.rs.client.Client;

import org.openstack.api.common.RestClient;
import org.openstack.api.identity.IdentityResource;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;

public class OpenStackClientFactory {
	
	private static Client client = RestClient.INSTANCE.verbose(true).getJerseyClient();

	public static OpenStackClient authenticate(String authURL, String username, String password, String tenantName) {
		KeyStoneAuthentication authentication = new KeyStoneAuthentication().withPasswordCredentials(username, password);
		authentication.setTenantName(tenantName);
		IdentityResource auth = new IdentityResource(client.target(authURL));
		KeyStoneAccess access = auth.tokens().authenticate(authentication);
		OpenStackClient openstack = new OpenStackClient(client, authURL, access);
		return openstack;
	}
	
	public static OpenStackClient authenticate(String authURL, String username, String password) {
		return authenticate(authURL, username, password, null);
		
	}
	
}
