/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : video

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2021-01-23 16:25:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_attention
-- ----------------------------
DROP TABLE IF EXISTS `t_attention`;
CREATE TABLE `t_attention` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `atten_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `atten_userid` (`atten_userid`),
  CONSTRAINT `t_attention_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_attention_ibfk_2` FOREIGN KEY (`atten_userid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_attention
-- ----------------------------

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
  PRIMARY KEY (`id`),
  KEY `video_id` (`video_id`),
  KEY `author` (`author`),
  CONSTRAINT `t_barrage_ibfk_1` FOREIGN KEY (`video_id`) REFERENCES `t_video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_barrage
-- ----------------------------
INSERT INTO `t_barrage` VALUES ('1', 'hello world，弹幕1', '2020-11-03 21:22:00', '1', '1.777', '1', '15024726', '0');
INSERT INTO `t_barrage` VALUES ('2', 'hello world', '2020-11-03 21:22:00', '1', '3.54', '1', '15024726', '1');
INSERT INTO `t_barrage` VALUES ('3', 'hello world3', '2020-11-03 21:22:00', '1', '0', '1', '16777215', '0');
INSERT INTO `t_barrage` VALUES ('4', '我发的第二个弹幕，张杰帅气，厉害，我爱你！！！，张哥', '2020-11-03 21:22:00', '1', '2.1', '1', '16777215', '1');
INSERT INTO `t_barrage` VALUES ('5', '我发的第一个弹幕', '2020-11-04 11:33:43', '1', '2.851507', '1', '16777215', '0');
INSERT INTO `t_barrage` VALUES ('6', '123', '2020-11-04 11:30:42', '1', '7.973978', '2', '16777215', '0');
INSERT INTO `t_barrage` VALUES ('7', '234', '2020-11-04 11:31:52', '1', '0', '2', '16777215', '0');
INSERT INTO `t_barrage` VALUES ('8', '123', '2020-11-04 11:32:33', '3', '4.71035', '1', '16777215', '0');
INSERT INTO `t_barrage` VALUES ('9', '向志敏到此一游', '2020-11-04 11:33:05', '3', '28.021276', '1', '16777215', '0');

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
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_comment_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `t_video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '1', '1', '2020-11-04 14:45:06', '张杰，我永远的男神');
INSERT INTO `t_comment` VALUES ('3', '1', '5', '2020-11-04 18:34:52', 'qwe');
INSERT INTO `t_comment` VALUES ('10', '1', '5', '2020-11-04 19:31:50', '123');
INSERT INTO `t_comment` VALUES ('11', '1', '2', '2020-11-08 23:15:40', '234');
INSERT INTO `t_comment` VALUES ('12', '1', '2', '2020-11-09 16:10:37', '向志敏，加油');

-- ----------------------------
-- Table structure for t_favorite
-- ----------------------------
DROP TABLE IF EXISTS `t_favorite`;
CREATE TABLE `t_favorite` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `t_favorite_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_favorite_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `t_video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_favorite
-- ----------------------------

