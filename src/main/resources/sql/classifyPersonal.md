classifyPersonalTableName
===
* 用户表名
	t_classify_personal
	
updateHasChild
===
* 修改三否有子节点
	update #use("classifyPersonalTableName")# set has_child = #hasChild# where id = #id#
	
selectListByCondition
===
* 查询分类列表
	select * from #use("classifyPersonalTableName")#
	where bill_id = #billId#
	and parent_id = #parentId#
	limit #start#,#pagesize#

selectMaxCodeAndSort
===
* 查找最大编号值
	select max(code) max_code, ifnull(max(sort),0) max_sort from #use("classifyPersonalTableName")#
	where
	level = #level# and parent_id = #parentId# and bill_id = #billId#