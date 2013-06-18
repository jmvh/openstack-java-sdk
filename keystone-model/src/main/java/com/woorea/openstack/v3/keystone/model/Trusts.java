package com.woorea.openstack.v3.keystone.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Trusts implements Iterable<Trust>, Serializable {

	@JsonProperty("trusts")
	private List<Trust> list;

	/**
	 * @return the list
	 */
	public List<Trust> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trusts [list=" + list + "]";
	}

	@Override
	public Iterator<Trust> iterator() {
		return list.iterator();
	}
	
}
