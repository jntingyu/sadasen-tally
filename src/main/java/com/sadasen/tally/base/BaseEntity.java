package com.sadasen.tally.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @date 2018年8月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class BaseEntity extends BaseBean {

	private static final long serialVersionUID = 6095563695881712741L;
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
