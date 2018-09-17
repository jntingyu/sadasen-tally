package com.sadasen.tally.modules.bill.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
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
import com.sadasen.tally.modules.bill.dto.BillDto;
import com.sadasen.tally.modules.bill.dto.BillParamDto;
import com.sadasen.tally.modules.bill.entity.Bill;
import com.sadasen.tally.modules.bill.service.BillService;
import com.sadasen.tally.modules.user.entity.User;
import com.sadasen.util.DateUtil;

import ch.qos.logback.classic.Logger;

/**
 * @date 2018年9月1日
 * @author lei.ys
 * @addr home
 * @desc
 */
@RestController
@RequestMapping("/bill")
public class BillController extends BaseController {
	
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(BillController.class);
	
	@Autowired
	private BillService billService;
	
	@PostMapping
	public JsonResult add(@RequestBody BillDto billDto) {
		// 参数校验
		
		// 设置账单信息
		User user = super.currentUser();
		Bill bill = new Bill(billDto);
		bill.setUserId(user.getId());
		bill.setCreateTime(DateUtil.now());
		try {
			int sort = billService.maxSort(bill.getUserId(), billDto.getType());
			bill.setSort(sort+1);
			bill = billService.save(bill);
			LOG.info("用户 uname : {} 新增记账单 ： {}", user.getUserName(), bill.getName());
			return JsonResult.instance(bill);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
	}
	
	@GetMapping(value="/list/{type}/page/{page}/pagesize/{pagesize}")
	public JsonResult list(@PathVariable("type") int type, @PathVariable("page") int page, @PathVariable("pagesize") int pagesize) {
		// 查询参数
		BillParamDto billParam = new BillParamDto(type, page, pagesize);
		billParam.setUserId(super.currentUserId());
		List<Bill> data = billService.getListPage(billParam);
		return JsonResult.instance(data);
	}

}
