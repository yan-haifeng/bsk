/*
Navicat MySQL Data Transfer

Source Server         : Myaliyun
Source Server Version : 50724
Source Host           : 106.15.91.244:3306
Source Database       : bskdb

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-12-20 21:46:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `address_userid` int(11) DEFAULT NULL COMMENT '用户id',
  `address_name` varchar(250) DEFAULT NULL COMMENT '收货人',
  `address_phone` varchar(11) DEFAULT NULL COMMENT '收获电话',
  `address_info` varchar(250) DEFAULT NULL COMMENT '我的地址（使用多种分隔符？一个地址中的不同级（区和街道），不同地址）',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cakecar
-- ----------------------------
DROP TABLE IF EXISTS `cakecar`;
CREATE TABLE `cakecar` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `car_userid` int(11) DEFAULT NULL COMMENT '所属用户id',
  `car_cakeid` int(11) DEFAULT NULL COMMENT '待购蛋糕id',
  `car_specsid` int(11) DEFAULT NULL COMMENT '蛋糕规格id',
  `car_num` int(11) DEFAULT NULL COMMENT '购买数量',
  `car_state` int(1) DEFAULT '0' COMMENT '购买状态（0没有下单，1以下单）',
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cakeclass
-- ----------------------------
DROP TABLE IF EXISTS `cakeclass`;
CREATE TABLE `cakeclass` (
  `cakeclass_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蛋糕类别id',
  `cakeclass_name` varchar(20) DEFAULT NULL COMMENT '类别名',
  `cakeclass_info` varchar(250) DEFAULT NULL COMMENT '类别信息',
  PRIMARY KEY (`cakeclass_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cakeclassmin
-- ----------------------------
DROP TABLE IF EXISTS `cakeclassmin`;
CREATE TABLE `cakeclassmin` (
  `cakeclassmin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蛋糕类别minid',
  `cakeclassmin_classid` int(11) DEFAULT NULL COMMENT '蛋糕类别id',
  `cakeclassmin_name` varchar(20) DEFAULT NULL COMMENT '类别min名',
  `cakeclassmin_info` varchar(250) DEFAULT NULL COMMENT '类别min信息',
  PRIMARY KEY (`cakeclassmin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cakeinfo
-- ----------------------------
DROP TABLE IF EXISTS `cakeinfo`;
CREATE TABLE `cakeinfo` (
  `cake_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蛋糕id',
  `cake_name` varchar(20) DEFAULT NULL COMMENT '蛋糕名',
  `cake_ename` varchar(20) DEFAULT NULL COMMENT '蛋糕英文名',
  `cake_img` varchar(250) DEFAULT NULL COMMENT '蛋糕图片地址',
  `cake_classid` int(11) DEFAULT NULL COMMENT '蛋糕类别id',
  `cake_classminid` int(11) DEFAULT NULL COMMENT '蛋糕类别minid',
  `cake_specsid` int(11) DEFAULT NULL COMMENT '蛋糕规格id',
  `cake_num` int(11) DEFAULT NULL COMMENT '蛋糕数量',
  `cake_info` varchar(250) DEFAULT NULL COMMENT '蛋糕详情',
  `cake_discount` double(7,2) DEFAULT NULL COMMENT '优惠价格',
  `cake_discountday` int(1) DEFAULT '0' COMMENT '今日折扣（0非今日折扣，1今日折扣）',
  PRIMARY KEY (`cake_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cakeorderinfo
-- ----------------------------
DROP TABLE IF EXISTS `cakeorderinfo`;
CREATE TABLE `cakeorderinfo` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` varchar(50) DEFAULT NULL COMMENT '订单号',
  `order_carid` varchar(250) DEFAULT NULL COMMENT '购物车id总和（每个购物车id之间用？隔开）',
  `order_userid` int(11) DEFAULT NULL COMMENT '购买用户id',
  `order_time` datetime DEFAULT NULL COMMENT '订单时间',
  `order_price` double(10,2) DEFAULT NULL COMMENT '订单总价格',
  `order_discount` double(7,2) DEFAULT NULL COMMENT '优惠总价格',
  `order_type` int(1) DEFAULT '1' COMMENT '配送方式（0自提，1是配送）',
  `order_addressid` int(11) DEFAULT NULL COMMENT '配送地址id',
  `order_deliverytime` varchar(50) DEFAULT NULL COMMENT '配送时间',
  `order_carriage` int(11) DEFAULT '30' COMMENT '运费	',
  `order_state` int(1) DEFAULT '0' COMMENT '订单状态（0待付款，1待配送，2待签收，4已完成，5其他）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cakespecs
-- ----------------------------
DROP TABLE IF EXISTS `cakespecs`;
CREATE TABLE `cakespecs` (
  `cakespecs_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '蛋糕规格id',
  `cakespecs_cakeid` int(11) DEFAULT NULL COMMENT '蛋糕id',
  `cakespecs_name` varchar(20) DEFAULT NULL COMMENT '规格大小',
  `cakespecs_price` double(7,2) DEFAULT NULL COMMENT '蛋糕价格',
  `cakespecs_sweet` int(1) DEFAULT NULL COMMENT '蛋糕甜度（蛋糕甜度0~5）',
  `cakespecs_size` varchar(50) DEFAULT NULL COMMENT '蛋糕尺寸',
  `cakespecs_person` varchar(50) DEFAULT NULL COMMENT '蛋糕人数',
  `cakespecs_tableware` varchar(50) DEFAULT NULL COMMENT '蛋糕餐具',
  `cakespecs_time` varchar(50) DEFAULT NULL COMMENT '蛋糕时间',
  PRIMARY KEY (`cakespecs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cakeusertalk
-- ----------------------------
DROP TABLE IF EXISTS `cakeusertalk`;
CREATE TABLE `cakeusertalk` (
  `talk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户评价id',
  `talk_userid` int(11) DEFAULT NULL COMMENT '评价用户id',
  `talk_cakeid` int(11) DEFAULT NULL COMMENT '评价蛋糕id',
  `talk_commoditygrade` int(1) DEFAULT NULL COMMENT '评价分数（评价分数1~5）',
  `talk_logisticsgrade` int(1) DEFAULT NULL COMMENT '物流分数（分数1~5）',
  `talk_servicegrade` int(1) DEFAULT NULL COMMENT '服务分数（分数1~5）',
  `talk_isimg` int(1) DEFAULT NULL COMMENT '是否有评价图片（0没有，1有）',
  `talk_img` varchar(250) DEFAULT NULL COMMENT '图片地址（多张用？隔开）',
  `talk_info` varchar(250) DEFAULT NULL COMMENT '用户评价内容',
  PRIMARY KEY (`talk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `user_nickname` varchar(40) DEFAULT NULL COMMENT '昵称',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `user_pwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `user_age` int(3) DEFAULT NULL COMMENT '年龄',
  `user_sex` int(1) DEFAULT NULL COMMENT '性别',
  `user_addressid` int(11) DEFAULT NULL COMMENT '默认地址',
  `user_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `user_changetime` datetime DEFAULT NULL COMMENT '修改时间 ',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
