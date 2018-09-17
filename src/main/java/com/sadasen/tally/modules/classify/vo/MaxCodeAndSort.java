package com.sadasen.tally.modules.classify.vo;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年9月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class MaxCodeAndSort extends BaseBean {
	
	private static final long serialVersionUID = 5777845327221686304L;
	
	private String maxCode;
	private int maxSort;
	
	public MaxCodeAndSort() {
	}

	public String getMaxCode() {
		return maxCode;
	}

	public void setMaxCode(String maxCode) {
		this.maxCode = maxCode;
	}

	public int getMaxSort() {
		return maxSort;
	}

	public void setMaxSort(int maxSort) {
		this.maxSort = maxSort;
	}

}
