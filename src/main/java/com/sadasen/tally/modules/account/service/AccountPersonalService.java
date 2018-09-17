package com.sadasen.tally.modules.account.service;

import java.util.List;

import com.sadasen.tally.base.BaseService;
import com.sadasen.tally.modules.account.dto.AccountDto;
import com.sadasen.tally.modules.account.entity.AccountPersonal;

/**
 * @date 2018年9月17日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface AccountPersonalService extends BaseService<AccountPersonal> {
	
	public AccountPersonal save(AccountPersonal account, AccountDto accountDto);
	
	public List<AccountPersonal> getList(long billId);

	public List<AccountPersonal> getListByGroup(long groupId);
	
	public int getMaxSortByBill(long billId);
	
}
