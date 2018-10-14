personalAccountTableName
===
* 用户表名
	t_personal_account
	
personalGroupAccountTableName
===
* 用户表名
	t_personal_group_account
	
insertGroupAccount
===
* 保存组和帐户的关联
	insert into #use("personalGroupAccountTableName")# (group_id, account_id)
	values
	(#groupId#, #accountId#)
	
selectListByCondition
===
* 查询帐户列表
	select * from #use("personalAccountTableName")#
	where
	bill_id = #billId#
	
selectListByBill
===
* 查询帐户列表
	select * from #use("personalAccountTableName")#
	where
	bill_id = #billId#
	
selectListByGroup
===
* 根据帐户组查询帐户列表
	select a.* from #use("personalAccountTableName")# a
	join #use("personalGroupAccountTableName")# b on a.id = b.account_id
	where
	b.group_id = #groupId#
	
selectMaxSortByCondition
===
* 查找最大排序值
	select ifnull(max(sort),0) from #use("personalAccountTableName")#
	where
	bill_id = #billId#
	