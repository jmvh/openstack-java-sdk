package com.woorea.openstack.v3.keystone.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.v3.base.client.OpenStackClient;
import com.woorea.openstack.v3.base.client.OpenStackRequest;
import com.woorea.openstack.v3.keystone.model.Trust;
import com.woorea.openstack.v3.keystone.model.Trusts;

public class TrustsResource {

	private OpenStackClient client;

	public TrustsResource(OpenStackClient client) {
		this.client = client;
	}

	public List list() {
		return new List();
	}

	public Create create(Trust trust) {
		return new Create(trust);
	}

	public Show show(String id) {
		return new Show(id);
	}


	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Trusts> {

		public List() {
			super(client, HttpMethod.GET, "/OS-TRUST/trusts", null, Trusts.class);
		}

		private List(String path) {
			super(client, HttpMethod.GET, path, null, Trusts.class);
		}

		public List byTrustor(String trustorId) {
			List ret = new List(new StringBuilder("/OS-TRUST/trusts").toString());
                        ret.queryParam("trustor_user_id", trustorId);
			return ret;
		}


		public List byTrustee(String trusteeId) {
			List ret = new List(new StringBuilder("/OS-TRUST/trusts").toString());
			ret.queryParam("trustee_user_id", trusteeId);
			return ret;
		}


	}

	public class Create extends OpenStackRequest<Trust> {

		private Trust trust;

		public Create(Trust trust) {
			super(client, HttpMethod.POST, "/OS-TRUST/trusts", Entity.json(trust), Trust.class);
			this.trust = trust;
		}

	}

	public class Show extends OpenStackRequest<Trust> {

		public Show(String id) {
			super(client, HttpMethod.GET, new StringBuilder("/OS-TRUST/trusts/").append(id).toString(), null, Trust.class);
		}

	}

	public class Delete extends OpenStackRequest<Void> {

		public Delete(String id) {
			super(client, HttpMethod.DELETE, new StringBuilder("/OS-TRUST/trusts/").append(id).toString(), null, Void.class);
		}

	}

}
