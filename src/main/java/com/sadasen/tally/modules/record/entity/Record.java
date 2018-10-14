package com.sadasen.tally.modules.record.entity;

import java.util.Date;

import com.sadasen.tally.base.BaseEntity;

/**
 * @date 2018年10月9日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class Record extends BaseEntity {
	
	private static final long serialVersionUID = -6505993810608881434L;
	
	private long id;
	private long billId;
	private Date recordDate;
	private long classifyId;
	private int amount;
	private long groupId;
	private long accountId;
	private String remark;
	private Date updateTime;
	
	public Record() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public long getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(long classifyId) {
		this.classifyId = classifyId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
