package com.sadasen.tally.base;

import java.io.Serializable;

/**
 * @date 2018年8月18日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface BaseService<T> {
	
	public T save(T t);
	
	public T save(T t, boolean flag);
	
	public T findById(Serializable id);
	
}
