package com.sadasen.tally.modules.classify.entity;

import com.sadasen.tally.base.BaseEntity;

/**
 * @date 2018年8月20日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class Classify extends BaseEntity {

	private static final long serialVersionUID = -3360257251926169410L;
	
	private long id;
	private long parentId;
	private long billId;
	private String name;
	private String code;
	private int level;
	private int sort;
	private int hasChild;
	
	public Classify() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getHasChild() {
		return hasChild;
	}

	public void setHasChild(int hasChild) {
		this.hasChild = hasChild;
	}
	
}
