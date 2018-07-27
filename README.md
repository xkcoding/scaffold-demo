# scaffold
## 平台简介

平时开发管理平台项目，通常都会有用户管理，权限管理，日志管理等通用模块。虽然功能不多难度不大，但是开发起来也会消耗不少精力。

网上也有很多快速开发的脚手架项目，但是有些又夹杂了一些别的功能，显得不是那么纯粹，有些功能刚好，但是简单的功能又过度封装，使得像我这样的 **7流** 程序员看起来略有些困难。。。（PS：还不就是为了满足一下自己造轮子的装逼想法！）

取名：`scaffold`，翻译也是：`脚手架；给……搭脚手架；用支架支撑`

## 技术栈
### 后端技术栈

1. Spring Boot 2.0.3.RELEASE
2. Mybatis
3. 通用 Mapper
4. PageHelper
5. Spring Security
6. Quartz
7. Swagger
8. HikariCP
9. ......

> 用到别的再补充，暂时不知道脚手架后期会支持到什么程度，万一后面想写一个大而全的脚手架了呢，嘿嘿嘿~

### 前端技术栈

暂时考虑会做两套，一套基于模板引擎，一套前后端分离。

**模板引擎**
1. Beetl 引擎
2. Jquery

**前后端分离**
1. Vue 全家桶，Vue / VueRouter / Vuex
2. axios
3. iView
4. iView-admin

## 内置功能（计划）

1. 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2. 部门管理：配置系统组织机构（公司、部门、小组），树结构展现。
3. 岗位管理：配置系统用户所属担任职务。
4. 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5. 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6. 字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7. 参数管理：对系统动态配置常用参数。
8. 通知公告：系统通知公告信息发布维护。
9. 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 系统接口：根据业务代码自动生成相关的api接口文档。

## 演示
### 在线体验

开发 ing，别急嘛

### 演示图

占个位先

## 交流
### 交流群

还没开发，你咋啥都准备好了？

### 联系我

- Email: 237497819@qq.com
- QQ: 237497819

## License
[MIT](http://opensource.org/licenses/MIT)

Copyright (c) 2018 Yangkai.Shen
