package com.sadasen.tally.modules.account.entity;

import com.sadasen.tally.base.BaseEntity;
import com.sadasen.tally.modules.account.dto.AccountDto;

/**
 * @date 2018年9月17日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class Account extends BaseEntity {

	private static final long serialVersionUID = 4630536556590194430L;
	
	private long id;
	private long billId;
	private int sort;
	private String name;
	
	public Account() {
	}
	
	public Account(AccountDto accountDto) {
		this.billId = accountDto.getBillId();
		this.name = accountDto.getName();
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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
