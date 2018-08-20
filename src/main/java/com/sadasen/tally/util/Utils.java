package com.sadasen.tally.util;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @date 2018年8月18日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class Utils {
	
	private Utils() {
	}
	
	public static String toJson(Object obj) {
		try {
			return JsonUtil.objectToJson(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
