agroupPersonalTableName
===
* 用户表名
	t_account_group_personal
	
selectListByBill
===
* 查询帐户列表
	select * from #use("agroupPersonalTableName")#
	where
	bill_id = #billId#
	
selectMaxSortByCondition
===
* 查找最大排序值
	select ifnull(max(sort),0) from #use("agroupPersonalTableName")#
	where
	bill_id = #billId#
	