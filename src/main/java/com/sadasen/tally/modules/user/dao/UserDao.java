package com.sadasen.tally.modules.user.dao;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.sadasen.tally.modules.user.entity.User;
import com.sadasen.tally.modules.user.entity.UserInfo;

/**
 * @date 2018年8月20日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface UserDao extends BaseMapper<User> {
	
	public int insertUserInfo(UserInfo userInfo);
	
	public int updateLoginInfo(User user);
	
	public User selectByUserName(@Param("userName") String userName);

}
