package com.sadasen.tally.modules.bill.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.sadasen.tally.modules.bill.dto.BillParamDto;
import com.sadasen.tally.modules.bill.entity.Bill;

/**
 * @date 2018年9月1日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface BillDao extends BaseMapper<Bill> {
	
	public int selectMaxSortByCondition(@Param("userId") long userId, @Param("type") int type);
	
	public List<Bill> selectListByCondition(BillParamDto billParam);

}
