
CREATE DATABASE IF NOT EXISTS `combo_project` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE `combo_project`;

/**
 * 用户表
 */
drop table if EXISTS `s_user`;
CREATE TABLE `s_user` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    `login_at` datetime(6) DEFAULT NULL COMMENT '最后登录时间',
    `login_ip` varchar(15) DEFAULT NULL COMMENT '最后登录ip',
    `username` varchar(20) NOT NULL COMMENT '用户名',
    `password` varchar(32) NOT NULL COMMENT '登录密码',
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
    `department_id` int DEFAULT NULL COMMENT '部门ID',
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'登录用户信息表';


/**
 * 平台
 */
drop table if EXISTS `s_platform`;
CREATE TABLE `s_platform` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    `name` varchar(20) NOT NULL COMMENT '平台名称',
    `code` varchar(20) NOT NULL COMMENT '平台标识',
    `description` varchar(255) NOT NULL COMMENT '平台描述',
    `order` int NOT NULL COMMENT '排序',
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'平台';
INSERT INTO s_platform(name, code, description) VALUES('管理平台', 'ADMIN', '管理平台');


/**
 * 用户平台关联表
 */
drop table if EXISTS `r_user_platform`;
CREATE TABLE `r_user_platform` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id` int NOT NULL COMMENT '用户id',
    `platform_id` int NOT NULL COMMENT '平台id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'用户平台关联表';


/**
 * 部门表
 */
drop table if EXISTS `s_department`;
CREATE TABLE `s_department` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    `name` varchar(20) NOT NULL COMMENT '部门名称',
    `description` varchar(255) NOT NULL COMMENT '部门描述',
    `order` int NOT NULL COMMENT '排序',
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    `parent_id` int DEFAULT NULL COMMENT '父ID',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'平台';


/**
 * 角色表
 */
drop table if EXISTS `s_role`;
CREATE TABLE `s_role` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    `name` varchar(20) NOT NULL COMMENT '角色名称',
    `code` varchar(20) NOT NULL COMMENT '角色标识',
    `description` varchar(255) NOT NULL COMMENT '角色描述',
    `order` int NOT NULL COMMENT '排序',
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'角色';
INSERT INTO s_role(name, code, description) VALUES('系统管理员', 'ADMIN', '系统超级管理员');


/**
 * 菜单表
 */
drop table if EXISTS `s_menu`;
CREATE TABLE `s_menu` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    `desc` varchar(255) DEFAULT NULL COMMENT '描述',
    `code` varchar(50) NOT NULL COMMENT '标识',
    `title` varchar(10) NOT NULL COMMENT '名称',
    `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
    `path` varchar(100) DEFAULT NULL COMMENT '路由路径',
    `component` varchar(100) DEFAULT NULL COMMENT '组件路径',
    `type` enum('1','2','3') NOT NULL DEFAULT '2' COMMENT '类型',
    `show_menu` enum('0','1') NOT NULL DEFAULT '1' COMMENT '是否在菜单栏显示',
    `keep_alive` enum('0','1') NOT NULL DEFAULT '0' COMMENT '组件是否缓存',
    `layout` varchar(50) NOT NULL DEFAULT 'default' COMMENT '页面布局类型',
    `sort` int NOT NULL DEFAULT '100' COMMENT '排序',
    `permission` varchar(100) DEFAULT NULL COMMENT '权限标识',
    `parent_id` int DEFAULT NULL COMMENT '父id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'系统菜单';


/**
 * 用户角色关联表
 */
DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role` (
   `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
   `user_id` int NOT NULL COMMENT '用户id',
   `role_id` int NOT NULL COMMENT '角色id',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'用户角色关联表';

/**
 * 角色菜单关联表
 */
DROP TABLE IF EXISTS `r_role_menu`;
CREATE TABLE `r_role_menu` (
   `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
   `role_id` int NOT NULL COMMENT '角色id',
   `menu_id` int NOT NULL COMMENT '菜单id',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'角色菜单关联表';

/**
 * 角色部门关联表 - 数据权限  1 全部；2 本级；3 本级及子级；4 自定义
 */
DROP TABLE IF EXISTS `r_role_department`;
CREATE TABLE `r_role_department` (
   `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
   `role_id` int NOT NULL COMMENT '角色id',
   `department_id` int NOT NULL COMMENT '部门id',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'角色部门数据权限关联表';

/**
 * 字典表
 */
DROP TABLE IF EXISTS `s_dict`;
CREATE TABLE `s_dict` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    `name` varchar(20) NOT NULL COMMENT '字典名称',
    `code` varchar(20) NOT NULL COMMENT '字典标识',
    `description` varchar(255) NOT NULL COMMENT '字典描述',
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'字典';

/**
 * 字典项
 */
DROP TABLE IF EXISTS `s_dict_item`;
CREATE TABLE `s_dict_item` (
      `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
      `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
      `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
      `created_by` int DEFAULT NULL COMMENT '创建人',
      `updated_by` int DEFAULT NULL COMMENT '更新人',
      `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
      `dict_id` int NOT NULL  COMMENT '字典id',
      `label` varchar(20) NOT NULL COMMENT '字典项名称',
      `value` varchar(20) NOT NULL COMMENT '字典项标识',
      `description` varchar(255) NOT NULL COMMENT '字典描述',
      `order` int NOT NULL COMMENT '排序',
      `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'字典项';

/**
    参数管理：对系统动态配置常用参数。 config
    通知公告：系统通知公告信息发布维护。 notice
    操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
    登录日志：系统登录日志记录查询包含登录异常。
    在线用户：当前系统中活跃用户状态监控
 */