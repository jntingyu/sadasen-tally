package com.sadasen.tally.modules.user.entity;

import java.util.Date;

import org.beetl.sql.core.annotatoin.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sadasen.tally.base.BaseEntity;
import com.sadasen.tally.common.Consts;

/**
 * @date 2018年8月20日
 * @author lei.ys
 * @addr home
 * @desc
 */
@Table(name=Consts.Table.T_USER)
public class User extends BaseEntity {

	private static final long serialVersionUID = 5707121567550999141L;
	
	// ID
	private long id;
	// 用户名
	private String userName;
	// 密码
	@JsonIgnore
	private String password;
	// 昵称
	private String nickName;
	// 签名
	private String sign;
	// 头像
	private String profilePhoto;
	// 登录时间
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date loginTime;
	// 上次登录时间
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastLoginTime;
	
	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
