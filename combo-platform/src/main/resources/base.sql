
use `combo_project`;

drop table if EXISTS `s_user`;

CREATE TABLE `s_user` (
    `id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(20) NOT NULL,
    `password` varchar(32) NOT NULL,
    `email` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


drop table if EXISTS `s_menu`;
CREATE TABLE `s_menu` (
    `id` int NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;