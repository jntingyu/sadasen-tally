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
		public static final String T_CLASSIFY_PERSONAL = "t_classify_personal";
		// 个人账单分类层级
		public static final String T_CLASSIFY_PERSONAL_PARENT = "t_classify_personal_parent";
		// 个人账单帐户
		public static final String T_ACCOUNT_PERSONAL = "t_account_personal";
		// 个人账单帐户组
		public static final String T_ACCOUNT_GROUP_PERSONAL = "t_account_group_personal";
		
	}
	
	public static class BillType {
		
		public static final int PERSONAL = 1;
		
	}
	
}
