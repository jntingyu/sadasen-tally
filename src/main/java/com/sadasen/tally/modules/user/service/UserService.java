package com.sadasen.tally.modules.user.service;

import com.sadasen.tally.base.BaseService;
import com.sadasen.tally.modules.user.entity.User;

/**
 * @date 2018年8月21日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface UserService extends BaseService<User> {
	
	/**
	 * 根据用户名查询用户信息
	 * @param userName	用户名
	 * @return	User
	 */
	public User getByUserName(String userName);

}
