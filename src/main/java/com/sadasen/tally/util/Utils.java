package com.sadasen.tally.util;

import java.security.MessageDigest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sadasen.tally.modules.user.dto.UserDto;
import com.sadasen.util.StringUtil;

/**
 * @date 2018年8月18日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class Utils {
	
	private static final String salt = "lys_zml";
	
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
	
	public static String MD5(String s) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        s += salt;
	        byte[] bytes = md.digest(s.getBytes("utf-8"));
	        return toHex(bytes);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	private static String toHex(byte[] bytes) {

	    final char[] hexChars = "0123456789ABCDEF".toCharArray();
	    StringBuilder ret = new StringBuilder(bytes.length * 2);
	    for (int i=0; i<bytes.length; i++) {
	        ret.append(hexChars[(bytes[i] >> 4) & 0x0f]);
	        ret.append(hexChars[bytes[i] & 0x0f]);
	    }
	    return ret.toString();
	}
	
	public static String toPassword(UserDto userDto) {
		return MD5(StringUtil.concat("_", userDto.getUserName(), userDto.getPassword()));
	}
	
}
