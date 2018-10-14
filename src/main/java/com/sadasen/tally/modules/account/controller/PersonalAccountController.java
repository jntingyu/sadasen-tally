package com.sadasen.tally.modules.account.controller;

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
import com.sadasen.tally.modules.account.dto.AccountDto;
import com.sadasen.tally.modules.account.entity.PersonalAccount;
import com.sadasen.tally.modules.account.service.PersonalAccountService;
import com.sadasen.util.DateUtil;

/**
 * @date 2018年9月17日
 * @author lei.ys
 * @addr home
 * @desc
 */
@RestController
@RequestMapping("/personal/account")
public class PersonalAccountController extends BaseController {
	
	@Autowired
	private PersonalAccountService accountService;
	
	@PostMapping
	public JsonResult add(@RequestBody AccountDto accountDto) {
		// 参数校验
		
		// 实体类参数值
		PersonalAccount account = new PersonalAccount();
		account.setBillId(accountDto.getBillId());
		account.setName(accountDto.getName());
		account.setCreateTime(DateUtil.now());
		try {
			account.setSort(accountService.getMaxSortByBill(account.getBillId())+1);
			account = accountService.save(account);
			return JsonResult.instance(account);
		} catch (Exception e) {
			e.printStackTrace();
			
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
	}
	
	@GetMapping("/bill/{billId}")
	public JsonResult list(@PathVariable("billId") long billId) {
		try {
			List<PersonalAccount> accountList = accountService.getList(billId);
			return JsonResult.instance(accountList);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
	}
	
	@GetMapping("/group/{groupId}")
	public JsonResult listGroup(@PathVariable("groupId") long groupId) {
		try {
			List<PersonalAccount> accountList = accountService.getListByGroup(groupId);
			return JsonResult.instance(accountList);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
	}

}
