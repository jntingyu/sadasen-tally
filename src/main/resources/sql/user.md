userTableName
===
* 用户表名
	sys_user
	
userInfoTableName
===
* 用户表名
	sys_user_info
	
insertUserInfo
===
* 新增用户信息
	insert into #use("userInfoTableName")# (user_id, real_name, id_card, email, phone_num)
	values
	(#userId#, #realName#, #idCard#, #email#, #phoneNum#)
	
updateLoginInfo
===
* 修改用户登录信息
	update #use("userTableName")# set last_login_time = #lastLoginTime#, login_time = #loginTime#
	where
	id = #id#

selectByUserName
===
* 根据用户名查询用户信息
	select * from #use("userTableName")#
	where
	user_name = #userName#