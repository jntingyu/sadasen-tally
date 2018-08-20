package com.sadasen.tally.modules.user.dto;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年8月20日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class UserDto extends BaseBean {

	private static final long serialVersionUID = -6408475504371612667L;
	
	private String userName;
	private String password;
	
	public UserDto() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
