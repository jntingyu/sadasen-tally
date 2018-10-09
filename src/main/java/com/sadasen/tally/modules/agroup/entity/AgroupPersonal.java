package com.sadasen.tally.modules.agroup.entity;

import org.beetl.sql.core.annotatoin.Table;

import com.sadasen.tally.base.BaseEntity;
import com.sadasen.tally.common.Consts;

/**
 * @date 2018年10月6日
 * @author lei.ys
 * @addr company
 * @desc
 */
@Table(name=Consts.Table.T_ACCOUNT_GROUP_PERSONAL)
public class AgroupPersonal extends BaseEntity {

	private static final long serialVersionUID = 4520235137476623422L;
	
	private long id;
	private long billId;
	private String name;
	private int sort;
	
	public AgroupPersonal() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
