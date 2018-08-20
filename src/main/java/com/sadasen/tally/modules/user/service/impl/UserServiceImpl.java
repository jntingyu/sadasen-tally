package com.sadasen.tally.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadasen.tally.base.AbstractBaseService;
import com.sadasen.tally.modules.user.dao.UserDao;
import com.sadasen.tally.modules.user.entity.User;
import com.sadasen.tally.modules.user.service.UserService;

/**
 * @date 2018年8月21日
 * @author lei.ys
 * @addr home
 * @desc
 */
@Service
public class UserServiceImpl extends AbstractBaseService<User> implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getByUserName(String userName) {
		return userDao.selectByUserName(userName);
	}

}
