CREATE TABLE `login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute1` varchar(20) DEFAULT NULL,
  `attribute2` varchar(20) DEFAULT NULL,
  `attribute3` varchar(20) DEFAULT NULL,
  `attribute4` varchar(20) DEFAULT NULL,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101267 DEFAULT CHARSET=utf8;
