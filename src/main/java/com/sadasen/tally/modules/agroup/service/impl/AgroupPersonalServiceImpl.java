package com.sadasen.tally.modules.agroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadasen.tally.base.AbstractBaseService;
import com.sadasen.tally.modules.agroup.dao.AgroupPersonalDao;
import com.sadasen.tally.modules.agroup.entity.AgroupPersonal;
import com.sadasen.tally.modules.agroup.service.AgroupPersonalServie;

/**
 * @date 2018年10月6日
 * @author lei.ys
 * @addr company
 * @desc
 */
@Service
public class AgroupPersonalServiceImpl extends AbstractBaseService<AgroupPersonal> implements AgroupPersonalServie {
	
	@Autowired
	private AgroupPersonalDao agroupPersonalDao;
	
	@Override
	public List<AgroupPersonal> getByBillId(long billId) {
		return agroupPersonalDao.selectListByBill(billId);
	}
	
	public int getMaxSortByBill(long billId) {
		return agroupPersonalDao.selectMaxSortByCondition(billId);
	}

}
