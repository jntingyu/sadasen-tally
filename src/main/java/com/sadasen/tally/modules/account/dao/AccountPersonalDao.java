package com.sadasen.tally.modules.account.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.sadasen.tally.modules.account.entity.AccountPersonal;
import com.sadasen.tally.modules.account.entity.GroupAccount;

/**
 * @date 2018年9月17日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface AccountPersonalDao extends BaseMapper<AccountPersonal> {
	
	public void insertGroupAccount(GroupAccount groupAccount);
	
	public List<AccountPersonal> selectListByBill(@Param("billId") long billId);
	
	public List<AccountPersonal> selectListByGroup(@Param("groupId") long groupId);
	
	public int selectMaxSortByCondition(@Param("billId") long billId);

}