/*
Navicat MariaDB Data Transfer

Source Server         : local
Source Server Version : 50544
Source Host           : 127.0.0.1:3306
Source Database       : core

Target Server Type    : MariaDB
Target Server Version : 50544
File Encoding         : 65001

Date: 2015-11-24 17:36:35
*/

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` VARCHAR(50) NOT NULL COMMENT '唯一',
  `create_time` int(11) DEFAULT NULL COMMENT '创建日期',
  `update_time` int(11) DEFAULT NULL COMMENT '更新日期',
  `nick_name` VARCHAR(100) DEFAULT NULL COMMENT '姓名',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `bolg_address` VARCHAR(100) DEFAULT NULL COMMENT '连接地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` VARCHAR(100) NOT NULL COMMENT '唯一主键',
  `user_gid` VARCHAR(100) NOT NULL COMMENT '外键，人员表',
  `blog_gid` VARCHAR(100) NOT NULL COMMENT '外键，博客表',
  `create_time` int(11) DEFAULT NULL COMMENT '创建日期',
  `update_time` int(11) DEFAULT NULL COMMENT '更新日期',
  `message` VARCHAR(3000) DEFAULT NULL COMMENT '评论详情',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`),
  UNIQUE KEY `user_gid` (`user_gid`),
  UNIQUE KEY `blog_gid` (`blog_gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论详情表';

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` VARCHAR(50) NOT NULL COMMENT '唯一主键',
  `user_gid` VARCHAR(50) NOT NULL COMMENT '用户id',
  `menu_gid` VARCHAR(50) NOT NULL COMMENT '所属菜单',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  `update_time` int(11) DEFAULT NULL COMMENT '更新时间',
  `blog_title` VARCHAR(50) DEFAULT NULL COMMENT '博文标题',
  `blog_content` LONGTEXT DEFAULT NULL COMMENT '博文内容',
  `views` int(11) NOT NULL DEFAULT 0 COMMENT '查看次数',
  `is_top` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '是否置顶',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博文Table';

-- ----------------------------
-- Table structure for config_blog_label
-- ----------------------------
DROP TABLE IF EXISTS `config_blog_label`;
CREATE TABLE `config_blog_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` VARCHAR(50) NOT NULL COMMENT '唯一主键',
  `blog_gid` VARCHAR(50) NOT NULL COMMENT '博客id',
  `label_gid` VARCHAR(50) NOT NULL COMMENT '标签id',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  `update_time` int(11) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='blog label多对多关联表';

-- ----------------------------
-- Table structure for tag_label
-- ----------------------------
DROP TABLE IF EXISTS `tag_label`;
CREATE TABLE `tag_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` VARCHAR(50) NOT NULL COMMENT '唯一主键',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  `update_time` int(11) DEFAULT NULL COMMENT '更新时间',
  `label_name` VARCHAR(50) DEFAULT NULL COMMENT '标签内容',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签Table';

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` VARCHAR(50) NOT NULL COMMENT '唯一主键',
  `super_gid` VARCHAR(50) NOT NULL COMMENT '父级gid',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  `update_time` int(11) DEFAULT NULL COMMENT '更新时间',
  `blog_type_name` VARCHAR(50) DEFAULT NULL COMMENT 'blog类别',
  `order_num` DOUBLE DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='blog类别Table';