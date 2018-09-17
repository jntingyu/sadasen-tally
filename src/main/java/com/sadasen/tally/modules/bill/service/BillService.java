package com.sadasen.tally.modules.bill.service;

import java.util.List;

import com.sadasen.tally.base.BaseService;
import com.sadasen.tally.modules.bill.dto.BillParamDto;
import com.sadasen.tally.modules.bill.entity.Bill;

/**
 * @date 2018年9月1日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface BillService extends BaseService<Bill> {
	
	/**
	 * 获取排序
	 * @param billDto
	 * @return
	 */
	public int maxSort(long userId, int type);
	
	public List<Bill> getListPage(BillParamDto billParam);

}
