package com.sadasen.tally.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sadasen.core.common.GlobalConsts;
import com.sadasen.tally.modules.user.entity.User;

/**
 * @date 2018年8月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class BaseController {
	
	public HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
		return attrs.getRequest();
	}
	
	public User currentUser() {
		boolean TEST = true;
		if(TEST) {
			User user = new User();
			user.setId(1L);
			user.setUserName("test");
			return user;
		}
		return (User) this.getRequest().getSession().getAttribute(GlobalConsts.LOGIN_USER);
	}
	
	public long currentUserId() {
		return this.currentUser().getId();
	}

}
