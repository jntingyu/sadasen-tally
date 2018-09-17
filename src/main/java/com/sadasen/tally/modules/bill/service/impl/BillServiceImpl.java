package com.sadasen.tally.modules.bill.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadasen.tally.base.AbstractBaseService;
import com.sadasen.tally.modules.bill.dao.BillDao;
import com.sadasen.tally.modules.bill.dto.BillParamDto;
import com.sadasen.tally.modules.bill.entity.Bill;
import com.sadasen.tally.modules.bill.service.BillService;

/**
 * @date 2018年9月1日
 * @author lei.ys
 * @addr home
 * @desc
 */
@Service
public class BillServiceImpl extends AbstractBaseService<Bill> implements BillService {
	
	@Autowired
	private BillDao billDao;

	@Override
	public int maxSort(long userId, int type) {
		return billDao.selectMaxSortByCondition(userId, type);
	}

	@Override
	public List<Bill> getListPage(BillParamDto billParam) {
		return billDao.selectListByCondition(billParam);
	}

}
