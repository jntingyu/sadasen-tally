userTableName
===
* 用户表名
	sys_user

selectByUserName
===
* 根据用户名查询用户信息
	select * from #use("userTableName")#
	where
	user_name = #userName#