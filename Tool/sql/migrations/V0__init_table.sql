/*
MariaDB Data Transfer

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
CREATE TABLE blog_loan (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` varchar(50) NOT NULL COMMENT '唯一主键',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  `update_time` int(11) DEFAULT NULL COMMENT '更新时间',
  `user_gid` varchar(50) NOT NULL COMMENT '用户gid',
  `channel_gid` varchar(50) NOT NULL COMMENT '分类gid',
  `mark_gid` varchar(50) NOT NULL COMMENT '标签gid',
  `name` varchar(50) DEFAULT NULL COMMENT '标题',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '博客类型 0:原创; 1:转载; 2:翻译;',
  `views` int(11) NOT NULL DEFAULT '0' COMMENT '查看次数',
  `is_top` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否置顶',
  `content` longtext COMMENT '内容',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客';

CREATE TABLE blog_channel (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` varchar(50) NOT NULL COMMENT '唯一主键',
  `super_gid` varchar(50) NOT NULL COMMENT '父级gid',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  `update_time` int(11) DEFAULT NULL COMMENT '更新时间',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `is_valid` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `order_num` double DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='博客分类';

CREATE TABLE blog_mark (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` varchar(50) NOT NULL COMMENT '唯一主键',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  `update_time` int(11) DEFAULT NULL COMMENT '更新时间',
  `name` varchar(50) DEFAULT NULL COMMENT '标签',
  `decription` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客标签';

CREATE TABLE user_base (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` varchar(50) NOT NULL COMMENT '唯一',
  `create_time` int(11) DEFAULT NULL COMMENT '创建日期',
  `update_time` int(11) DEFAULT NULL COMMENT '更新日期',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `bolg_address` varchar(100) DEFAULT NULL COMMENT '连接地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE config_blog_mark (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` varchar(50) NOT NULL COMMENT '唯一主键',
  `blog_gid` varchar(50) NOT NULL COMMENT '博客id',
  `mark_gid` varchar(50) NOT NULL COMMENT '标签id',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  `update_time` int(11) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='blog mark多对多关联表';