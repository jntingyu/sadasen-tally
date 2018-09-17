CREATE TABLE IF NOT EXISTS sys_user (
	id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
	user_name varchar(30) NOT NULL COMMENT '用户名',
	nick_name varchar(30) DEFAULT NULL COMMENT '昵称',
	password varchar(50) NOT NULL COMMENT '密码',
	sign varchar(50) DEFAULT NULL COMMENT '标签',
	profile_photo varchar(200) DEFAULT NULL COMMENT '头像',
	login_time timestamp DEFAULT current_timestamp COMMENT '登录时间',
	last_login_time timestamp DEFAULT current_timestamp COMMENT '上次登录时间',
	create_time timestamp DEFAULT current_timestamp COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS sys_user_info (
	user_id bigint(20) NOT NULL PRIMARY KEY COMMENT '用户ID',
	real_name varchar(50) DEFAULT NULL COMMENT '真是姓名',
	id_card varchar(20) DEFAULT NULL COMMENT '身份证号',
	email varchar(50) DEFAULT NULL COMMENT '邮箱',
	phone_num bigint(20) NOT NULL DEFAULT -1 COMMENT '手机号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS t_bill (
	id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '记账单ID',
	user_id bigint(20) NOT NULL DEFAULT 0 COMMENT '用户ID',
	name varchar(50) NOT NULL COMMENT '账单名称',
	start_date date DEFAULT NULL COMMENT '记账开始日期',
	end_date date DEFAULT NULL COMMENT '记账结束日期',
	type tinyint(4) NOT NULL DEFAULT 0 COMMENT '账单类型 1：个人账单，2：团体账单',
	sort int(11) NOT NULL DEFAULT 0 COMMENT '排序',
	remark varchar(200) DEFAULT NULL COMMENT '备注信息',
	create_time timestamp DEFAULT current_timestamp COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS t_classify_personal (
	id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '分类ID',
	parent_id bigint(20) NOT NULL DEFAULT 0 COMMENT '上级分类',
	bill_id bigint(20) NOT NULL DEFAULT 0 COMMENT '记账单ID',
	name varchar(50) NOT NULL COMMENT '分类名称',
	code varchar(60) NOT NULL DEFAULT '100' COMMENT '分类编码',
	level tinyint(4) NOT NULL DEFAULT 0 COMMENT '分级',
	sort int(11) NOT NULL DEFAULT 0 COMMENT '排序',
	has_child tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否有子分类',
	create_time timestamp DEFAULT current_timestamp COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS t_classify_personal_parent (
	child_id bigint(20) NOT NULL DEFAULT 0,
	parent_id bigint(20) NOT NULL DEFAULT 0,
	level tinyint(4) NOT NULL DEFAULT 0,
	PRIMARY KEY(child_id, parent_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS t_account_personal (
	id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '帐户ID',
	bill_id bigint(20) NOT NULL DEFAULT 0,
	name varchar(30) NOT NULL,
	sort int(11) NOT NULL DEFAULT 0,
	create_time timestamp DEFAULT current_timestamp COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS t_account_group_personal (
	id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '帐户组ID',
	bill_id bigint(20) NOT NULL DEFAULT 0,
	name varchar(30) NOT NULL,
	sort int(11) NOT NULL DEFAULT 0,
	create_time timestamp DEFAULT current_timestamp COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS t_group_account_personal (
	group_id bigint(20) NOT NULL DEFAULT 0,
	account_id bigint(20) NOT NULL DEFAULT 0,
	PRIMARY KEY(group_id, account_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
