package com.sadasen.tally.modules.agroup.dto;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年10月6日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class AgroupDto extends BaseBean {

	private static final long serialVersionUID = -8489173315441355994L;
	
	private long billId;
	private String name;
	
	public AgroupDto() {
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
