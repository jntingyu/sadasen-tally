package com.sadasen.tally.modules.agroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadasen.tally.base.AbstractBaseService;
import com.sadasen.tally.modules.agroup.dao.PersonalAgroupDao;
import com.sadasen.tally.modules.agroup.entity.PersonalAgroup;
import com.sadasen.tally.modules.agroup.service.PersonalAgroupServie;

/**
 * @date 2018年10月6日
 * @author lei.ys
 * @addr company
 * @desc
 */
@Service
public class PersonalAgroupServiceImpl extends AbstractBaseService<PersonalAgroup> implements PersonalAgroupServie {
	
	@Autowired
	private PersonalAgroupDao agroupPersonalDao;
	
	@Override
	public List<PersonalAgroup> getByBillId(long billId) {
		return agroupPersonalDao.selectListByBill(billId);
	}
	
	public int getMaxSortByBill(long billId) {
		return agroupPersonalDao.selectMaxSortByCondition(billId);
	}

}
