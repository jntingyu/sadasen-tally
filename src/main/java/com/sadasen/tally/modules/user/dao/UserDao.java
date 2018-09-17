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
	
	/**
	 * 新增用户信息
	 * 使用场景
	 *     1. 用户注册时，保存一份用户其它信息
	 * @param userInfo
	 * @return
	 */
	public int insertUserInfo(UserInfo userInfo);
	
	/**
	 * 修改用户登录信息
	 * 使用场景
	 *     1. 用户登录时，修改登录时间
	 * @param user
	 * @return
	 */
	public int updateLoginInfo(User user);
	
	/**
	 * 根据用户名查询用户信息
	 * 使用场景
	 *     1. 用户登录时，根据用户输入的用户名查询出用户信息
	 * @param userName
	 * @return
	 */
	public User selectByUserName(@Param("userName") String userName);

}
