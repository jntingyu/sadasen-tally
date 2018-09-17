package com.sadasen.tally.modules.classify.dto;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年9月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class ClassifyDto extends BaseBean {
	
	private static final long serialVersionUID = 488499890532796935L;
	
	private long parentId;
	private long billId;
	private String name;
	
	public ClassifyDto() {
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
