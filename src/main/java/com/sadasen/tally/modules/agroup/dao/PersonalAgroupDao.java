package com.sadasen.tally.modules.agroup.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.sadasen.tally.modules.agroup.entity.PersonalAgroup;

/**
 * @date 2018年10月6日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface PersonalAgroupDao extends BaseMapper<PersonalAgroup> {

	public List<PersonalAgroup> selectListByBill(@Param("billId") long billId);
	
	public int selectMaxSortByCondition(@Param("billId") long billId);
	
}
