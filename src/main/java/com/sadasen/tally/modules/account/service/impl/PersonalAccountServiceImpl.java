package com.sadasen.tally.modules.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadasen.tally.base.AbstractBaseService;
import com.sadasen.tally.modules.account.dao.PersonalAccountDao;
import com.sadasen.tally.modules.account.dto.AccountDto;
import com.sadasen.tally.modules.account.entity.PersonalAccount;
import com.sadasen.tally.modules.account.entity.GroupAccount;
import com.sadasen.tally.modules.account.service.PersonalAccountService;

/**
 * @date 2018年9月17日
 * @author lei.ys
 * @addr home
 * @desc
 */
@Service
public class PersonalAccountServiceImpl extends AbstractBaseService<PersonalAccount> implements PersonalAccountService {

	@Autowired
	private PersonalAccountDao accountDao;
	
	@Override
	public PersonalAccount save(PersonalAccount account, AccountDto accountDto) {
		account = super.save(account);
		
		if(0!=accountDto.getGroupId()) {
			GroupAccount ga = new GroupAccount(accountDto.getGroupId(), account.getId());
			accountDao.insertGroupAccount(ga);
		}
		
		return account;
	}
	
	@Override
	public List<PersonalAccount> getList(long billId) {
		return accountDao.selectListByBill(billId);
	}
	
	@Override
	public List<PersonalAccount> getListByGroup(long groupId) {
		return accountDao.selectListByGroup(groupId);
	}
	
	@Override
	public int getMaxSortByBill(long billId) {
		return accountDao.selectMaxSortByCondition(billId);
	}

}
