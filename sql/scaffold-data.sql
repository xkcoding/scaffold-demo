-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------
insert into sys_dept values(1,  0,   '集团', 0, 'xkcoding', '15888888888', '237497819@qq.com', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');
insert into sys_dept values(2,  1, '研发部门', 1, 'xkcoding', '15888888888', '237497819@qq.com', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');
insert into sys_dept values(3,  1, '市场部门', 2, 'xkcoding', '15888888888', '237497819@qq.com', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');
insert into sys_dept values(4,  1, '测试部门', 3, 'xkcoding', '15888888888', '237497819@qq.com', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');
insert into sys_dept values(5,  1, '财务部门', 4, 'xkcoding', '15888888888', '237497819@qq.com', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');
insert into sys_dept values(6,  1, '运维部门', 5, 'xkcoding', '15888888888', '237497819@qq.com', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');
insert into sys_dept values(7,  2, '研发一部', 1, 'xkcoding', '15888888888', '237497819@qq.com', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');
insert into sys_dept values(8,  2, '研发二部', 2, 'xkcoding', '15888888888', '237497819@qq.com', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');
insert into sys_dept values(9,  3, '市场一部', 1, 'xkcoding', '15888888888', '237497819@qq.com', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');
insert into sys_dept values(10,  3, '市场二部', 2, 'xkcoding', '15888888888', '237497819@qq.com', '0', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00');

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
insert into sys_user values(1,  7, 'admin', 'xkcoding', '00', '237497819@qq.com', '15888888888', '1', '', '$2a$10$NG9t0BI6ZxOuoB4GjQI8aeiD4KFbXH.bauTZTuquCjJpZnUeCq0fm', '1', '0', '127.0.0.1', '2018-07-30 18-00-00', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '管理员');
insert into sys_user values(2,  9, 'xkcoding',    'xkcoding', '00', '237497819@qq.com',  '15666666666', '1', '', '$2a$10$OCGlv4ACVYO7aMearTHff.cqNmt1yJYujan7U4q2bGqYpEN3o5Bxy', '1', '0', '127.0.0.1', '2018-07-30 18-00-00', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '测试员');

-- ----------------------------
-- 初始化-岗位信息表数据
-- ----------------------------
insert into sys_work values(1, 'ceo',  '董事长',    1, '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_work values(2, 'se',   '项目经理',  2, '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_work values(3, 'hr',   '人力资源',  3, '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_work values(4, 'user', '普通员工',  4, '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');

-- ----------------------------
-- 初始化-角色信息表数据
-- ----------------------------
insert into sys_role values('1', '管理员',   'admin',  1,  1, 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '管理员');
insert into sys_role values('2', '普通角色', 'common', 2,  1, 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '普通角色');

-- ----------------------------
-- 初始化-菜单信息表数据
-- ----------------------------
-- 一级菜单
insert into sys_menu values('1', '系统管理', '0', '1', '#', '0', '1', '','', 'fa fa-gear',         'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '系统管理目录');
-- 二级菜单
insert into sys_menu values('100',  '用户管理', '1', '1', '/system/user',        '1', '1', '','system:user:view',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '用户管理菜单');
insert into sys_menu values('101',  '角色管理', '1', '2', '/system/role',        '1', '1', '','system:role:view',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '角色管理菜单');
insert into sys_menu values('102',  '菜单管理', '1', '3', '/system/menu',        '1', '1', '','system:menu:view',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '菜单管理菜单');
insert into sys_menu values('103',  '部门管理', '1', '4', '/system/dept',        '1', '1', '','system:dept:view',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '部门管理菜单');
insert into sys_menu values('104',  '岗位管理', '1', '5', '/system/job',        '1', '1', '','system:post:view',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '岗位管理菜单');
insert into sys_menu values('105',  '字典管理', '1', '6', '/system/dict',        '1', '1', '','system:dict:view',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '字典管理菜单');
insert into sys_menu values('106',  '参数设置', '1', '7', '/system/config',      '1', '1', '','system:config:view',       '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '参数设置菜单');
insert into sys_menu values('107',  '通知公告', '1', '8', '/system/notice',      '1', '1', '','system:notice:view',       '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '通知公告菜单');
insert into sys_menu values('108',  '日志管理', '1', '9', '#',                   '0', '1','', '',                         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '日志管理菜单');
-- 三级菜单
insert into sys_menu values('500',  '操作日志', '108', '1', '/monitor/operlog',    '1', '1', '','monitor:operlog:view',     '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '操作日志菜单');
insert into sys_menu values('501',  '登录日志', '108', '2', '/monitor/logininfor', '1', '1', '','monitor:logininfor:view',  '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '登录日志菜单');
-- 用户管理按钮
insert into sys_menu values('1000', '用户查询', '100', '1',  '#',  '2', '1','', 'system:user:list',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1001', '用户新增', '100', '2',  '#',  '2', '1','', 'system:user:add',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1002', '用户修改', '100', '3',  '#',  '2', '1', '','system:user:edit',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1003', '用户删除', '100', '4',  '#',  '2', '1', '','system:user:remove',      '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1004', '重置密码', '100', '5',  '#',  '2', '1', '','system:user:resetPwd',    '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
-- 角色管理按钮
insert into sys_menu values('1005', '角色查询', '101', '1',  '#',  '2', '1', '','system:role:list',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1006', '角色新增', '101', '2',  '#',  '2', '1', '','system:role:add',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1007', '角色修改', '101', '3',  '#',  '2', '1', '','system:role:edit',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1008', '角色删除', '101', '4',  '#',  '2', '1', '','system:role:remove',      '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
-- 菜单管理按钮
insert into sys_menu values('1009', '菜单查询', '102', '1',  '#',  '2', '1', '','system:menu:list',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1010', '菜单新增', '102', '2',  '#',  '2', '1', '','system:menu:add',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1011', '菜单修改', '102', '3',  '#',  '2', '1', '','system:menu:edit',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1012', '菜单删除', '102', '4',  '#',  '2', '1', '','system:menu:remove',      '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
-- 部门管理按钮
insert into sys_menu values('1013', '部门查询', '103', '1',  '#',  '2', '1','', 'system:dept:list',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1014', '部门新增', '103', '2',  '#',  '2', '1', '','system:dept:add',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1015', '部门修改', '103', '3',  '#',  '2', '1', '','system:dept:edit',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1016', '部门删除', '103', '4',  '#',  '2', '1', '','system:dept:remove',      '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
-- 岗位管理按钮
insert into sys_menu values('1017', '岗位查询', '104', '1',  '#',  '2', '1', '','system:job:list',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1018', '岗位新增', '104', '2',  '#',  '2', '1', '','system:job:add',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1019', '岗位修改', '104', '3',  '#',  '2', '1', '','system:job:edit',        '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1020', '岗位删除', '104', '4',  '#',  '2', '1', '','system:job:remove',      '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
-- 字典管理按钮
insert into sys_menu values('1021', '字典查询', '105', '1', '#',  '2', '1', '','system:dict:list',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1022', '字典新增', '105', '2', '#',  '2', '1', '','system:dict:add',          '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1023', '字典修改', '105', '3', '#',  '2', '1', '','system:dict:edit',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1024', '字典删除', '105', '4', '#',  '2', '1', '','system:dict:remove',       '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
-- 参数设置按钮
insert into sys_menu values('1025', '参数查询', '106', '1', '#',  '2', '1', '','system:config:list',      '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1026', '参数新增', '106', '2', '#',  '2', '1', '','system:config:add',       '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1027', '参数修改', '106', '3', '#',  '2', '1', '','system:config:edit',      '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1028', '参数删除', '106', '4', '#',  '2', '1', '','system:config:remove',    '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
-- 操作日志按钮
insert into sys_menu values('1033', '操作查询', '500', '1', '#',  '2', '1', '','monitor:operationlog:list',    '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1034', '操作删除', '500', '2', '#',  '2', '1', '','monitor:operationlog:remove',  '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1035', '详细信息', '500', '3', '#',  '2', '1', '','monitor:operationlog:detail',  '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
-- 登录日志按钮
insert into sys_menu values('1036', '登录查询', '501', '1', '#',  '2', '1', '','monitor:loginlog:list',         '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');
insert into sys_menu values('1037', '登录删除', '501', '2', '#',  '2', '1', '','monitor:loginlog:remove',       '#', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '');

-- ----------------------------
-- 初始化-用户和角色关联表数据
-- ----------------------------
insert into sys_user_role values ('1', '1');
insert into sys_user_role values ('2', '2');

-- ----------------------------
-- 初始化-角色和菜单关联表数据
-- ----------------------------
insert into sys_role_menu values ('1', '1');
insert into sys_role_menu values ('1', '100');
insert into sys_role_menu values ('1', '101');
insert into sys_role_menu values ('1', '102');
insert into sys_role_menu values ('1', '103');
insert into sys_role_menu values ('1', '104');
insert into sys_role_menu values ('1', '105');
insert into sys_role_menu values ('1', '106');
insert into sys_role_menu values ('1', '107');
insert into sys_role_menu values ('1', '108');
insert into sys_role_menu values ('1', '500');
insert into sys_role_menu values ('1', '501');
insert into sys_role_menu values ('1', '1000');
insert into sys_role_menu values ('1', '1001');
insert into sys_role_menu values ('1', '1002');
insert into sys_role_menu values ('1', '1003');
insert into sys_role_menu values ('1', '1004');
insert into sys_role_menu values ('1', '1005');
insert into sys_role_menu values ('1', '1006');
insert into sys_role_menu values ('1', '1007');
insert into sys_role_menu values ('1', '1008');
insert into sys_role_menu values ('1', '1009');
insert into sys_role_menu values ('1', '1010');
insert into sys_role_menu values ('1', '1011');
insert into sys_role_menu values ('1', '1012');
insert into sys_role_menu values ('1', '1013');
insert into sys_role_menu values ('1', '1014');
insert into sys_role_menu values ('1', '1015');
insert into sys_role_menu values ('1', '1016');
insert into sys_role_menu values ('1', '1017');
insert into sys_role_menu values ('1', '1018');
insert into sys_role_menu values ('1', '1019');
insert into sys_role_menu values ('1', '1020');
insert into sys_role_menu values ('1', '1021');
insert into sys_role_menu values ('1', '1022');
insert into sys_role_menu values ('1', '1023');
insert into sys_role_menu values ('1', '1024');
insert into sys_role_menu values ('1', '1025');
insert into sys_role_menu values ('1', '1026');
insert into sys_role_menu values ('1', '1027');
insert into sys_role_menu values ('1', '1028');
insert into sys_role_menu values ('1', '1033');
insert into sys_role_menu values ('1', '1034');
insert into sys_role_menu values ('1', '1035');
insert into sys_role_menu values ('1', '1036');
insert into sys_role_menu values ('1', '1037');

-- ----------------------------
-- 初始化-用户与岗位关联表数据
-- ----------------------------
insert into sys_user_work values ('1', '1');
insert into sys_user_work values ('2', '2');

-- ----------------------------
-- 初始化-字典类型表
-- ----------------------------
insert into sys_dict_type values(1,  '用户性别', 'sys_user_sex',        '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '用户性别列表');

-- ----------------------------
-- 初始化-字典数据表
-- ----------------------------
insert into sys_dict_data values(1,  1,  '男',       '0',  'sys_user_sex',        '',                                 '',        '1', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '性别男');
insert into sys_dict_data values(2,  2,  '女',       '1',  'sys_user_sex',        '',                                 '',        '0', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '性别女');
insert into sys_dict_data values(3,  3,  '未知',     '2',  'sys_user_sex',        '',                                 '',        '0', '1', 'admin', '2018-07-30 18-00-00', 'xkcoding', '2018-07-30 18-00-00', '性别未知');

-- ----------------------------
-- 初始化-参数配置表
-- ----------------------------
INSERT INTO sys_config VALUES (1,'用户管理-账号初始密码','sys.user.initPassword','123456',1,'admin','2018-07-30 18-00-00','xkcoding','2018-07-30 18-00-00','初始化密码 123456');