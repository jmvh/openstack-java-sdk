package com.woorea.openstack.v3.keystone.model.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class TrustDateSerializer extends JsonSerializer<Calendar>  {

	public TrustDateSerializer() {
		super();
	}

	@Override
	public void serialize(Calendar arg0, JsonGenerator arg1,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
		//try {
		String format = formatter.format(arg0.getTime());
		arg1.writeString(format);
		//} catch(IllegalArgumentException e) { throw new IllegalArgumentException(arg0.toString(),); }
	}

}

