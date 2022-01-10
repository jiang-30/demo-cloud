
CREATE DATABASE IF NOT EXISTS `accretion_salute_flag` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `accretion_salute_flag`;

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
    `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
    `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '最后修改时间',
    `is_del` char(1) NOT NULL DEFAULT '1' COMMENT '逻辑删除标识：1 未删除，2 已删除',
    `host` varchar(15) DEFAULT NULL COMMENT '请求ip地址',
    `address` varchar(200) NOT NULL COMMENT '学生地址',
    `school` varchar(30) NOT NULL COMMENT '学校名称',
    `username` varchar(20) NOT NULL COMMENT '学生名字' ,
    `content` varchar(1000) NOT NULL COMMENT '留言内容',
    PRIMARY KEY (`id`),
    CONSTRAINT `chk_message_is_del` CHECK (`is_del`='1' or `is_del`='0')
) ENGINE = innodb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '学生留言表';

DROP TABLE IF EXISTS `salute`;
CREATE TABLE `salute` (
     `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
     `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
     `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '最后修改时间',
     `is_del` char(1) NOT NULL DEFAULT '1' COMMENT '逻辑删除标识：1 未删除，2 已删除',
     `host` varchar(15) DEFAULT NULL COMMENT '请求ip地址',
     PRIMARY KEY (`id`),
     CONSTRAINT `chk_salute_is_del` CHECK (`is_del`='1' or `is_del`='0')
) ENGINE = innodb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '学生点赞表';