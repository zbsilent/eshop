/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : eshop_member

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 17/12/2018 16:49:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for openapi_quote
-- ----------------------------
DROP TABLE IF EXISTS `openapi_quote`;
CREATE TABLE `openapi_quote`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '指标ID',
  `quote_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指标编码',
  `quote_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指标名称',
  `quote_sum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合计人天',
  `exits_time` date NULL DEFAULT NULL COMMENT '失效日期',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for openapi_quote_item
-- ----------------------------
DROP TABLE IF EXISTS `openapi_quote_item`;
CREATE TABLE `openapi_quote_item`  (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '明细指标ID',
                                  `quote_id` int(11) NULL DEFAULT NULL COMMENT '指标ID',
                                  `quoteitem_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '明细指标编码',
                                  `quoteitem_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '明细指标名称',
                                  `quoteitem_unm` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人天',
                                  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
