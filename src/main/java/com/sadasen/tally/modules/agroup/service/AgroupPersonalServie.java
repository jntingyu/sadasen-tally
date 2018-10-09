package com.sadasen.tally.modules.agroup.service;

import com.sadasen.tally.base.BaseService;
import com.sadasen.tally.modules.agroup.entity.AgroupPersonal;

/**
 * @date 2018年10月6日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface AgroupPersonalServie extends BaseService<AgroupPersonal> {
	
	public int getMaxSortByBill(long billId);

}
