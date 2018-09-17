package com.sadasen.tally.modules.account.entity;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年9月17日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class GroupAccount extends BaseBean {

	private static final long serialVersionUID = 7575502273766016425L;
	
	private long groupId;
	private long accountId;
	
	public GroupAccount() {
	}

	public GroupAccount(long groupId, long accountId) {
		super();
		this.groupId = groupId;
		this.accountId = accountId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
}
