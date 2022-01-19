
use `combo_project`;

drop table if EXISTS `s_user_login`;
CREATE TABLE `s_user_login` (
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
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'登录用户信息表';

drop table if EXISTS `s_user`;
CREATE TABLE `s_user` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `platform` varchar(20) NOT NULL COMMENT '归属平台',
    `username` varchar(20) NOT NULL COMMENT '用户名',
    `password` varchar(32) NOT NULL COMMENT '登录密码',
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'用户信息';

/**
 * CREATE TABLE `s_user_login_platform`;
 * CREATE TABLE `s_user_login_role`;
 */
drop table if EXISTS `s_platform`;
CREATE TABLE `s_platform` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `name` varchar(20) NOT NULL COMMENT '平台名称',
    `code` varchar(20) NOT NULL COMMENT '平台标识',
    `description` varchar(255) NOT NULL COMMENT '平台描述',
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'平台';
INSERT INTO s_platform(name, code, description) VALUES('管理平台', 'ADMIN', '管理平台');

drop table if EXISTS `s_platform`;
CREATE TABLE `s_platform` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `name` varchar(20) NOT NULL COMMENT '平台名称',
    `code` varchar(20) NOT NULL COMMENT '平台标识',
    `description` varchar(255) NOT NULL COMMENT '平台描述',
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'平台';

drop table if EXISTS `s_department`;
CREATE TABLE `s_department` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `name` varchar(20) NOT NULL COMMENT '部门名称',
    `description` varchar(255) NOT NULL COMMENT '部门描述',
    `order` int NOT NULL COMMENT '排序',
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    `parent_id` int DEFAULT NULL COMMENT '父ID',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'平台';

/**
  数据权限 - 部门
  功能权限 - 菜单
  状态：启用 禁用
 */
drop table if EXISTS `s_role`;
CREATE TABLE `s_role` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
    `name` varchar(20) NOT NULL COMMENT '角色名称',
    `code` varchar(20) NOT NULL COMMENT '角色标识',
    `description` varchar(255) NOT NULL COMMENT '角色描述',
    `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'角色';
INSERT INTO s_role(name, code, description) VALUES('系统管理员', 'ADMIN', '系统超级管理员');


drop table if EXISTS `s_menu`;
CREATE TABLE `s_menu` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` int DEFAULT NULL COMMENT '创建人',
    `updated_by` int DEFAULT NULL COMMENT '更新人',
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