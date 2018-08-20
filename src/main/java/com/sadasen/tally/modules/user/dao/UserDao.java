package com.sadasen.tally.modules.user.dao;

import org.beetl.sql.core.mapper.BaseMapper;

import com.sadasen.tally.modules.user.entity.User;

/**
 * @date 2018年8月20日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface UserDao extends BaseMapper<User> {
	
	public User selectByUserName(String userName);

}
