accountPersonalTableName
===
* 用户表名
	t_account_personal
	
groupAccountPersonalTableName
===
* 用户表名
	t_group_account_personal
	
insertGroupAccount
===
* 保存组和帐户的关联
	insert into #use("groupAccountPersonalTableName")# (group_id, account_id)
	values
	(#groupId#, #accountId#)
	
selectListByCondition
===
* 查询帐户列表
	select * from #use("accountPersonalTableName")#
	where
	bill_id = #billId#
	
selectListByBill
===
* 查询帐户列表
	select * from #use("accountPersonalTableName")#
	where
	bill_id = #billId#
	
selectListByGroup
===
* 根据帐户组查询帐户列表
	select a.* from #use("accountPersonalTableName")# a
	join #use("groupAccountPersonalTableName")# b on a.id = b.account_id
	where
	b.group_id = #groupId#
	
selectMaxSortByCondition
===
* 查找最大排序值
	select ifnull(max(sort),0) from #use("accountPersonalTableName")#
	where
	bill_id = #billId#
	