package com.sadasen.tally.modules.user.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.core.common.GlobalConsts;
import com.sadasen.core.response.JsonResult;
import com.sadasen.core.response.status.Status;
import com.sadasen.tally.base.BaseController;
import com.sadasen.tally.modules.user.dto.UserDto;
import com.sadasen.tally.modules.user.entity.User;
import com.sadasen.tally.modules.user.service.UserService;
import com.sadasen.tally.util.Utils;
import com.sadasen.util.DateUtil;

import ch.qos.logback.classic.Logger;

/**
 * @date 2018年8月20日
 * @author lei.ys
 * @addr home
 * @desc
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户注册
	 * @param userDto	dto对象，用户名和密码
	 * @return	Json
	 */
	@PostMapping("/register")
	public JsonResult register(@RequestBody UserDto userDto) {
		// 校验参数
		
		LOG.debug("用户注册 uname : {}", userDto.getUserName());
		// 校验是否已注册
		User exists = userService.getByUserName(userDto.getUserName());
		if(null != exists) {
			LOG.debug("用户名已被注册 uname : {}", userDto.getUserName());
			return JsonResult.instance(Status.REQUEST_VALID, "用户名已被注册！");
		}
		// 设置用户信息
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setNickName(userDto.getUserName());
		user.setPassword(Utils.toPassword(userDto));
		user.setCreateTime(DateUtil.now());
		// 新增用户
		try {
			user = userService.saveUserAndInfo(user);
			LOG.info("用户 {} 注册成功！", user.getUserName());
			return JsonResult.instance("注册成功", user);
		} catch (Exception e) {
			LOG.error("用户注册，系统异常");
			e.printStackTrace();
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
	}
	
	/**
	 * 用户登录
	 * @param userDto	dto对象，用户名和密码
	 * @return	Json
	 */
	@PostMapping("/login")
	public JsonResult login(@RequestBody UserDto userDto) {
		// 校验参数
		
		LOG.debug("用户 uname : {} 请求登录", userDto.getUserName());
		// 查询用户
		User exists = null;
		try {
			exists = userService.getByUserName(userDto.getUserName());
		} catch (Exception e) {
			LOG.error("用户登录，系统异常");
			e.printStackTrace();
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
		if(null == exists) {
			return JsonResult.instance(Status.REQUEST_VALID, "用户未注册！");
		}
		
		if(exists.getPassword().equals(Utils.toPassword(userDto))) {
			LOG.info("用户 uname : {} 登录", userDto.getUserName());
			exists.setLastLoginTime(exists.getLoginTime());
			exists.setLoginTime(DateUtil.now());
			userService.modifyLoginInfo(exists);
			super.getRequest().getSession().setAttribute(GlobalConsts.LOGIN_USER, exists);
			return JsonResult.instance("登录成功", exists);
		} else {
			return JsonResult.instance(Status.REQUEST_VALID, "密码不正确！");
		}
	}
	
	/**
	 * 验证用户名是否已存在
	 * @param userName	用户名
	 * @return	Json
	 */
	@GetMapping("/exists/{userName}")
	public JsonResult validUserName(@PathVariable("userName") String userName) {
		LOG.debug("验证用户名 {} 是否已存在", userName);
		User exists = null;
		try {
			exists = userService.getByUserName(userName);
		} catch (Exception e) {
			LOG.error("验证用户名是否存在，系统异常");
			e.printStackTrace();
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
		if(null == exists) {
			return JsonResult.instance("用户名未被注册", false);
		}
		return JsonResult.instance("用户名已被注册", true);
	}
	
	/**
	 * 用户注销
	 * @return
	 */
	@GetMapping("/logout")
	public JsonResult logout() {
		super.getRequest().getSession().removeAttribute(GlobalConsts.LOGIN_USER);
		return JsonResult.instance("注销成功");
	}

}
