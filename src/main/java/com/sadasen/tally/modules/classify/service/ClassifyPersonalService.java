package com.sadasen.tally.modules.classify.service;

import java.util.List;

import com.sadasen.tally.base.BaseService;
import com.sadasen.tally.modules.classify.dto.ClassifyParamDto;
import com.sadasen.tally.modules.classify.entity.ClassifyPersonal;

/**
 * @date 2018年9月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface ClassifyPersonalService extends BaseService<ClassifyPersonal> {
	
	public List<ClassifyPersonal> getListPage(ClassifyParamDto classifyParam);

}
