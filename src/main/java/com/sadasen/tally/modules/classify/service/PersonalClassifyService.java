package com.sadasen.tally.modules.classify.service;

import java.util.List;

import com.sadasen.tally.base.BaseService;
import com.sadasen.tally.modules.classify.dto.ClassifyParamDto;
import com.sadasen.tally.modules.classify.entity.PersonalClassify;

/**
 * @date 2018年9月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
public interface PersonalClassifyService extends BaseService<PersonalClassify> {
	
	public List<PersonalClassify> getListPage(ClassifyParamDto classifyParam);

}
