package com.woorea.openstack.v3.keystone.model.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class TrustDateDeserializer extends JsonDeserializer<Calendar>  {

	@Override
	public Calendar deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
		String date = arg0.getText();
		Calendar ret = Calendar.getInstance();
		try {
			ret.setTime(formatter.parse(date));
			return ret;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
