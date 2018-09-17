package com.sadasen.tally.test;

/**
 * @date 2018年9月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class TestCode {
	
	public static void main(String[] args) {
		String lastCode = "101103";
		String code = lastCode.substring(lastCode.length()-3);
		System.out.println(code);
		String startCode = lastCode.substring(0, 3);
		System.out.println(startCode);
	}

}
