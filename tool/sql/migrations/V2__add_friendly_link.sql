BEGIN;
  CREATE TABLE friendship_link(
    id INT(11) NOT NULL AUTO_INCREMENT,
    gid VARCHAR(50) NOT NULL COMMENT '唯一主键',
    create_time INT(11) COMMENT '创建时间',
    update_time INT(11) COMMENT '更新时间',
    user_gid VARCHAR(50) DEFAULT NULL COMMENT '用户gid',
    name VARCHAR(50) NOT NULL COMMENT '链接名称',
    url VARCHAR(50) NOT NULL COMMENT '链接地址',
    description VARCHAR(50) COMMENT '描述',
    is_vaild bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效 0无效  1有效',
    views INT(11) DEFAULT '0' NOT NULL COMMENT '点击次数',
    PRIMARY KEY (`id`),
    UNIQUE KEY `gid` (`gid`) USING BTREE
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='友情链接记录表';
COMMIT;