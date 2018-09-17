package com.sadasen.tally.modules.bill.dto;

import java.util.Date;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年9月1日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class BillDto extends BaseBean {

	private static final long serialVersionUID = 6854964348999212238L;
	
	private long parentId;
	private String name;
	private Date startDate;
	private Date endDate;
	private int type;
	private String remark;
	
	public BillDto() {
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
