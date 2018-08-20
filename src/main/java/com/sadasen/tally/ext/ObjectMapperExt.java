package com.sadasen.tally.ext;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @date 2018年8月18日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class ObjectMapperExt extends ObjectMapper {

	private static final long serialVersionUID = 8108498710213869606L;
	
	public ObjectMapperExt() {
		super();
		configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		SimpleModule module = new SimpleModule("LongModule");
		module.addSerializer(Long.class, ToStringSerializer.instance);
		module.addSerializer(Long.TYPE, ToStringSerializer.instance);
		registerModule(module);
	}

}
