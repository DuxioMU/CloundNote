刘雪松

#项目目标
独立实现项目需求

#实现手段
四个阶段

#课程安排

- day01-day09 实现需求

- day10-day12 AOP/关联映射/动态sql

#正课内容

- 了解项目

- 搭建环境

##springmvc响应流程

请求->DispatcherServlet

-->HandlerMapping

-->Controller

-->Jsp响应

##Json的响应流程

请求->DispatcherServlet

-->HandlerMapping

-->Controller

--返回数据对象(Json)


将返回数据对象进行Json处理

步骤:

- 1 导包:Jackson 2.2.3

- 2 配置文件:web.xml spring-mvc.xml

- 3 在返回数据对象(String/对象/集合/Map)的方法增加注解:@ResponseBody

##javabean规范

- 有包
- 实现序列化接口
- 无参构造方法
- set/get方法
- 重写toString()
- 重写equals/Hashcode方法

# 项目简介

- 项目概况

- 模块划分

- 设计思想

- 技术架构


##云笔记:

##模块:

- 用户模块: 注册功能 登录功能 密码修改 退出系统

- 笔记本模块:新建 删除 更新 查看

- 笔记模块: 新建 删除 修改 查看 移动

- 收藏和分享: 针对笔记有分享和收藏的功能

- 回收模块: 还原 彻底删除 查看

- 活动模块:投稿

##MVC设计模式

 - 表现层(V):HTML+CSS+jQuery

 - 控制层(C):Controller组件

 - 业务层(M):Service组件

 - 数据层(M):Dao组件


##技术架构

java+html+css+jQuery+springmvc+spring(IOC+AOP)+mybatis



##E-R图 实体-关系图

通过对现实业务分析得出.


###关系类型

- 一对一

- 一对多

- 多对多

#MySql

- 命令: mysql -uroot -p	启动mysql

- show databases; 显示数据库列表

- use mysql;		连接具体数据库

- show tables;	显示表;

- use test;		切换数据库连接;

- create database 库名;  创建数据库
	
- drop database 库名;	   删除数据库


- set names utf8; 		   设置建库-建表的编码;

- source /home/soft01/cloud_note.sql;	导入SQL文件

- source e:\\cloud_note.sql;(windows系统)


#spring+mybatis整合

- 创建项目:spring-mybatis
- 导包
- 配置文件spring-mybatis.xml
- 测试环境


#搭建环境

- 创建项目:cloudnote
- 导包:11包
- 配置文件:web.xml conf/spring-mvc.xml conf/spring-mybatis.xml
- 注意:增加mapper包


#作业:

独立搭建项目环境:

- 创建项目:cloudnote
- 导包:11包
- 配置文件:web.xml conf/spring-mvc.xml conf/spring-mybatis.xml
- 注意:增加mapper包




































































