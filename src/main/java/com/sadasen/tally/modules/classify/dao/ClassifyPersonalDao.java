package com.sadasen.tally.modules.classify.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.sadasen.tally.modules.classify.dto.ClassifyParamDto;
import com.sadasen.tally.modules.classify.entity.ClassifyPersonal;
import com.sadasen.tally.modules.classify.vo.MaxCodeAndSort;

/**
 * @date 2018年8月20日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface ClassifyPersonalDao extends BaseMapper<ClassifyPersonal> {
	
	public int updateHasChild(@Param("hasChild") int hasChild, @Param("id") long id);
	
	public List<ClassifyPersonal> selectListByCondition(ClassifyParamDto classifyParam);
	
	public MaxCodeAndSort selectMaxCodeAndSort(ClassifyPersonal classifyPersonal);
	
}
