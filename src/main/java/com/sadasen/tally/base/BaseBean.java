package com.sadasen.tally.base;

import java.io.Serializable;

import com.sadasen.tally.util.Utils;

/**
 * @date 2018年8月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
public abstract class BaseBean implements Serializable {

	private static final long serialVersionUID = 1769744725868388388L;
	
	@Override
	public String toString() {
		return Utils.toJson(this);
	}

}
