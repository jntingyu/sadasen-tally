package com.sadasen.tally.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.sadasen.tally.ext.ObjectMapperExt;

/**
 * @date 2018年8月18日
 * @author lei.ys
 * @addr home
 * @desc Jackson json与对象转换工具类
 */
public class JsonUtil {
	
	private JsonUtil() {
	}
	
	/**
	 * 对象转换成json
	 * @param obj
	 * @return
	 * @throws JsonProcessingException 
	 */
	public static String objectToJson(Object obj) throws JsonProcessingException {
		String result = null;
		ObjectMapperExt mapper = new ObjectMapperExt();
		result = mapper.writeValueAsString(obj);
		return result;
	}
	
	/**
	 * 对象转换成json，为null属性不参与序列化
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String objectToJsonWithoutNull(Object obj) throws JsonProcessingException {
		String result = null;
		ObjectMapperExt mapper = new ObjectMapperExt();
		mapper.setSerializationInclusion(Include.NON_NULL);
		result = mapper.writeValueAsString(obj);
		return result;
	}
	
	/**
	 * 对象转换成json，为空（null和""）属性不参与序列化
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String objectToJsonWithoutEmpty(Object obj) throws JsonProcessingException {
		String result = null;
		ObjectMapperExt mapper = new ObjectMapperExt();
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		result = mapper.writeValueAsString(obj);
		return result;
	}
	
	public static <T> T jsonToObject(String json, Class<T> clz) throws Exception {
		ObjectMapperExt mapper = new ObjectMapperExt();
		T t = mapper.readValue(json, clz);
		return t;
	}
	
	public static <T> List<T> jsonToList(String json, Class<T> clz) throws Exception {
		ObjectMapperExt mapper = new ObjectMapperExt();
		JavaType type = mapper.getTypeFactory().constructParametricType(List.class, clz);
		List<T> t = mapper.readValue(json, type);
		return t;
	}

}
