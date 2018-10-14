package com.sadasen.tally.modules.agroup.service;

import java.util.List;

import com.sadasen.tally.base.BaseService;
import com.sadasen.tally.modules.agroup.entity.PersonalAgroup;

/**
 * @date 2018年10月6日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface PersonalAgroupServie extends BaseService<PersonalAgroup> {
	
	public List<PersonalAgroup> getByBillId(long billId);
	
	public int getMaxSortByBill(long billId);

}