-- ----------------------------
-- Table structure for t_history
-- ----------------------------
DROP TABLE IF EXISTS `t_history`;
CREATE TABLE `t_history` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `t_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_history_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `t_video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_history
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tag
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '搞笑，我们是认真的。', '1a3d9d44bdee370767c112857a45a984', 'CSerxzm', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '0', 'admin');
INSERT INTO `t_user` VALUES ('2', 'root', '搞笑1，我们是认真的。', '7d08316bde2d5e97d827bd07b90551b7', '大蝈蝈', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', '0', 'user');
INSERT INTO `t_user` VALUES ('5', 'root1', '大家好，我是帅气的团队，我们进驻B站20年，只为逗你开心！', '597245c832afcbe5db4d84772e58fd48', '帅气的一号种子选手', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-10-30 13:42:50', '0', 'user');
INSERT INTO `t_user` VALUES ('6', 'xzm', '123', '1cac138c89a1066bcc6ecb1d3c1c1ccf', '343445', '234324', '2020-11-13 22:11:57', '0', '');

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
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_video_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_video_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_video
-- ----------------------------
INSERT INTO `t_video` VALUES ('1', '1希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '7878', '1', '123', '1', '23', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('2', '2希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '2', '1', '23', '1', '23', '1', '2', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('3', '3希望喜欢', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '3', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('4', '4希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '4', '1', '12', '1', '324', '1', '4', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('5', '5希望喜欢Gal', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '5656', '1', '1', '1', '1', '1', '1', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('6', '6希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '767', '1', '2', '1', '45', '1', '2', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('7', '7希望喜欢', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '32', '1', '12', '1', '56', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('8', '8希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '3', '1', '12', '1', '6', '1', '4', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('9', '9希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '890', '1', '12', '1', '7', '1', '1', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('10', '10希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '3', '1', '121', '1', '687', '1', '2', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('11', '11希望喜欢Gal的你', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '554', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('12', '12希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '5', '1', '1', '1', '8', '1', '4', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('13', '13希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '23', '1', '1', '1', '8', '1', '1', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('14', '1希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '7878', '1', '123', '1', '23', '1', '1', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('15', '2希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '2', '1', '23', '1', '23', '1', '2', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('16', '3希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '3', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('17', '4希望喜欢Gal的', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '4', '1', '12', '1', '324', '1', '4', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('18', '5希望喜欢Gal的你', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '5656', '1', '1', '1', '1', '1', '1', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('19', '6希望喜欢Gal的', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '767', '1', '2', '1', '45', '1', '2', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('20', '7希望喜欢Gal的你', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '32', '1', '12', '1', '56', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('21', '8希望喜欢Gal的你', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '3', '1', '12', '1', '6', '1', '4', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('22', '9希望喜欢Gal的你能被推', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '890', '1', '12', '1', '7', '1', '1', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('23', '10希望喜欢Gal的你能', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '3', '1', '121', '1', '687', '1', '2', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('24', '11希望喜欢Gal的你能被推送到这个视频34特委托贵司订购三国时代', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '554', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('25', '12希望喜欢Gal的你能被推送到这个视频', '2', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '5', '1', '1', '1', '8', '1', '4', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('26', '13希望喜欢Gal的你能被推送到这个视频', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '23', '1', '1', '1', '8', '1', '1', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('27', '11希望喜欢Gal的你能被推', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '554', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('28', '11希望喜欢Gal的你能被推送到这个视频34特委托贵', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '554', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('29', '11希望喜欢Gal的你能被推送到这个视频34特委托贵司订购三国时代三个是德国', '1', '不要白嫖了，点个赞再走吧，别让这个视频凉了啊～\r\n弹幕也拜托了！这对我真的很重要\r\n觉得可以的话分享给hxd吧～\r\n高能从60s开始\r\n\r\n\r\n（欢迎竞标）', '2020-10-25 17:30:26', 'http://localhost:8080/file/20201103183816640.mp4', '554', '1', '23', '1', '1', '1', '3', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('34', '向志敏', '5', '                        我的低于分实时发VS大苏打v', '2020-11-03 11:43:40', 'http://localhost:8080/file/20201103183816640.mp4', '0', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20201103183821018.png');
INSERT INTO `t_video` VALUES ('35', '向志敏', '5', '                        我的低于分实时发VS大苏打v', '2020-11-03 11:43:40', 'http://localhost:8080/file/20201103183816640.mp4', '0', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20201103114324764.png');
INSERT INTO `t_video` VALUES ('36', '向志敏', '5', '                        我的低于分实时发VS大苏打v', '2020-11-03 11:43:40', 'http://localhost:8080/file/20201103183816640.mp4', '0', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20201103114324764.png');
INSERT INTO `t_video` VALUES ('37', '就梦一场痘印版', '5', '                士大夫士大夫不是举报所发生的士大夫速度岁的法国速度        ', '2020-11-03 12:23:04', 'http://localhost:8080/file/20201103183816640.mp4', '0', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20201103122234849.png');
INSERT INTO `t_video` VALUES ('40', 'Linux C学习笔记', '5', '                        rfghdfh', '2020-11-04 12:44:46', 'http://localhost:8080/file/20201104124434742.mp4', '0', '0', '0', '0', '0', '0', '1', 'http://localhost:8080/file/20201104124437708.png');
INSERT INTO `t_video` VALUES ('41', '旧梦一场', '2', '         这是我的第一个挖矿教程在内存中可惜处置可变现操作现场秩序处女座空间相册在程序执行操作系操作系查找先充值那些成本支出自行车资讯科技创造课程那种恐惧参考价值常州科教城做库存状况c               ', '2020-11-09 16:12:35', 'http://localhost:8080/file/20201109161148089.mp4', '0', '0', '0', '0', '0', '0', '4', 'http://localhost:8080/file/20201109161152492.png');
