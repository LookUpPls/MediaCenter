/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost:3306
 Source Schema         : mediacenter

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : 65001

 Date: 18/10/2019 17:27:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for center_directory
-- ----------------------------
DROP TABLE IF EXISTS `center_directory`;
CREATE TABLE `center_directory`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(50) NULL DEFAULT NULL,
  `size` int(50) NULL DEFAULT NULL,
  `lastOperaTime` datetime NULL DEFAULT NULL,
  `createTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for center_directory_treepath
-- ----------------------------
DROP TABLE IF EXISTS `center_directory_treepath`;
CREATE TABLE `center_directory_treepath`  (
  `ancestor` int(20) NOT NULL,
  `descendant` int(20) NOT NULL,
  `deepth` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ancestor`, `descendant`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for device_save_directory
-- ----------------------------
DROP TABLE IF EXISTS `device_save_directory`;
CREATE TABLE `device_save_directory`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '有就是存，没有就是不存',
  `deviceID` int(20) UNSIGNED NOT NULL,
  `dirID` int(20) UNSIGNED NULL DEFAULT NULL,
  `lastDownloadTime` datetime NULL DEFAULT NULL,
  `status` bit(4) NULL DEFAULT NULL COMMENT '0 是待传输，1是传输汇总，2是传输完比，3是出错了',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `deviceID`(`deviceID`) USING BTREE,
  INDEX `dirID`(`dirID`) USING BTREE,
  CONSTRAINT `device_save_directory_ibfk_1` FOREIGN KEY (`dirID`) REFERENCES `center_directory` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `device_save_directory_ibfk_2` FOREIGN KEY (`deviceID`) REFERENCES `devices` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for device_scan_directory
-- ----------------------------
DROP TABLE IF EXISTS `device_scan_directory`;
CREATE TABLE `device_scan_directory`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deviceID` int(20) UNSIGNED NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ignore` bit(1) NULL DEFAULT NULL COMMENT '默认为0，不忽略；1为忽略',
  `lastOpeartorTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `deviceID`(`deviceID`) USING BTREE,
  CONSTRAINT `device_scan_directory_ibfk_1` FOREIGN KEY (`deviceID`) REFERENCES `devices` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for device_scan_directory_treepath
-- ----------------------------
DROP TABLE IF EXISTS `device_scan_directory_treepath`;
CREATE TABLE `device_scan_directory_treepath`  (
  `ancestor` int(20) NOT NULL,
  `descendant` int(20) NOT NULL,
  `deepth` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ancestor`, `descendant`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '存一个id为0的表示服务器来防止外键错误',
  `ideaCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lastUploadTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for pictures
-- ----------------------------
DROP TABLE IF EXISTS `pictures`;
CREATE TABLE `pictures`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `size` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fromDirID` int(20) UNSIGNED NOT NULL COMMENT '从哪个设备来的，存id，找不到就显示已删除设备。为0的时候是本地来的',
  `saveDirID` int(20) UNSIGNED NULL DEFAULT NULL,
  `uploadTime` datetime NULL DEFAULT NULL,
  `createTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pictures_ibfk_1`(`fromDirID`) USING BTREE,
  INDEX `pictures_ibfk_2`(`saveDirID`) USING BTREE,
  CONSTRAINT `pictures_ibfk_1` FOREIGN KEY (`fromDirID`) REFERENCES `device_scan_directory` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `pictures_ibfk_2` FOREIGN KEY (`saveDirID`) REFERENCES `center_directory` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
