package com.sadasen.tally.modules.account.service;

import java.util.List;

import com.sadasen.tally.base.BaseService;
import com.sadasen.tally.modules.account.dto.AccountDto;
import com.sadasen.tally.modules.account.entity.PersonalAccount;

/**
 * @date 2018年9月17日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface PersonalAccountService extends BaseService<PersonalAccount> {
	
	public PersonalAccount save(PersonalAccount account, AccountDto accountDto);
	
	public List<PersonalAccount> getList(long billId);

	public List<PersonalAccount> getListByGroup(long groupId);
	
	public int getMaxSortByBill(long billId);
	
}
