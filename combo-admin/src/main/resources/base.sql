
CREATE DATABASE IF NOT EXISTS `combo_project` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE `combo_project`;

/**
 * 用户
 */
drop table if EXISTS `sys_user`;
CREATE TABLE `sys_user` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `org_id` varchar(32) DEFAULT NULL COMMENT '部门ID',
    `client_id` varchar(32) DEFAULT NULL COMMENT '终端ID',
    `username` varchar(30) NOT NULL COMMENT '用户名',
    `password` varchar(50) NOT NULL COMMENT '登录密码',
    `avatar` varchar(50) DEFAULT NULL COMMENT '用户头像',
    `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
    `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
    `note` varchar(255) DEFAULT NULL COMMENT '备注',
    `enabled` varchar(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    `version` int DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'用户信息';

/**
 * 组织机构
 */
drop table if EXISTS `sys_org`;
CREATE TABLE `sys_org` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `parent_id` varchar(32) DEFAULT NULL COMMENT '上级ID',
    `name` varchar(20) NOT NULL COMMENT '名称',
    `scope` varchar(255) DEFAULT NULL COMMENT '数据权限',
    `note` varchar(255) DEFAULT NULL COMMENT '备注',
    `sort` int DEFAULT 1 COMMENT '排序',
    `enabled` varchar(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    `version` int DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'组织机构';

drop table if EXISTS `sys_org_rel`;
CREATE TABLE `sys_org_rel` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `ancestor_id` varchar(32) NOT NULL COMMENT '祖先ID',
    `descendant_id` varchar(32) NOT NULL COMMENT '当前ID',
    `deep` int NOT NULL COMMENT '深度',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'组织机构树结构关联';

/**
 * 平台
 */
drop table if EXISTS `sys_client`;
CREATE TABLE `sys_client` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name` varchar(20) NOT NULL COMMENT '平台名称',
    `code` varchar(20) NOT NULL COMMENT '平台标识',
    `client_secret` varchar(50) DEFAULT NULL COMMENT '密钥',
    `note` varchar(255) DEFAULT NULL COMMENT '备注',
    `enabled` varchar(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    `version` int DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'平台';

/**
 * 用户平台关联表
 */
drop table if EXISTS `sys_user_client_rel`;
CREATE TABLE `sys_user_client_rel` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id` varchar(32) NOT NULL COMMENT '用户id',
    `client_id` varchar(32) NOT NULL COMMENT '平台id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'用户平台关联表';


/**
 * 角色表
 */
drop table if EXISTS `sys_role`;
CREATE TABLE `sys_role` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name` varchar(20) NOT NULL COMMENT '角色名称',
    `code` varchar(20) NOT NULL COMMENT '角色标识',
    `scope` varchar(255) NOT NULL COMMENT '数据权限范围',
    `note` varchar(255) DEFAULT NULL COMMENT '备注',
    `enabled` varchar(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    `version` int NOT NULL DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'角色';

/**
 * 用户角色关联表
 */
DROP TABLE IF EXISTS `sys_user_role_rel`;
CREATE TABLE `sys_user_role_rel` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id` varchar(32) NOT NULL COMMENT '用户id',
    `role_id` varchar(32) NOT NULL COMMENT '角色id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'用户角色关联表';

/**
 * 菜单表
 */
drop table if EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `parent_id` int DEFAULT NULL COMMENT '上级id',
    `name` varchar(20) NOT NULL COMMENT '名称',
    `icon` varchar(20) DEFAULT NULL COMMENT '菜单图标',
    `path` varchar(100) DEFAULT NULL COMMENT '路由路径',
    `component` varchar(100) DEFAULT NULL COMMENT '组件路径',
    `target` char(1)  DEFAULT NULL COMMENT '页面布局类型,打开新窗口',
    `type` char(1) DEFAULT NULL COMMENT '类型：1 目录，2 菜单；3 按钮',
    `visible` char(1) DEFAULT NULL COMMENT '是否在菜单栏显示：1 显示 0 不显示',
    `keep_alive` char(1) DEFAULT NULL COMMENT '组件是否缓存: 1 缓存；0 不缓存',
    `permission` varchar(255) DEFAULT NULL COMMENT '权限标识',
    `note` varchar(255) DEFAULT NULL COMMENT '备注',
    `sort` int NOT NULL DEFAULT 1 COMMENT '排序',
    `enabled` varchar(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    `version` int NOT NULL DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'系统菜单';

/**
 * 角色菜单关联表
 */
DROP TABLE IF EXISTS `sys_role_menu_rel`;
CREATE TABLE `sys_role_menu_rel` (
   `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
   `role_id` varchar(32) NOT NULL COMMENT '角色id',
   `menu_id` varchar(32) NOT NULL COMMENT '菜单id',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'角色菜单关联表';

/**
 * 字典表
 */
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name` varchar(20) NOT NULL COMMENT '字典名称',
    `code` varchar(20) NOT NULL COMMENT '字典标识',
    `type` varchar(1) NOT NULL COMMENT '字典类型',
    `data_type` varchar(1) NOT NULL COMMENT '数据类型',
    `note` varchar(255) DEFAULT NULL COMMENT '备注',
    `enabled` varchar(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    `version` int NOT NULL DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'字典';

/**
 * 字典项
 */
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `dict_id` varchar(32) NOT NULL  COMMENT '字典id',
    `parent_id` varchar(32) DEFAULT NULL COMMENT '树结构时的上级id',
    `label` varchar(20) NOT NULL COMMENT '字典项名称',
    `value` varchar(20) NOT NULL COMMENT '字典项标识',
    `note` varchar(255) DEFAULT NULL COMMENT '备注',
    `sort` int NOT NULL COMMENT '排序',
    `enabled` varchar(1) NOT NULL DEFAULT '1' COMMENT '状态: 1 启用；0 禁用',
    `version` int NOT NULL DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'字典项';

/**
 * 配置项
 */
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name` varchar(20) NOT NULL  COMMENT '配置名称',
    `code` varchar(20) NOT NULL  COMMENT '配置标识',
    `config` json DEFAULT NULL COMMENT '配置项',
    `note` varchar(255) DEFAULT NULL COMMENT '备注',
    `version` int NOT NULL DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'字典项';

/**
 * 日志
 */
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
     `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
     `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
     `user_id` varchar(32) NOT NULL  COMMENT '用户id',
     `client_id` varchar(32) NOT NULL  COMMENT '用户id',
     `ip` varchar(30) NOT NULL COMMENT '字典项名称',
     `url` varchar(30) NOT NULL COMMENT '字典项标识',
     `comment` varchar(255) NOT NULL COMMENT '备注',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'字典项';




/**
    参数管理：对系统动态配置常用参数。 config
    通知公告：系统通知公告信息发布维护。 notice
    操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
    登录日志：系统登录日志记录查询包含登录异常。
    在线用户：当前系统中活跃用户状态监控
 */

/**
* 新闻
*/
drop table if EXISTS `biz_`;
CREATE TABLE `biz_comment` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id` varchar(32) COMMENT '用户id',
    `title` varchar(50)  NOT NULL COMMENT '标题',
    `description` varchar(255)  NOT NULL COMMENT '描述',
    `content` text NOT NULL COMMENT '内容',
    `cover` varchar(100) DEFAULT NULL COMMENT '封面',
    `catalog_id` varchar(32) DEFAULT NULL COMMENT '目录',
    `favourite_num` int COMMENT '点赞收藏数',
    `browse_num` int COMMENT '浏览数',
    `recommended` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否推荐: 1 是；0 否',
    `released_time` varchar(1) DEFAULT NULL COMMENT '发布时间',
    `released` varchar(1) NOT NULL DEFAULT '0' COMMENT '发布状态: 1 已发布；0 未发布',
    `type` varchar(1) NOT NULL DEFAULT '1' COMMENT '类型: 1 新闻；2 公告',
    `version` int NOT NULL DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'评论列表';

/**
* 留言
*/
drop table if EXISTS `biz_message`;
CREATE TABLE `biz_message` (
   `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
   `user_id` varchar(32) COMMENT '用户id',
   `title` varchar(50)  NOT NULL COMMENT '标题',
   `description` varchar(255)  NOT NULL COMMENT '描述',
   `content` text NOT NULL COMMENT '内容',
   `favourite_num` int COMMENT '点赞收藏数',
   `audit_status` varchar(1) NOT NULL DEFAULT '1' COMMENT '审核状态: 1 未提交；2 待审核, 3 审核通过, 4 审核未通过',
   `type` varchar(1) NOT NULL DEFAULT '1' COMMENT '类型: 1 话题， 2 留言',
   `version` int NOT NULL DEFAULT 0 COMMENT '乐观锁标识',
   `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
   `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
   `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
   `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
   `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'评论列表';

/**
 * 评论
 */
drop table if EXISTS `biz_comment`;
CREATE TABLE `biz_comment` (
    `id` varchar(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `biz_id` varchar(32)  COMMENT '评论业务的id',
    `user_id` varchar(32) COMMENT '评论用户id',
    `content` varchar(500) NOT NULL COMMENT '评论内容',
    `like_num` int COMMENT '点赞数 ',
    `parent_comment_id` varchar(32) COMMENT '父级评论id',
    `reply_comment_id` varchar(32) COMMENT '回复的评论id',
    `version` int NOT NULL DEFAULT 0 COMMENT '乐观锁标识',
    `created_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
    `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
    `deleted_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除状态: 1 已删；0 未删',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT'评论列表';