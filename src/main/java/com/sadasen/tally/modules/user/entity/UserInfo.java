package com.sadasen.tally.modules.user.entity;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年8月21日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class UserInfo extends BaseBean {
	
	private static final long serialVersionUID = 4107242781166426170L;
	
	private long userId;
	private String realName;
	private String idCard;
	private String email;
	private long phoneNum;
	
	public UserInfo() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

}
