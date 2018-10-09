package com.sadasen.tally.modules.agroup.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.core.response.JsonResult;
import com.sadasen.core.response.status.Status;
import com.sadasen.tally.base.BaseController;
import com.sadasen.tally.modules.agroup.dto.AgroupDto;
import com.sadasen.tally.modules.agroup.entity.AgroupPersonal;
import com.sadasen.tally.modules.agroup.service.AgroupPersonalServie;
import com.sadasen.util.DateUtil;

/**
 * @date 2018年10月6日
 * @author lei.ys
 * @addr company
 * @desc
 */
@RestController
@RequestMapping("/agroup/personal")
public class AgroupPersonalController extends BaseController {
	
	private AgroupPersonalServie agroupPersonalServie;
	
	@PostMapping
	public JsonResult add(@RequestBody AgroupDto agroupDto) {
		// 参数检验
		
		// 实体类参数值
		AgroupPersonal agroupPersonal = new AgroupPersonal();
		agroupPersonal.setBillId(agroupDto.getBillId());
		agroupPersonal.setName(agroupDto.getName());
		agroupPersonal.setCreateTime(DateUtil.now());
		try {
			agroupPersonal.setSort(agroupPersonalServie.getMaxSortByBill(agroupDto.getBillId()));
			agroupPersonal = agroupPersonalServie.save(agroupPersonal);
			return JsonResult.instance(agroupPersonal);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
	}

}
