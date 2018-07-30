-- ----------------------------
-- 1、部门表
-- ----------------------------
drop table if exists sys_dept;
CREATE TABLE sys_dept (
  id INT ( 11 ) NOT NULL auto_increment COMMENT '部门id',
  parent_id INT ( 11 ) DEFAULT 0 COMMENT '父部门id',
  dept_name VARCHAR ( 30 ) DEFAULT '' COMMENT '部门名称',
  order_num INT ( 4 ) DEFAULT 0 COMMENT '显示顺序',
  leader VARCHAR ( 20 ) DEFAULT '' COMMENT '负责人',
  phone VARCHAR ( 11 ) DEFAULT '' COMMENT '联系电话',
  email VARCHAR ( 50 ) DEFAULT '' COMMENT '邮箱',
  status TINYINT ( 1 ) DEFAULT 1 COMMENT '部门状态（0停用 1正常）',
  create_by VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
  create_time datetime COMMENT '创建时间',
  update_by VARCHAR ( 64 ) DEFAULT '' COMMENT '更新者',
  update_time datetime COMMENT '更新时间',
  PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT charset = utf8mb4 COMMENT = '部门表';

-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
CREATE TABLE sys_user (
  id INT ( 11 ) NOT NULL auto_increment COMMENT '用户ID',
  dept_id INT ( 11 ) DEFAULT NULL COMMENT '部门ID',
  login_name VARCHAR ( 30 ) NOT NULL COMMENT '登录账号',
  user_name VARCHAR ( 30 ) NOT NULL COMMENT '用户昵称',
  user_type VARCHAR ( 2 ) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  email VARCHAR ( 50 ) DEFAULT '' COMMENT '用户邮箱',
  phonenumber VARCHAR ( 11 ) DEFAULT '' COMMENT '手机号码',
  sex TINYINT ( 1 ) DEFAULT 0 COMMENT '用户性别（0男 1女 2未知）',
  avatar VARCHAR ( 100 ) DEFAULT '' COMMENT '头像路径',
  PASSWORD VARCHAR ( 50 ) DEFAULT '' COMMENT '密码',
  status TINYINT ( 1 ) DEFAULT 1 COMMENT '帐号状态（0停用 1正常）',
  del_flag TINYINT ( 1 ) DEFAULT 0 COMMENT '删除标志（0代表存在 1代表删除）',
  login_ip VARCHAR ( 20 ) DEFAULT '' COMMENT '最后登陆IP',
  login_date datetime COMMENT '最后登陆时间',
  create_by VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
  create_time datetime COMMENT '创建时间',
  update_by VARCHAR ( 64 ) DEFAULT '' COMMENT '更新者',
  update_time datetime COMMENT '更新时间',
  remark VARCHAR ( 500 ) DEFAULT '' COMMENT '备注',
  PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '用户信息表';

-- ----------------------------
-- 3、岗位信息表
-- ----------------------------
drop table if exists sys_job;
CREATE TABLE sys_job (
  id INT ( 11 ) NOT NULL auto_increment COMMENT '岗位ID',
  job_code VARCHAR ( 64 ) NOT NULL COMMENT '岗位编码',
  job_name VARCHAR ( 50 ) NOT NULL COMMENT '岗位名称',
  job_sort INT ( 4 ) NOT NULL COMMENT '显示顺序',
  status TINYINT ( 1 ) DEFAULT 1 COMMENT '状态（0停用 1正常）',
  create_by VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
  create_time datetime COMMENT '创建时间',
  update_by VARCHAR ( 64 ) DEFAULT '' COMMENT '更新者',
  update_time datetime COMMENT '更新时间',
  remark VARCHAR ( 500 ) DEFAULT '' COMMENT '备注',
  PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '岗位信息表';

-- ----------------------------
-- 4、角色信息表
-- ----------------------------
drop table if exists sys_role;
CREATE TABLE sys_role (
  id INT ( 11 ) NOT NULL auto_increment COMMENT '角色ID',
  role_name VARCHAR ( 30 ) NOT NULL COMMENT '角色名称',
  role_key VARCHAR ( 100 ) NOT NULL COMMENT '角色权限字符串',
  role_sort INT ( 4 ) NOT NULL COMMENT '显示顺序',
  status TINYINT ( 1 ) DEFAULT 1 COMMENT '角色状态（0停用 1正常）',
  create_by VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
  create_time datetime COMMENT '创建时间',
  update_by VARCHAR ( 64 ) DEFAULT '' COMMENT '更新者',
  update_time datetime COMMENT '更新时间',
  remark VARCHAR ( 500 ) DEFAULT '' COMMENT '备注',
  PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '角色信息表';

-- ----------------------------
-- 5、菜单权限表
-- ----------------------------
drop table if exists sys_menu;
CREATE TABLE sys_menu (
  id INT ( 11 ) NOT NULL auto_increment COMMENT '菜单ID',
  menu_name VARCHAR ( 50 ) NOT NULL COMMENT '菜单名称',
  parent_id INT ( 11 ) DEFAULT 0 COMMENT '父菜单ID',
  order_num INT ( 4 ) DEFAULT NULL COMMENT '显示顺序',
  url VARCHAR ( 200 ) DEFAULT '' COMMENT '请求地址',
  menu_type TINYINT ( 1 ) DEFAULT NULL COMMENT '菜单类型（0目录 1菜单 2按钮）',
  visible TINYINT ( 1 ) DEFAULT 1 COMMENT '菜单状态（0隐藏 1显示）',
  perms VARCHAR ( 100 ) DEFAULT '' COMMENT '权限标识',
  icon VARCHAR ( 100 ) DEFAULT '' COMMENT '菜单图标',
  create_by VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
  create_time datetime COMMENT '创建时间',
  update_by VARCHAR ( 64 ) DEFAULT '' COMMENT '更新者',
  update_time datetime COMMENT '更新时间',
  remark VARCHAR ( 500 ) DEFAULT '' COMMENT '备注',
  PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '菜单权限表';

-- ----------------------------
-- 6、用户和角色关联表  用户N-1角色
-- ----------------------------
drop table if exists sys_user_role;
CREATE TABLE sys_user_role (
  user_id INT ( 11 ) NOT NULL COMMENT '用户ID',
  role_id INT ( 11 ) NOT NULL COMMENT '角色ID',
  PRIMARY KEY ( user_id, role_id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '用户和角色关联表';

-- ----------------------------
-- 7、角色和菜单关联表  角色1-N菜单
-- ----------------------------
drop table if exists sys_role_menu;
CREATE TABLE sys_role_menu (
  role_id INT ( 11 ) NOT NULL COMMENT '角色ID',
  menu_id INT ( 11 ) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY ( role_id, menu_id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '角色和菜单关联表';

-- ----------------------------
-- 8、用户与岗位关联表  用户1-N岗位
-- ----------------------------
drop table if exists sys_user_job;
CREATE TABLE sys_user_job (
  user_id VARCHAR ( 64 ) NOT NULL COMMENT '用户ID',
  job_id VARCHAR ( 64 ) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY ( user_id, job_id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '用户与岗位关联表';

-- ----------------------------
-- 9、操作日志记录
-- ----------------------------
drop table if exists sys_operation_log;
CREATE TABLE sys_operation_log (
	id INT ( 11 ) NOT NULL auto_increment COMMENT '日志主键',
	title VARCHAR ( 50 ) DEFAULT '' COMMENT '模块标题',
	action VARCHAR ( 100 ) DEFAULT '' COMMENT '功能请求',
	method VARCHAR ( 100 ) DEFAULT '' COMMENT '方法名称',
	oper_name VARCHAR ( 50 ) DEFAULT '' COMMENT '操作人员',
	dept_name VARCHAR ( 50 ) DEFAULT '' COMMENT '部门名称',
	oper_url VARCHAR ( 255 ) DEFAULT '' COMMENT '请求URL',
	oper_ip VARCHAR ( 30 ) DEFAULT '' COMMENT '主机地址',
	oper_location VARCHAR ( 255 ) DEFAULT '' COMMENT '操作地点',
	oper_param VARCHAR ( 255 ) DEFAULT '' COMMENT '请求参数',
	status TINYINT ( 1 ) DEFAULT 1 COMMENT '操作状态（0异常 1正常）',
	error_msg VARCHAR ( 2000 ) DEFAULT '' COMMENT '错误消息',
	oper_time datetime COMMENT '操作时间',
  PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '操作日志记录';

-- ----------------------------
-- 10、字典类型表
-- ----------------------------
drop table if exists sys_dict_type;
CREATE TABLE sys_dict_type (
  id INT ( 11 ) NOT NULL auto_increment COMMENT '字典主键',
  dict_name VARCHAR ( 100 ) DEFAULT '' COMMENT '字典名称',
  dict_type VARCHAR ( 100 ) DEFAULT '' COMMENT '字典类型',
  status TINYINT ( 1 ) DEFAULT 1 COMMENT '状态（0停用 1正常）',
  create_by VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
  create_time datetime COMMENT '创建时间',
  update_by VARCHAR ( 64 ) DEFAULT '' COMMENT '更新者',
  update_time datetime COMMENT '更新时间',
  remark VARCHAR ( 500 ) DEFAULT '' COMMENT '备注',
  PRIMARY KEY ( id ),
  UNIQUE ( dict_type )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '字典类型表';

-- ----------------------------
-- 11、字典数据表
-- ----------------------------
drop table if exists sys_dict_data;
CREATE TABLE sys_dict_data (
  id INT ( 11 ) NOT NULL auto_increment COMMENT '字典编码',
  dict_sort INT ( 4 ) DEFAULT 0 COMMENT '字典排序',
  dict_label VARCHAR ( 100 ) DEFAULT '' COMMENT '字典标签',
  dict_value VARCHAR ( 100 ) DEFAULT '' COMMENT '字典键值',
  dict_type VARCHAR ( 100 ) DEFAULT '' COMMENT '字典类型',
  css_class VARCHAR ( 500 ) DEFAULT '' COMMENT '样式属性',
  list_class VARCHAR ( 500 ) DEFAULT '' COMMENT '回显样式',
  is_default TINYINT ( 1 ) DEFAULT 0 COMMENT '是否默认（0否 1是）',
  status TINYINT ( 1 ) DEFAULT 1 COMMENT '状态（0停用 1正常）',
  create_by VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
  create_time datetime COMMENT '创建时间',
  update_by VARCHAR ( 64 ) DEFAULT '' COMMENT '更新者',
  update_time datetime COMMENT '更新时间',
  remark VARCHAR ( 500 ) DEFAULT '' COMMENT '备注',
  PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '字典数据表';

-- ----------------------------
-- 12、参数配置表
-- ----------------------------
drop table if exists sys_config;
CREATE TABLE sys_config (
  id INT ( 5 ) NOT NULL auto_increment COMMENT '参数主键',
  config_name VARCHAR ( 100 ) DEFAULT '' COMMENT '参数名称',
  config_key VARCHAR ( 100 ) DEFAULT '' COMMENT '参数键名',
  config_value VARCHAR ( 100 ) DEFAULT '' COMMENT '参数键值',
  config_type TINYINT ( 1 ) DEFAULT 0 COMMENT '系统内置（0否 1是）',
  create_by VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
  create_time datetime COMMENT '创建时间',
  update_by VARCHAR ( 64 ) DEFAULT '' COMMENT '更新者',
  update_time datetime COMMENT '更新时间',
  remark VARCHAR ( 500 ) DEFAULT '' COMMENT '备注',
  PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '参数配置表';

-- ----------------------------
-- 13、系统访问记录
-- ----------------------------
drop table if exists sys_login_log;
CREATE TABLE sys_login_log (
  id INT ( 11 ) NOT NULL auto_increment COMMENT '访问ID',
  login_name VARCHAR ( 50 ) DEFAULT '' COMMENT '登录账号',
  ip_address VARCHAR ( 50 ) DEFAULT '' COMMENT '登录IP地址',
  login_location VARCHAR ( 255 ) DEFAULT '' COMMENT '登录地点',
  browser VARCHAR ( 50 ) DEFAULT '' COMMENT '浏览器类型',
  os VARCHAR ( 50 ) DEFAULT '' COMMENT '操作系统',
  status TINYINT ( 1 ) DEFAULT 1 COMMENT '登录状态（0失败 1成功）',
  msg VARCHAR ( 255 ) DEFAULT '' COMMENT '提示消息',
  login_time datetime COMMENT '访问时间',
  PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT charset = utf8 COMMENT = '系统访问记录';