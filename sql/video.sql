/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : video

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2021-04-20 19:04:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coin_history
-- ----------------------------
DROP TABLE IF EXISTS `coin_history`;
CREATE TABLE `coin_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coin_history
-- ----------------------------
INSERT INTO `coin_history` VALUES ('6', '1', '40', null, null);
INSERT INTO `coin_history` VALUES ('7', '7', '43', null, null);
INSERT INTO `coin_history` VALUES ('11', '1', '5', null, null);
INSERT INTO `coin_history` VALUES ('13', '1', '43', null, null);

-- ----------------------------
-- Table structure for databasechangelog
-- ----------------------------
DROP TABLE IF EXISTS `databasechangelog`;
CREATE TABLE `databasechangelog` (
  `ID` varchar(63) NOT NULL,
  `AUTHOR` varchar(63) NOT NULL,
  `FILENAME` varchar(200) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `MD5SUM` varchar(32) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`,`AUTHOR`,`FILENAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of databasechangelog
-- ----------------------------
INSERT INTO `databasechangelog` VALUES ('20210123-1922', 'xiangzhimin', 'classpath:db.changelog-1.0.xml', '2021-04-15 17:00:17', '684f8a532f971479caba3913fd5a89fe', 'Create Table', '添加收藏表', null, '1.9.1');
INSERT INTO `databasechangelog` VALUES ('20210123-1923', 'xiangzhimin', 'classpath:db.changelog-1.0.xml', '2021-04-15 17:00:17', 'd11eef57788d3faee1e1af02c928c8', 'Create Table', '添加投币表', null, '1.9.1');
INSERT INTO `databasechangelog` VALUES ('20210123-1925', 'xiangzhimin', 'classpath:db.changelog-1.0.xml', '2021-04-15 17:00:17', '3a06ddbf23b579240c73bb540e2c1f2', 'Create Table', '添加点赞表', null, '1.9.1');
INSERT INTO `databasechangelog` VALUES ('20210415-1533', 'xiangzhimin', 'classpath:db.changelog-1.0.xml', '2021-04-15 17:00:18', 'b414f8777abf9cc98318557a691b8ed', 'Add Column', '用户表添加关注数量', null, '1.9.1');
INSERT INTO `databasechangelog` VALUES ('20210417-1920', 'xiangzhimin', 'classpath:db.changelog-1.0.xml', '2021-04-17 19:27:53', '1d6d843669927ec7decfe4461ad58ef', 'Add Column', '视频表添加视频状态', null, '1.9.1');
INSERT INTO `databasechangelog` VALUES ('20210418-1523', 'xiangzhimin', 'classpath:db.changelog-1.0.xml', '2021-04-18 15:45:17', '963749f09dc6ab55373241a8b147903d', 'Add Column', '弹幕添加状态', null, '1.9.1');
INSERT INTO `databasechangelog` VALUES ('20210418-1524', 'xiangzhimin', 'classpath:db.changelog-1.0.xml', '2021-04-18 15:45:17', '4ee6eed7ce3ebf8d725e96f284628c34', 'Add Column', '评论添加状态', null, '1.9.1');

-- ----------------------------
-- Table structure for databasechangeloglock
-- ----------------------------
DROP TABLE IF EXISTS `databasechangeloglock`;
CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` tinyint(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of databasechangeloglock
-- ----------------------------
INSERT INTO `databasechangeloglock` VALUES ('1', '0', null, null);

-- ----------------------------
-- Table structure for like_history
-- ----------------------------
DROP TABLE IF EXISTS `like_history`;
CREATE TABLE `like_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of like_history
-- ----------------------------
INSERT INTO `like_history` VALUES ('2', '1', '14', null);
INSERT INTO `like_history` VALUES ('5', '1', '40', null);
INSERT INTO `like_history` VALUES ('6', '7', '43', null);
INSERT INTO `like_history` VALUES ('7', '1', '43', null);
INSERT INTO `like_history` VALUES ('8', '1', '52', null);
INSERT INTO `like_history` VALUES ('9', '1', '53', null);

-- ----------------------------
-- Table structure for t_attention
-- ----------------------------
DROP TABLE IF EXISTS `t_attention`;
CREATE TABLE `t_attention` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `atten_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `atten_userid` (`atten_userid`),
  CONSTRAINT `t_attention_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_attention_ibfk_2` FOREIGN KEY (`atten_userid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_attention
-- ----------------------------
INSERT INTO `t_attention` VALUES ('33', '1', '6');
INSERT INTO `t_attention` VALUES ('35', '1', '8');
INSERT INTO `t_attention` VALUES ('36', '1', '9');
INSERT INTO `t_attention` VALUES ('37', '1', '10');
INSERT INTO `t_attention` VALUES ('38', '1', '11');
INSERT INTO `t_attention` VALUES ('40', '1', '13');
INSERT INTO `t_attention` VALUES ('41', '13', '1');
INSERT INTO `t_attention` VALUES ('42', '12', '1');
INSERT INTO `t_attention` VALUES ('43', '11', '1');

-- ----------------------------
-- Table structure for t_barrage
-- ----------------------------
DROP TABLE IF EXISTS `t_barrage`;
CREATE TABLE `t_barrage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `createTime` datetime DEFAULT NULL COMMENT '评论时间',
  `video_id` int(11) DEFAULT NULL COMMENT 'video的id',
  `time` varchar(20) DEFAULT NULL COMMENT '视频时间',
  `author` int(11) DEFAULT NULL,
  `color` int(11) DEFAULT '0',
  `type` int(11) DEFAULT NULL,
  `status` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `video_id` (`video_id`),
  KEY `author` (`author`),
  CONSTRAINT `t_barrage_ibfk_1` FOREIGN KEY (`video_id`) REFERENCES `t_video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_barrage
-- ----------------------------
INSERT INTO `t_barrage` VALUES ('1', '上部', '2020-11-03 21:22:00', '1', '0', '1', '15024726', '0', '1');
INSERT INTO `t_barrage` VALUES ('2', '中部', '2020-11-03 21:22:00', '1', '0', '1', '15024726', '1', '1');
INSERT INTO `t_barrage` VALUES ('3', '下部', '2020-11-03 21:22:00', '1', '0', '1', '16777215', '2', '1');
INSERT INTO `t_barrage` VALUES ('4', '我发的第二个弹幕，张杰帅气，厉害，我爱你！！！，张哥', '2020-11-03 21:22:00', '1', '2.1', '1', '16777215', '1', '1');
INSERT INTO `t_barrage` VALUES ('5', '我发的第一个弹幕', '2020-11-04 11:33:43', '1', '2.851507', '1', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('6', '123', '2020-11-04 11:30:42', '1', '7.973978', '2', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('7', '234', '2020-11-04 11:31:52', '1', '0', '2', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('8', '123', '2020-11-04 11:32:33', '3', '4.71035', '1', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('9', '向志敏到此一游', '2020-11-04 11:33:05', '3', '28.021276', '1', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('11', '23', '2021-01-26 15:21:48', '25', '0', '2', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('12', '1234', '2021-01-26 15:23:51', '42', '0', '2', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('14', '张同学', '2021-01-28 15:54:33', '43', '257.79472', '2', '15024726', '0', '1');
INSERT INTO `t_barrage` VALUES ('15', '加油', '2021-04-14 11:56:59', '1', '36.6205', '2', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('16', '加油', '2021-04-14 12:09:17', '5', '49.070169', '2', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('17', '123', '2021-04-14 15:06:42', '5', '106.19691', '2', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('18', '3434', '2021-04-15 16:31:02', '40', '0', '5', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('19', '抛弃江山如花，还他天下', '2021-04-15 22:19:40', '5', '100.235502', '2', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('20', '123', '2021-04-17 20:21:14', '13', '6.555336', '1', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('21', '678', '2021-04-18 14:42:43', '53', '0', '1', '15024726', '0', '0');
INSERT INTO `t_barrage` VALUES ('22', '123', '2021-04-18 15:45:29', '53', '0', '1', '16777215', '0', '0');
INSERT INTO `t_barrage` VALUES ('23', '顶部', '2021-04-18 16:02:58', '1', '3.858017', '2', '16777215', '1', '1');
INSERT INTO `t_barrage` VALUES ('24', '滚动', '2021-04-18 16:03:10', '1', '3.858017', '2', '16777215', '0', '1');
INSERT INTO `t_barrage` VALUES ('25', '底部', '2021-04-18 16:03:20', '1', '3.858017', '2', '16777215', '2', '0');
INSERT INTO `t_barrage` VALUES ('26', '123', '2021-04-18 17:01:41', '53', '4.874942', '1', '16777215', '0', '0');
INSERT INTO `t_barrage` VALUES ('27', '测试弹幕', '2021-04-20 18:45:55', '53', '2.548691', '1', '16777215', '0', '0');
INSERT INTO `t_barrage` VALUES ('28', '顶部弹幕', '2021-04-20 18:46:09', '53', '2.548691', '1', '15024726', '1', '0');
INSERT INTO `t_barrage` VALUES ('29', '底部弹幕', '2021-04-20 18:46:26', '53', '2.548691', '1', '6610199', '2', '0');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_id` int(11) DEFAULT NULL COMMENT 'video的id',
  `user_id` int(11) DEFAULT NULL COMMENT '评论者id',
  `create_time` datetime DEFAULT NULL COMMENT '评论时间',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `status` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_comment_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `t_video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '1', '1', '2020-11-04 14:45:06', '张杰，我永远的男神343434', '1');
INSERT INTO `t_comment` VALUES ('3', '1', '5', '2020-11-04 18:34:52', 'qwe', '1');
INSERT INTO `t_comment` VALUES ('10', '1', '5', '2020-11-04 19:31:50', '123', '1');
INSERT INTO `t_comment` VALUES ('11', '1', '2', '2020-11-08 23:15:40', '4343434343434', '1');
INSERT INTO `t_comment` VALUES ('12', '1', '2', '2020-11-09 16:10:37', '向志敏，加油', '1');
INSERT INTO `t_comment` VALUES ('13', '42', '2', '2021-01-28 10:01:32', '123', '1');
INSERT INTO `t_comment` VALUES ('14', '42', '2', '2021-01-28 10:03:16', '123', '1');
INSERT INTO `t_comment` VALUES ('15', '42', '2', '2021-01-28 10:16:49', '123', '1');
INSERT INTO `t_comment` VALUES ('16', '42', '2', '2021-01-28 10:17:35', '123', '1');
INSERT INTO `t_comment` VALUES ('17', '42', '2', '2021-01-28 10:19:50', '123', '1');
INSERT INTO `t_comment` VALUES ('18', '42', '2', '2021-01-28 10:20:45', '123', '1');
INSERT INTO `t_comment` VALUES ('19', '42', '2', '2021-01-28 10:20:50', 'xzm', '1');
INSERT INTO `t_comment` VALUES ('20', '42', '2', '2021-01-28 10:21:11', 'xzm', '1');
INSERT INTO `t_comment` VALUES ('21', '42', '2', '2021-01-28 10:29:07', 'wer', '1');
INSERT INTO `t_comment` VALUES ('23', '42', '2', '2021-01-28 10:31:06', '123', '1');
INSERT INTO `t_comment` VALUES ('59', '40', '1', '2021-04-15 16:30:35', '234', '1');
INSERT INTO `t_comment` VALUES ('60', '40', '1', '2021-04-15 16:31:33', '234', '1');
INSERT INTO `t_comment` VALUES ('62', '53', '1', '2021-04-18 23:20:11', '你是说', '0');

-- ----------------------------
-- Table structure for t_favorite
-- ----------------------------
DROP TABLE IF EXISTS `t_favorite`;
CREATE TABLE `t_favorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_favorite
-- ----------------------------
INSERT INTO `t_favorite` VALUES ('23', '1', '42', '2021-04-15 13:18:28');
INSERT INTO `t_favorite` VALUES ('24', '1', '40', '2021-04-15 13:18:33');
INSERT INTO `t_favorite` VALUES ('25', '1', '14', '2021-04-15 13:19:05');
INSERT INTO `t_favorite` VALUES ('27', '7', '43', '2021-04-15 17:02:26');
INSERT INTO `t_favorite` VALUES ('29', '1', '5', '2021-04-15 17:41:11');
INSERT INTO `t_favorite` VALUES ('30', '8', '14', '2021-04-15 21:34:43');
INSERT INTO `t_favorite` VALUES ('31', '1', '1', '2021-04-15 22:37:46');
INSERT INTO `t_favorite` VALUES ('32', '1', '52', '2021-04-16 20:24:12');
INSERT INTO `t_favorite` VALUES ('33', '1', '53', '2021-04-18 23:19:40');
INSERT INTO `t_favorite` VALUES ('34', '1', '18', '2021-04-19 19:51:08');
INSERT INTO `t_favorite` VALUES ('35', '1', '22', '2021-04-19 19:51:10');
INSERT INTO `t_favorite` VALUES ('36', '1', '24', '2021-04-19 19:51:13');
INSERT INTO `t_favorite` VALUES ('37', '1', '19', '2021-04-19 19:51:16');

-- ----------------------------
-- Table structure for t_history
-- ----------------------------
DROP TABLE IF EXISTS `t_history`;
CREATE TABLE `t_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `t_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_history_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `t_video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=321 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_history
-- ----------------------------
INSERT INTO `t_history` VALUES ('9', '1', '10', '2021-04-14 16:55:25');
INSERT INTO `t_history` VALUES ('15', '1', '17', '2021-04-14 16:57:48');
INSERT INTO `t_history` VALUES ('16', '1', '21', '2021-04-14 16:57:52');
INSERT INTO `t_history` VALUES ('17', '1', '41', '2021-04-14 16:57:54');
INSERT INTO `t_history` VALUES ('20', '1', '27', '2021-04-14 17:00:25');
INSERT INTO `t_history` VALUES ('47', '1', '2', '2021-04-14 23:20:58');
INSERT INTO `t_history` VALUES ('50', '1', '23', '2021-04-14 23:21:25');
INSERT INTO `t_history` VALUES ('57', '1', '25', '2021-04-14 23:24:01');
INSERT INTO `t_history` VALUES ('70', '1', '9', '2021-04-14 23:40:54');
INSERT INTO `t_history` VALUES ('111', '1', '8', '2021-04-15 13:40:29');
INSERT INTO `t_history` VALUES ('186', '1', '42', '2021-04-15 15:33:11');
INSERT INTO `t_history` VALUES ('229', '1', '43', '2021-04-15 21:58:52');
INSERT INTO `t_history` VALUES ('234', '1', '44', '2021-04-15 22:13:30');
INSERT INTO `t_history` VALUES ('255', '1', '40', '2021-04-15 22:37:38');
INSERT INTO `t_history` VALUES ('263', '1', '5', '2021-04-15 22:45:09');
INSERT INTO `t_history` VALUES ('265', '1', '45', '2021-04-16 19:33:39');
INSERT INTO `t_history` VALUES ('266', '1', '52', '2021-04-16 20:24:01');
INSERT INTO `t_history` VALUES ('271', '1', '1', '2021-04-18 16:03:29');
INSERT INTO `t_history` VALUES ('272', '1', '15', '2021-04-18 16:37:01');
INSERT INTO `t_history` VALUES ('303', '1', '24', '2021-04-19 19:51:12');
INSERT INTO `t_history` VALUES ('304', '1', '19', '2021-04-19 19:51:14');
INSERT INTO `t_history` VALUES ('305', '1', '22', '2021-04-19 19:51:17');
INSERT INTO `t_history` VALUES ('306', '1', '18', '2021-04-19 19:51:18');
INSERT INTO `t_history` VALUES ('307', '1', '14', '2021-04-19 19:51:19');
INSERT INTO `t_history` VALUES ('309', '1', '4', '2021-04-19 20:35:38');
INSERT INTO `t_history` VALUES ('314', '1', '51', '2021-04-20 10:14:22');
INSERT INTO `t_history` VALUES ('320', '1', '53', '2021-04-20 18:44:32');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `video_id` int(11) DEFAULT NULL COMMENT 'video的id',
  PRIMARY KEY (`id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `t_tag_ibfk_1` FOREIGN KEY (`video_id`) REFERENCES `t_video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES ('1', '123', '42');
INSERT INTO `t_tag` VALUES ('2', '123', '42');
INSERT INTO `t_tag` VALUES ('3', '456', '42');
INSERT INTO `t_tag` VALUES ('4', '操作系统', '42');
INSERT INTO `t_tag` VALUES ('5', '操作系统', '1');
INSERT INTO `t_tag` VALUES ('6', '张鑫源', '1');
INSERT INTO `t_tag` VALUES ('22', '2344', '1');
INSERT INTO `t_tag` VALUES ('23', '344', '1');
INSERT INTO `t_tag` VALUES ('24', '454', '1');
INSERT INTO `t_tag` VALUES ('25', '234', '1');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES ('1', '动画');
INSERT INTO `t_type` VALUES ('2', '游戏');
INSERT INTO `t_type` VALUES ('3', '番剧');
INSERT INTO `t_type` VALUES ('4', '教育');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL COMMENT '描述',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nickname` varchar(255) NOT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime NOT NULL COMMENT '注册时间',
  `coinnum` int(11) NOT NULL DEFAULT '0' COMMENT '硬币数',
  `role` varchar(255) NOT NULL DEFAULT '' COMMENT '类型,admin',
  `attention_num` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '搞笑，我们是认真的1。', '928bfd2577490322a6e19b793691467e', 'CSerxzm', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '0', 'admin', '0');
INSERT INTO `t_user` VALUES ('2', 'root1', '搞笑1，我们是认真的。', '7d08316bde2d5e97d827bd07b90551b7', '大蝈蝈', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '1', 'user', '1');
INSERT INTO `t_user` VALUES ('3', 'admin2', '搞笑，我们是认真的。', '1a3d9d44bdee370767c112857a45a984', 'CSerxzm', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '0', 'admin', '0');
INSERT INTO `t_user` VALUES ('4', 'root3', '搞笑1，我们是认真的。', '7d08316bde2d5e97d827bd07b90551b7', '大蝈蝈', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '1', 'user', '1');
INSERT INTO `t_user` VALUES ('5', 'root14', '大家好，我是帅气的团队，我们进驻B站20年，只为逗你开心！', '597245c832afcbe5db4d84772e58fd48', '帅气的一号种子选手', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-10-30 13:42:50', '0', 'admin', '-1');
INSERT INTO `t_user` VALUES ('6', 'xzm', 'xzm:password', '1cac138c89a1066bcc6ecb1d3c1c1ccf', '测试用号', 'http://localhost:8080/head/20210418124529656.jpg', '2021-04-18 12:45:32', '0', 'user', '0');
INSERT INTO `t_user` VALUES ('7', 'root15', '大家好，我是帅气的团队，我们进驻B站20年，只为逗你开心！', '597245c832afcbe5db4d84772e58fd48', '帅气的一号种子选手', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-10-30 13:42:50', '0', 'admin', '-1');
INSERT INTO `t_user` VALUES ('8', 'admin6', '搞笑，我们是认真的。', '1a3d9d44bdee370767c112857a45a984', 'CSerxzm', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '0', 'admin', '1');
INSERT INTO `t_user` VALUES ('9', 'root7', '搞笑1，我们是认真的。', '7d08316bde2d5e97d827bd07b90551b7', '大蝈蝈', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '1', 'admin', '2');
INSERT INTO `t_user` VALUES ('10', 'admin8', '搞笑，我们是认真的。', '1a3d9d44bdee370767c112857a45a984', 'CSerxzm', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '0', 'admin', '1');
INSERT INTO `t_user` VALUES ('11', 'root9', '搞笑1，我们是认真的。', '7d08316bde2d5e97d827bd07b90551b7', '大蝈蝈', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '1', 'user', '2');
INSERT INTO `t_user` VALUES ('12', 'root10', '大家好，我是帅气的团队，我们进驻B站20年，只为逗你开心！', '597245c832afcbe5db4d84772e58fd48', '帅气的一号种子选手', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-10-30 13:42:50', '0', 'admin', '-1');
INSERT INTO `t_user` VALUES ('13', 'xzm11', 'xzm:password', '1cac138c89a1066bcc6ecb1d3c1c1ccf', '测试用号', 'http://localhost:8080/head/20210418124529656.jpg', '2021-04-18 12:45:32', '0', 'user', '0');
INSERT INTO `t_user` VALUES ('14', 'root12', '大家好，我是帅气的团队，我们进驻B站20年，只为逗你开心！', '597245c832afcbe5db4d84772e58fd48', '帅气的一号种子选手', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-10-30 13:42:50', '0', 'admin', '0');

-- ----------------------------
-- Table structure for t_video
-- ----------------------------
DROP TABLE IF EXISTS `t_video`;
CREATE TABLE `t_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `user_id` int(11) DEFAULT NULL COMMENT '发布者id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `video_url` varchar(255) DEFAULT NULL COMMENT '视频url',
  `viewnum` int(11) DEFAULT '0' COMMENT '播放量',
  `barrnum` int(11) DEFAULT '0' COMMENT '弹幕数',
  `starnum` int(11) DEFAULT '0' COMMENT '收藏量',
  `coinnum` int(11) DEFAULT '0' COMMENT '硬币数',
  `likenum` int(11) DEFAULT '0' COMMENT '点赞数',
  `trannum` int(11) DEFAULT '0' COMMENT '转发数',
  `type_id` int(11) DEFAULT NULL COMMENT '类型id',
  `picture_url` varchar(255) DEFAULT NULL,
  `status` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_video_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_video_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_video
-- ----------------------------
INSERT INTO `t_video` VALUES ('1', '1希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '7916', '5', '125', '2', '24', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('2', '2希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '10', '1', '23', '1', '23', '1', '2', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('3', '3希望喜欢', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '12', '1', '25', '3', '3', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('4', '4希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '10', '1', '12', '1', '324', '1', '4', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('5', '5希望喜欢Gal', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '5710', '4', '3', '3', '1', '1', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('6', '6希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '774', '1', '2', '1', '45', '1', '2', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('7', '7希望喜欢', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '32', '1', '12', '1', '56', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('8', '8希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '14', '1', '12', '1', '6', '1', '4', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('9', '9希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '900', '1', '13', '5', '7', '1', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('10', '10希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '5', '1', '121', '1', '687', '1', '2', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('11', '11希望喜欢Gal的你', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '555', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('12', '12希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '5', '1', '1', '1', '8', '1', '4', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('13', '13希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '25', '2', '1', '1', '8', '1', '1', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('14', '1希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '7910', '1', '125', '2', '25', '1', '1', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('15', '2希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '3', '1', '23', '1', '23', '1', '2', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('16', '3希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '3', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('17', '4希望喜欢Gal的', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '5', '1', '12', '1', '324', '1', '4', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('18', '5希望喜欢Gal的你', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '5663', '1', '2', '1', '1', '1', '1', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('19', '6希望喜欢Gal的', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '792', '1', '3', '1', '45', '1', '2', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('20', '7希望喜欢Gal的你', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '32', '1', '12', '1', '56', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('21', '8希望喜欢Gal的你', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '4', '1', '12', '1', '6', '1', '4', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('22', '9希望喜欢Gal的你能被推', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '892', '1', '13', '1', '7', '1', '1', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('23', '10希望喜欢Gal的你能', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '6', '1', '122', '1', '687', '1', '2', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('24', '11希望喜欢Gal的你能被推送到这个视频34特委托贵司订购三国时代', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '557', '1', '24', '1', '1', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('25', '12希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '18', '1', '2', '1', '8', '1', '4', 'http://localhost:8080/file/20210415220907016.png', '1');
INSERT INTO `t_video` VALUES ('26', '13希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '23', '1', '1', '1', '8', '1', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('27', '11希望喜欢Gal的你能被推', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '556', '1', '25', '1', '1', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('28', '11希望喜欢Gal的你能被推送到这个视频34特委托贵', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '571', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('29', '11希望喜欢Gal的你能被推送到这个视频34特委托贵司订购三国时代三个是德国', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20210415220904160.mp4', '557', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('34', '向志敏', '5', '                        我的低于分实时发VS大苏打v', '2020-11-03 11:43:40', 'http://localhost:8080/file/20210415220904160.mp4', '1', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('35', '向志敏', '5', '                        我的低于分实时发VS大苏打v', '2020-11-03 11:43:40', 'http://localhost:8080/file/20210415220904160.mp4', '0', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('36', '向志敏', '5', '                        我的低于分实时发VS大苏打v', '2020-11-03 11:43:40', 'http://localhost:8080/file/20210415220904160.mp4', '0', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('37', '就梦一场痘印版', '5', '                士大夫士大夫不是举报所发生的士大夫速度岁的法国速度        ', '2020-11-03 12:23:04', 'http://localhost:8080/file/20210415220904160.mp4', '12', '0', '2', '2', '12', '0', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('40', 'Linux C学习笔记', '5', '                        rfghdfh', '2020-11-04 12:44:46', 'http://localhost:8080/file/20210415220904160.mp4', '104', '8', '79', '10', '69', '0', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('41', '旧梦一场', '2', '         这是我的第一个挖矿教程在内存中可惜处置可变现操作现场秩序处女座空间相册在程序执行操作系操作系查找先充值那些成本支出自行车资讯科技创造课程那种恐惧参考价值常州科教城做库存状况c               ', '2020-11-09 16:12:35', 'http://localhost:8080/file/20210415220904160.mp4', '5', '0', '0', '0', '0', '0', '4', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('42', '操作系统学习视频', '2', '1234', '2021-01-26 13:50:19', 'http://localhost:8080/file/20210415220904160.mp4', '117', '1', '3', '2', '2', '0', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('43', '实验1的全过程', '2', '                    这首歌送给你    ', '2021-01-28 15:53:30', 'http://localhost:8080/file/20210415220904160.mp4', '259', '1', '6', '16', '16', '0', '1', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('44', '节个的天下', '1', '                   加油,节个的天下     ', '2021-04-15 22:09:38', 'http://localhost:8080/file/20210415220904160.mp4', '2', '0', '0', '0', '0', '0', '2', 'http://localhost:8080/file/20210415220907016.png', '0');
INSERT INTO `t_video` VALUES ('45', '林俊杰-爱不会绝迹', '1', '             加油           ', '2021-04-15 23:12:06', 'http://localhost:8080/file/20210415231127019.mp4', '2', '0', '0', '0', '0', '0', '2', 'http://localhost:8080/file/20210415231129827.png', '0');
INSERT INTO `t_video` VALUES ('47', 'Linux C学习笔记', '1', '                     234   ', '2021-04-16 19:51:28', 'http://localhost:8080/file/20210416195110929.mp4', '0', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20210416195114902.png', '0');
INSERT INTO `t_video` VALUES ('48', 'Linux C学习笔记', '1', '                     为人   ', '2021-04-16 19:54:37', 'http://localhost:8080/file/20210416195426151.mp4', '0', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20210416195429348.png', '0');
INSERT INTO `t_video` VALUES ('51', 'Linux C学习笔记', '1', '345', '2021-04-16 20:15:26', 'http://localhost:8080/file/20210416201510033.mp4', '4', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20210416201514055.png', '1');
INSERT INTO `t_video` VALUES ('52', 'sdsd', '1', 'sdsd', '2021-04-16 20:23:56', 'http://localhost:8080/file/20210416202347121.mp4', '4', '0', '1', '0', '1', '0', '1', 'http://localhost:8080/file/20210416202350714.png', '1');
INSERT INTO `t_video` VALUES ('53', 'Linux C学习笔记Linux C学习笔记Linux C学习笔记Linux C学习笔记Linux C学习笔记Linux C学习笔记Linux C学习笔记', '1', '232', '2021-04-16 20:44:11', 'http://localhost:8080/file/20210416204358966.mp4', '88', '6', '1', '0', '1', '0', '1', 'http://localhost:8080/file/20210416204402480.png', '1');
