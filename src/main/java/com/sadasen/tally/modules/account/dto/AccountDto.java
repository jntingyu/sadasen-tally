package com.sadasen.tally.modules.account.dto;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年9月17日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class AccountDto extends BaseBean {
	
	private static final long serialVersionUID = 4620038145238736712L;
	
	private long billId;
	private long groupId;
	private String name;
	
	public AccountDto() {
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
