package com.sadasen.tally.modules.bill.entity;

import java.util.Date;

import org.beetl.sql.core.annotatoin.Table;

import com.sadasen.tally.base.BaseEntity;
import com.sadasen.tally.common.Consts;
import com.sadasen.tally.modules.bill.dto.BillDto;

/**
 * @date 2018年9月1日
 * @author lei.ys
 * @addr home
 * @desc
 */
@Table(name=Consts.Table.T_BILL)
public class Bill extends BaseEntity {

	private static final long serialVersionUID = 4372817419934622040L;
	
	private long id;
	private long userId;
	private String name;
	private Date startDate;
	private Date endDate;
	private int type;
	private int sort;
	private String remark;
	
	public Bill() {
	}
	
	public Bill(BillDto billDto) {
		this.name = billDto.getName();
		this.startDate = billDto.getStartDate();
		this.endDate = billDto.getEndDate();
		this.type = billDto.getType();
		this.remark = billDto.getRemark();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
