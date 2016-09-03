BEGIN;
  CREATE TABLE friendly_link (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `gid` varchar(50) NOT NULL COMMENT '唯一主键',
    `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
    `update_time` int(11) DEFAULT NULL COMMENT '更新时间',
    `name` varchar(50) DEFAULT NULL COMMENT '链接名称',
    `href` varchar(50) DEFAULT NULL COMMENT '链接地址',
    PRIMARY KEY (`id`),
    UNIQUE KEY `gid` (`gid`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='友情链接';
COMMIT;