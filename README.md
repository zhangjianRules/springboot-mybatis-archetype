swagger接口
    http://127.0.0.1:10006/swagger-ui.html#/

    用户名：admin
    密码：admin

目前只写了简单demo
如若想看输出日志，本地需要增加配置：-DLOGBACK_CUSTOM_FILE=config/server.local.properties

新建数据库
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 |
