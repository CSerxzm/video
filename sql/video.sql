drop database if exists video;
create database video default character set utf8 collate utf8_general_ci;
use  video;

drop table if exists t_type;
create table t_type(
  id int(11) primary key not null auto_increment,
  name varchar(255) not null comment "分类"
);
insert into t_type(id,name) values(1,'动画'),(2,'游戏'),(3,'番剧'),(4,'教育');

drop table if exists t_user;
create table t_user(
  id int(11) primary key not null auto_increment,
  username varchar(255) default null,
  description varchar(255) default null comment "描述",
  password varchar(255) default null comment "密码",
  nickname varchar(255) default null comment "昵称",
  avatar varchar(255) default null comment "头像",
  create_time datetime default null comment "注册时间",
  coinnum int(11) default 0 comment "硬币数",
  usertype int(11) default null comment "类型,admin"
);
insert into t_user(id,username,password,nickname,avatar,create_time,coinnum,usertype) values('1', 'admin', '5f4dcc3b5aa765d61d8327deb882cf99', 'CSerxzm', 'https://allpassaway.oss-cn-shenzhen.aliyuncs.com/images/allpassaway.jpg', '2020-09-30 15:35:17', 0, '1');

drop table if exists t_video;
create table t_video(
  id int(11) primary key not null auto_increment,
  title varchar(255) default null comment "标题",
  user_id int(11) default null comment "发布者id",
  description varchar(255) default null comment "描述",
  create_time datetime default null comment "创建时间",
  url varchar(255) default null comment "视频url",
  viewnum int(11) default 0  comment "播放量",
  barrnum int(11) default 0  comment "弹幕数",
  starnum int(11) default 0  comment "收藏量",
  coinnum int(11) default 0  comment "硬币数",
  likenum int(11) default 0  comment "点赞数",
  trannum int(11) default 0  comment "转发数",
  type_id int(11) default null comment "类型id",
  foreign key(user_id) references t_user(id) on delete cascade on update cascade,
  foreign key(type_id) references t_type(id) on delete cascade on update cascade
);

drop table if exists t_tag;
create table t_tag(
  id int(11) primary key not null auto_increment,
  content varchar(255) default null comment "评论内容",
  video_id int(11) default null comment "video的id",
  foreign key(video_id) references t_video(id) on delete cascade on update cascade
);

drop table if exists t_barrage;
create table t_barrage(
  id int(11) primary key not null auto_increment,
  content varchar(255) default null comment "评论内容",
  create_time datetime default null comment "评论时间",
  video_id int(11) default null comment "video的id",
  video_time datetime default null comment "视频时间",
  foreign key(video_id) references t_video(id) on delete cascade on update cascade
);

drop table if exists t_comment;
create table t_comment(
  id int(11) primary key not null auto_increment,
  avatar varchar(255) default null comment "头像",
  content varchar(255) default null comment "评论内容",
  create_time datetime default null comment "评论时间",
  email varchar(255) default null comment "评论邮箱",
  user_id int(11) default null comment "评论者id",
  video_id int(11) default null comment "video的id",
  foreign key(user_id) references t_user(id) on delete cascade on update cascade,
  foreign key(video_id) references t_video(id) on delete cascade on update cascade
);
