package com.sadasen.tally.base;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @date 2018年8月18日
 * @author lei.ys
 * @param <T>
 * @addr home
 * @desc
 */
public abstract class AbstractBaseService<T> implements BaseService<T> {
	
	@Autowired
	private SQLManager sqlManager;
	
	@Override
	public T save(T t) {
		return save(t, true);
	}
	
	@Override
	public T save(T t, boolean flag) {
		sqlManager.insertTemplate(t, flag);
		return t;
	}

}
