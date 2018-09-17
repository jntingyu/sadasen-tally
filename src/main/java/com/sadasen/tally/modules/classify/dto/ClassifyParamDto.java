package com.sadasen.tally.modules.classify.dto;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年9月16日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class ClassifyParamDto extends BaseBean {

	private static final long serialVersionUID = 5968255081187183874L;
	
	private long billId;
	private long parentId;
	private int page;
	private int pagesize;
	private int start;
	
	public ClassifyParamDto() {
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
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
		start = (page-1)*pagesize;
		return start;
	}
	
}
