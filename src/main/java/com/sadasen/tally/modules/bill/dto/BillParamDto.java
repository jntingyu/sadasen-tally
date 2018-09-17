package com.sadasen.tally.modules.bill.dto;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年9月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class BillParamDto extends BaseBean {

	private static final long serialVersionUID = 827971515812061563L;
	
	private long userId;
	private int type;
	private int page;
	private int pagesize;
	private int start;
	
	public BillParamDto() {
	}
	
	public BillParamDto(int type, int page, int pagesize) {
		super();
		this.type = type;
		this.page = page;
		this.pagesize = pagesize;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getStart() {
		this.start = (this.page-1) * pagesize;
		return start;
	}

}
