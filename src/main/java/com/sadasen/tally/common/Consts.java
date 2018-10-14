package com.sadasen.tally.common;

/**
 * @date 2018年8月19日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class Consts {
	
	public static class Table {
		// 系统用户表
		public static final String T_USER = "sys_user";
		// 记账单表
		public static final String T_BILL = "t_bill";
		// 个人账单分类
		public static final String T_PERSONAL_CLASSIFY = "t_personal_classify";
		// 个人账单分类层级
		public static final String T_PERSONAL_CLASSIFY_PARENT = "t_personal_classify_parent";
		// 个人账单帐户
		public static final String T_PERSONAL_ACCOUNT = "t_personal_account";
		// 个人账单帐户组
		public static final String T_PERSONAL_AGROUP = "t_personal_agroup";
		
	}
	
	public static class BillType {
		
		public static final int PERSONAL = 1;
		
	}
	
}
