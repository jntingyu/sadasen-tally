package com.sadasen.tally.modules.classify.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadasen.tally.base.AbstractBaseService;
import com.sadasen.tally.modules.classify.dao.ClassifyPersonalDao;
import com.sadasen.tally.modules.classify.dao.ClassifyPersonalParentDao;
import com.sadasen.tally.modules.classify.dto.ClassifyParamDto;
import com.sadasen.tally.modules.classify.entity.ClassifyPersonal;
import com.sadasen.tally.modules.classify.entity.ClassifyPersonalParent;
import com.sadasen.tally.modules.classify.service.ClassifyPersonalService;
import com.sadasen.tally.modules.classify.vo.MaxCodeAndSort;
import com.sadasen.util.CollectionUtil;

/**
 * @date 2018年9月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
@Service
public class ClassifyPersonalServiceImpl extends AbstractBaseService<ClassifyPersonal> 
		implements ClassifyPersonalService {
	
	@Autowired
	private ClassifyPersonalDao classifyPersonalDao;
	@Autowired
	private ClassifyPersonalParentDao classifyPersonalParentDao;
	
	@Override
	public ClassifyPersonal save(ClassifyPersonal classify) {
		ClassifyPersonal parent = null;
		ClassifyPersonal lastParent = null;
		if(0!=classify.getParentId()) {
			parent = classifyPersonalDao.single(classify.getParentId());
			if(null!=parent) {
				lastParent = parent;
			}
		}
		
		if(null==parent) {
			classify.setLevel(0);
		} else {
			classify.setLevel(parent.getLevel()+1);
		}
		
		MaxCodeAndSort max = classifyPersonalDao.selectMaxCodeAndSort(classify);
		String pcode = "";
		if(null!=parent) {
			pcode = parent.getCode();
		}
		if(null==max.getMaxCode()) {
			classify.setCode(pcode+"100");
		} else {
			String scode = max.getMaxCode().substring(max.getMaxCode().length()-3);
			int icode = Integer.parseInt(scode);
			if(icode>=100 && icode<999) {
				classify.setCode(pcode+(icode+1));
			} else {
				classify.setId(-999);
				return classify;
			}
		}
		
		classify.setSort(max.getMaxSort()+1);
		classifyPersonalDao.insertTemplate(classify, true);
		
		List<ClassifyPersonalParent> parentList = new ArrayList<>();
		ClassifyPersonalParent classifyParent = null;
		while(null!=parent) {
			classifyParent = new ClassifyPersonalParent();
			classifyParent.setChildId(classify.getId());
			classifyParent.setParentId(parent.getId());
			classifyParent.setLevel(parent.getLevel());
			parentList.add(classifyParent);
			if(0==parent.getParentId()) {
				break;
			}
			parent = classifyPersonalDao.single(parent.getParentId());
		}
		
		if(!CollectionUtil.isEmpty(parentList)) {
			classifyPersonalParentDao.insertBatch(parentList);
		}
		
		if(null!=lastParent && lastParent.getHasChild()==0) {
			classifyPersonalDao.updateHasChild(1, lastParent.getId());
		}
		
		return classify;
	}
	
	@Override
	public List<ClassifyPersonal> getListPage(ClassifyParamDto classifyParam) {
		return classifyPersonalDao.selectListByCondition(classifyParam);
	}

}
