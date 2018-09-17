billTableName
===
* 用户表名
	t_bill
	
selectMaxSortByCondition
===
* 查找最大排序值
	select max(sort) from #use("billTableName")#
	where
	user_id = #userId# and type = #type#
	
selectListByCondition
===
* 查询记账单列表
	select * from #use("billTableName")#
	where user_id = #userId#
	@if(type>0) {
		and type = #type#
	@}
	limit #start#,#pagesize#
	
countListByCondition
===
* 查询符合条件的个数
	select count(0) from #use("billTableName")#
	where user_id = #userId#
	@if(type>0) {
		and type = #type#
	@}