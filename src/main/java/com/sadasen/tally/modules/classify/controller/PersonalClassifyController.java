package com.sadasen.tally.modules.classify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.core.response.JsonResult;
import com.sadasen.core.response.status.Status;
import com.sadasen.tally.base.BaseController;
import com.sadasen.tally.common.Consts;
import com.sadasen.tally.modules.bill.entity.Bill;
import com.sadasen.tally.modules.bill.service.BillService;
import com.sadasen.tally.modules.classify.dto.ClassifyDto;
import com.sadasen.tally.modules.classify.dto.ClassifyParamDto;
import com.sadasen.tally.modules.classify.entity.PersonalClassify;
import com.sadasen.tally.modules.classify.service.PersonalClassifyService;
import com.sadasen.util.DateUtil;

/**
 * @date 2018年9月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
@RestController
@RequestMapping("/personal/classify")
public class PersonalClassifyController extends BaseController {
	
	@Autowired
	private BillService billService;
	@Autowired
	private PersonalClassifyService classifyPersonalService;
	
	@PostMapping
	public JsonResult add(@RequestBody ClassifyDto classifyDto) {
		// 参数校验
		Bill bill = billService.findById(classifyDto.getBillId());
		if(null==bill) {
			return JsonResult.instance(Status.REQUEST_NOT_EXISTS, "记账单不存在！");
		}
		if(super.currentUserId()!=bill.getUserId()) {
			return JsonResult.instance(Status.REQUEST_PERMISSION);
		}
		if(bill.getType()!=Consts.BillType.PERSONAL) {
			return JsonResult.instance(Status.REQUEST_VALID);
		}
		// 设置属性
		PersonalClassify classify = new PersonalClassify();
		classify.setBillId(classifyDto.getBillId());
		classify.setParentId(classifyDto.getParentId());
		classify.setName(classifyDto.getName());
		classify.setCreateTime(DateUtil.now());
		
		classify = classifyPersonalService.save(classify);
		
		return JsonResult.instance(classify);
	}
	
	@GetMapping("/{billId}/{parentId}/page/{page}/pagesize/{pagesize}")
	public JsonResult getByParent(@PathVariable("billId") long billId, @PathVariable("parentId") long parentId,
			@PathVariable("page") int page, @PathVariable("pagesize") int pagesize) {
		// 参数验证
		Bill bill = billService.findById(billId);
		if(null==bill) {
			return JsonResult.instance(Status.REQUEST_NOT_EXISTS);
		}
		if(bill.getUserId()!=super.currentUserId()) {
			return JsonResult.instance(Status.REQUEST_PERMISSION);
		}
		
		// 参数
		ClassifyParamDto param = new ClassifyParamDto();
		param.setBillId(billId);
		param.setParentId(parentId);
		param.setPage(page);
		param.setPagesize(pagesize);
		
		List<PersonalClassify> classifyList = classifyPersonalService.getListPage(param);
		
		return JsonResult.instance(classifyList);
	}

}
