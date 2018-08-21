-- 系统用户表
CREATE TABLE IF NOT EXISTS sys_user (
	id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
	user_name varchar(30) NOT NULL COMMENT '用户名',
	nick_name varchar(30) DEFAULT NULL COMMENT '昵称',
	password varchar(50) NOT NULL COMMENT '密码',
	sign varchar(50) DEFAULT NULL COMMENT '用户邮箱',
	profile_photo varchar(200) DEFAULT NULL COMMENT '头像',
	login_time timestamp DEFAULT current_timestamp COMMENT '登录时间',
	last_login_time timestamp DEFAULT current_timestamp COMMENT '上次登录时间',
	create_time timestamp DEFAULT current_timestamp COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 系统用户信息表
CREATE TABLE IF NOT EXISTS sys_user_info (
	user_id bigint(20) NOT NULL PRIMARY KEY COMMENT '用户ID',
	real_name varchar(50) DEFAULT NULL COMMENT '真是姓名',
	id_card varchar(20) DEFAULT NULL COMMENT '身份证号',
	email varchar(50) DEFAULT NULL COMMENT '用邮箱',
	phone_num bigint(20) NOT NULL DEFAULT -1 COMMENT '手机号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;