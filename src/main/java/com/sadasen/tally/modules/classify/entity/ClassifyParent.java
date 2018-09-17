package com.sadasen.tally.modules.classify.entity;

import com.sadasen.tally.base.BaseBean;

/**
 * @date 2018年9月16日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class ClassifyParent extends BaseBean {

	private static final long serialVersionUID = -6005915361957888683L;
	
	private long childId;
	private long parentId;
	private int level;
	
	public ClassifyParent() {
	}

	public long getChildId() {
		return childId;
	}

	public void setChildId(long childId) {
		this.childId = childId;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
