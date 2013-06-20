package com.woorea.openstack.examples.metering.v2;

import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.ceilometer.Ceilometer;
import com.woorea.openstack.ceilometer.QueryFilter;
import com.woorea.openstack.ceilometer.v2.model.Sample;
import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Access access = keystone.tokens()
				.authenticate(new UsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD))
				.withTenantName("admin")
				.execute();
		
		Ceilometer ceilometer = new Ceilometer(ExamplesConfiguration.CEILOMETER_ENDPOINT);
		ceilometer.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));

        ArrayList<QueryFilter> queryParams = new ArrayList<QueryFilter>();
        queryParams.add(new QueryFilter("timestamp", "ge", "2013-06-16T00:00:00"));

        List<Sample> meters = Arrays.asList(ceilometer.meters().list().execute());

        List<Sample> samples = Arrays.asList(ceilometer.samples().list("cpu", queryParams).execute());


        for (Sample s : meters) {
            System.out.println(s);
        }

        for (Sample s : samples) {
            System.out.println(s);
        }

		/*
		List<Resource> resources = ceilometer.execute(new ResourceList().eq("resource_id", "23b55841eedd41e99d5f3f32149ca086"));
		
		
		for(Resource r : resources) {
			Resource resource = ceilometer.execute(new ResourceShow().id(r.getResource()));
		}
		*/
		
		/*
		//List<Meter> meters = ceilometer.meters().list().execute(); //execute(new MeterList().eq("project_id", "948eeb593acd4223ad572c49e1ef5709"));
		
		
		for(Meter m : meters) {
			System.out.println(m);
			
//			List<Sample> samples = ceilometer.execute(new MeterShow().name(m.getName()));
//			for(Sample s : samples) {
//				System.out.println("\t" + s);
//			}
			
			List<Statistics> stats = ceilometer.meters().statistics().execute(); // (new MeterStatistics().name(m.getName()));
			for(Statistics s : stats) {
				System.out.println("\t\t" + s);
			}
			
			
		}
		*/
		
	}

}
