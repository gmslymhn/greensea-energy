/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : greensea_energy

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 21/05/2024 11:13:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gre_a0_day_log
-- ----------------------------
DROP TABLE IF EXISTS `gre_a0_day_log`;
CREATE TABLE `gre_a0_day_log`  (
  `device_id` int NOT NULL,
  `fc_status` int NULL DEFAULT NULL COMMENT '燃料电池状态',
  `fc_fault_level` int NULL DEFAULT NULL COMMENT '电解槽状态',
  `pemh2_status` int NULL DEFAULT NULL COMMENT '燃料电池故障等级',
  `pemh2_fault_level` int NULL DEFAULT NULL COMMENT '电解槽故障状态',
  `log_time` date NOT NULL COMMENT '时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_a0_day_log
-- ----------------------------
INSERT INTO `gre_a0_day_log` VALUES (1, 1, 1, 1, 1, '2024-05-17');
INSERT INTO `gre_a0_day_log` VALUES (2, 3, 2, 2, 2, '2024-05-18');
INSERT INTO `gre_a0_day_log` VALUES (3, 2, 2, 2, 2, '2024-05-19');
INSERT INTO `gre_a0_day_log` VALUES (3, 1, 1, 1, 1, '2024-05-19');

-- ----------------------------
-- Table structure for gre_a0_month_log
-- ----------------------------
DROP TABLE IF EXISTS `gre_a0_month_log`;
CREATE TABLE `gre_a0_month_log`  (
  `device_id` int NOT NULL,
  `fc_status` int NULL DEFAULT NULL COMMENT '燃料电池状态',
  `fc_fault_level` int NULL DEFAULT NULL COMMENT '电解槽状态',
  `pemh2_status` int NULL DEFAULT NULL COMMENT '燃料电池故障等级',
  `pemh2_fault_level` int NULL DEFAULT NULL COMMENT '电解槽故障状态',
  `log_time` date NOT NULL COMMENT '时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_a0_month_log
-- ----------------------------

-- ----------------------------
-- Table structure for gre_a1_day_log
-- ----------------------------
DROP TABLE IF EXISTS `gre_a1_day_log`;
CREATE TABLE `gre_a1_day_log`  (
  `device_id` int NOT NULL,
  `fc_stack_volt` float NULL DEFAULT NULL COMMENT '燃料电池电压',
  `fc_dcdc_voltout` float NULL DEFAULT NULL COMMENT '燃料电池DCDC输出电压',
  `pemh2_dcdc_voltout` float NULL DEFAULT NULL COMMENT '电解槽DCDC的输出电压',
  `time` date NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_a1_day_log
-- ----------------------------

-- ----------------------------
-- Table structure for gre_a1_month_log
-- ----------------------------
DROP TABLE IF EXISTS `gre_a1_month_log`;
CREATE TABLE `gre_a1_month_log`  (
  `device_id` int NOT NULL,
  `fc_stack_volt` float NULL DEFAULT NULL COMMENT '燃料电池电压',
  `fc_dcdc_voltout` float NULL DEFAULT NULL COMMENT '燃料电池DCDC输出电压',
  `pemh2_dcdc_voltout` float NULL DEFAULT NULL COMMENT '电解槽DCDC的输出电压',
  `time` date NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_a1_month_log
-- ----------------------------

-- ----------------------------
-- Table structure for gre_a2_day_log
-- ----------------------------
DROP TABLE IF EXISTS `gre_a2_day_log`;
CREATE TABLE `gre_a2_day_log`  (
  `device_id` int NOT NULL,
  `fc_stack_cur` float NULL DEFAULT NULL COMMENT '燃料电池电流',
  `fc_dcdc_curout` float NULL DEFAULT NULL COMMENT '燃料电池DCDC输出电流',
  `pemh2_dcdc_curout` float NULL DEFAULT NULL COMMENT '电解槽DCDC的输出电流',
  `time` date NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_a2_day_log
-- ----------------------------

-- ----------------------------
-- Table structure for gre_a2_month_log
-- ----------------------------
DROP TABLE IF EXISTS `gre_a2_month_log`;
CREATE TABLE `gre_a2_month_log`  (
  `device_id` int NOT NULL,
  `fc_stack_cur` float NULL DEFAULT NULL COMMENT '燃料电池电流',
  `fc_dcdc_curout` float NULL DEFAULT NULL COMMENT '燃料电池DCDC输出电流',
  `pemh2_dcdc_curout` float NULL DEFAULT NULL COMMENT '电解槽DCDC的输出电流',
  `time` date NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_a2_month_log
-- ----------------------------

-- ----------------------------
-- Table structure for gre_a5_day_log
-- ----------------------------
DROP TABLE IF EXISTS `gre_a5_day_log`;
CREATE TABLE `gre_a5_day_log`  (
  `device_id` int NOT NULL,
  `fc_kwh` float NULL DEFAULT NULL COMMENT '发电量',
  `electrovalence` float NULL DEFAULT NULL COMMENT '电价',
  `earning` float NULL DEFAULT NULL COMMENT '收益',
  `pemh2_pro` float NULL DEFAULT NULL COMMENT '制氢量',
  `time` date NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_a5_day_log
-- ----------------------------

-- ----------------------------
-- Table structure for gre_a5_month_log
-- ----------------------------
DROP TABLE IF EXISTS `gre_a5_month_log`;
CREATE TABLE `gre_a5_month_log`  (
  `device_id` int NOT NULL,
  `fc_kwh` float NULL DEFAULT NULL COMMENT '发电量',
  `electrovalence` float NULL DEFAULT NULL COMMENT '电价',
  `earning` float NULL DEFAULT NULL COMMENT '收益',
  `pemh2_pro` float NULL DEFAULT NULL COMMENT '制氢量',
  `time` date NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_a5_month_log
-- ----------------------------

-- ----------------------------
-- Table structure for gre_device
-- ----------------------------
DROP TABLE IF EXISTS `gre_device`;
CREATE TABLE `gre_device`  (
  `device_id` int NOT NULL COMMENT '设备id',
  `device_number` int NULL DEFAULT NULL COMMENT '设备序列号',
  `device_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备名',
  `device_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备类型',
  `device_ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备ip',
  `device_address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备地址',
  `bind_time` datetime NULL DEFAULT NULL COMMENT '绑定时间',
  `warranty_time` datetime NULL DEFAULT NULL COMMENT '保修时间',
  `device_mac` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备mac',
  `device_state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备状态',
  `create_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_device
-- ----------------------------

-- ----------------------------
-- Table structure for gre_device_msg
-- ----------------------------
DROP TABLE IF EXISTS `gre_device_msg`;
CREATE TABLE `gre_device_msg`  (
  `device_id` int NOT NULL,
  `device_number` int NULL DEFAULT NULL COMMENT '设备序列号',
  `is_wifi` tinyint(1) NULL DEFAULT NULL COMMENT '是否是用wifi',
  `sys_fault_level` int NULL DEFAULT NULL COMMENT '系统故障等级',
  `sys__fault_code` int NULL DEFAULT NULL COMMENT '系统故障code',
  `fc_status` int NULL DEFAULT NULL COMMENT '燃料电池状态',
  `fc_fault_level` int NULL DEFAULT NULL COMMENT '燃料电池故障等级',
  `pemh2_status` int NULL DEFAULT NULL COMMENT '电解槽状态',
  `pemh2_fault_level` int NULL DEFAULT NULL COMMENT '电解槽故障等级',
  `total_kwh` float NULL DEFAULT NULL COMMENT '累计发电量',
  `total_earning` float NULL DEFAULT NULL COMMENT '累计收益',
  `total_pemh2_pro` float NULL DEFAULT NULL COMMENT '累计制氢量',
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_device_msg
-- ----------------------------

-- ----------------------------
-- Table structure for gre_directory
-- ----------------------------
DROP TABLE IF EXISTS `gre_directory`;
CREATE TABLE `gre_directory`  (
  `directory_id` int NOT NULL AUTO_INCREMENT COMMENT '目录id',
  `directory_icon` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `directory_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '目录名字',
  `directory_grade` tinyint(1) NULL DEFAULT NULL COMMENT '目录等级（1为一级 2为二级）',
  `directory_superior` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '目录上级id',
  `directory_component` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件',
  `directory_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '目录类型',
  `directory_order` tinyint(1) NULL DEFAULT NULL COMMENT '次序',
  `directory_state` tinyint(1) NULL DEFAULT NULL COMMENT '目录状态',
  `create_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`directory_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_directory
-- ----------------------------
INSERT INTO `gre_directory` VALUES (1, NULL, '超级管理员目录', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-05-18 09:33:29', NULL, '2024-05-18 09:33:29', NULL);
INSERT INTO `gre_directory` VALUES (2, NULL, '管理员目录', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-05-18 09:33:45', NULL, '2024-05-18 09:33:45', NULL);
INSERT INTO `gre_directory` VALUES (3, NULL, '企业用户目录', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-05-18 09:33:54', NULL, '2024-05-18 09:33:54', NULL);
INSERT INTO `gre_directory` VALUES (4, NULL, '个人用户目录', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-05-18 09:34:32', NULL, '2024-05-18 09:34:32', NULL);

-- ----------------------------
-- Table structure for gre_directory_port_tag
-- ----------------------------
DROP TABLE IF EXISTS `gre_directory_port_tag`;
CREATE TABLE `gre_directory_port_tag`  (
  `directory_id` int NOT NULL COMMENT '目录id',
  `port_id` int NOT NULL COMMENT '接口id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_directory_port_tag
-- ----------------------------

-- ----------------------------
-- Table structure for gre_gm
-- ----------------------------
DROP TABLE IF EXISTS `gre_gm`;
CREATE TABLE `gre_gm`  (
  `gm_id` int NOT NULL COMMENT '管理员用户id',
  `gm_account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gm_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gm_nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gm_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `login_total` int NULL DEFAULT NULL,
  `last_login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `last_login_time` datetime NULL DEFAULT NULL,
  `gm_state` tinyint(1) NULL DEFAULT NULL,
  `del_flag` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`gm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_gm
-- ----------------------------
INSERT INTO `gre_gm` VALUES (-1359749118, '321', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `gre_gm` VALUES (1, 'admin', '$2a$10$Q0L2ROlYM29cBDhvlIl86uk8PK7MQgzMGd6K3Df.kU4.yAx4CR2ve', 'admin', '1', NULL, NULL, NULL, 1, 0);
INSERT INTO `gre_gm` VALUES (2, '321', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);

-- ----------------------------
-- Table structure for gre_gm_device_tag
-- ----------------------------
DROP TABLE IF EXISTS `gre_gm_device_tag`;
CREATE TABLE `gre_gm_device_tag`  (
  `gm_id` int NOT NULL COMMENT '管理id',
  `device_id` int NOT NULL COMMENT '设备id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_gm_device_tag
-- ----------------------------

-- ----------------------------
-- Table structure for gre_gm_msg
-- ----------------------------
DROP TABLE IF EXISTS `gre_gm_msg`;
CREATE TABLE `gre_gm_msg`  (
  `gm_id` int NOT NULL COMMENT '管理员id',
  `gm_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实名姓名',
  `gm_sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `gm_avatar` int NULL DEFAULT NULL COMMENT '头像',
  `gm_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '管理员用户电话',
  `gm_email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '管理员用户邮箱',
  `gm_identity_card` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '管理员用户身份证',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除（1删除 0未删除）',
  PRIMARY KEY (`gm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_gm_msg
-- ----------------------------

-- ----------------------------
-- Table structure for gre_port
-- ----------------------------
DROP TABLE IF EXISTS `gre_port`;
CREATE TABLE `gre_port`  (
  `port_id` int NOT NULL COMMENT '接口id',
  `port_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接口名',
  `port_path` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接口路径',
  `port_key` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接口密钥',
  `port_directory` int NULL DEFAULT NULL COMMENT '接口目录id',
  `remark` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `port_state` tinyint(1) NULL DEFAULT NULL COMMENT '接口状态',
  `create_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`port_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_port
-- ----------------------------

-- ----------------------------
-- Table structure for gre_resource
-- ----------------------------
DROP TABLE IF EXISTS `gre_resource`;
CREATE TABLE `gre_resource`  (
  `resource_id` int NOT NULL AUTO_INCREMENT COMMENT '静态资源id',
  `resource_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源名字',
  `resource_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源描述',
  `resource_path` varchar(31) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源路径',
  `resource_type` tinyint(1) NULL DEFAULT NULL COMMENT '资源类型',
  `resource_state` tinyint(1) NULL DEFAULT NULL COMMENT '资源状态（1正常 0停用）',
  `create_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建用户',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改用户',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除（1删除 0未删除）',
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_resource
-- ----------------------------
INSERT INTO `gre_resource` VALUES (1, 'n', '132', '321', NULL, NULL, '1', NULL, NULL, '2024-05-17 17:15:15', 6);

-- ----------------------------
-- Table structure for gre_role
-- ----------------------------
DROP TABLE IF EXISTS `gre_role`;
CREATE TABLE `gre_role`  (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_key` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色密钥',
  `role_type` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色类型',
  `remark` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` tinyint NULL DEFAULT NULL COMMENT '逻辑删除（1删除 0未删除)',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_role
-- ----------------------------
INSERT INTO `gre_role` VALUES (1, '超级管理员', 'admin', 'gm', NULL, NULL, '2024-05-17 16:58:48', NULL, '2024-05-20 16:00:50', 0);
INSERT INTO `gre_role` VALUES (2, '管理员', 'manager', 'gm', NULL, NULL, '2024-05-17 16:58:25', NULL, '2024-05-20 16:01:05', 0);
INSERT INTO `gre_role` VALUES (3, '企业用户', 'enterprise', 'user', NULL, NULL, NULL, NULL, '2024-05-20 16:01:00', 0);
INSERT INTO `gre_role` VALUES (4, '个人用户', 'personal', 'user', NULL, NULL, NULL, NULL, '2024-05-20 16:01:02', 0);

-- ----------------------------
-- Table structure for gre_role_directory_tag
-- ----------------------------
DROP TABLE IF EXISTS `gre_role_directory_tag`;
CREATE TABLE `gre_role_directory_tag`  (
  `role_id` int NOT NULL COMMENT '角色id',
  `directory_id` int NOT NULL COMMENT '目录id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_role_directory_tag
-- ----------------------------

-- ----------------------------
-- Table structure for gre_user
-- ----------------------------
DROP TABLE IF EXISTS `gre_user`;
CREATE TABLE `gre_user`  (
  `user_id` int NOT NULL COMMENT '用户id',
  `user_account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户账号',
  `user_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名/昵称',
  `user_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户类型',
  `login_total` int NULL DEFAULT NULL COMMENT '登录次数',
  `last_login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后登陆ip',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '用户最后登陆时间',
  `user_state` tinyint(1) NULL DEFAULT NULL COMMENT '用户状态（0停用 1可用）',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除(1删除 0未删除)',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_user
-- ----------------------------
INSERT INTO `gre_user` VALUES (2, 'testuser', '$2a$10$Q0L2ROlYM29cBDhvlIl86uk8PK7MQgzMGd6K3Df.kU4.yAx4CR2ve', 'user', '3', NULL, NULL, NULL, 1, 0);
INSERT INTO `gre_user` VALUES (3, 'testuser1', '$2a$10$BZAAwdRFMgOsc4eq.2oP3eoBFBSV2jl5LCj5se/1fGMTfZz1HeJRu', '用户', '3', NULL, NULL, NULL, 1, 0);
INSERT INTO `gre_user` VALUES (4, 'testuser2', '$2a$10$GXwezYcv7ZNWoThNpzLnmuBTPxaD3soXbnYozBNWDpRJfPmUcuKqu', '用户', '3', NULL, NULL, NULL, 1, 0);
INSERT INTO `gre_user` VALUES (5, 'testuser3', '$2a$10$vJOwtThaW5w/FE4WWsgqVeUXSpuhaBMXtr0m7gmL/g3FpcgncVc3G', '用户', '3', NULL, NULL, NULL, 1, 0);
INSERT INTO `gre_user` VALUES (6, 'testuser4', '$2a$10$NcAyfAnXn5rZA2Ejpf303.lEoTYcLphrtNTSv35kCJGu3rMDk/L.a', '用户', '3', NULL, NULL, NULL, 1, 0);
INSERT INTO `gre_user` VALUES (7, '2010647572', '$2a$10$5rQ1BAhvk8efcT7GJQXNiuk1lYGtF1Z4q/OYJtNZjM3Z7jcVPjFcC', '用户', '3', NULL, NULL, NULL, 1, 0);

-- ----------------------------
-- Table structure for gre_user_device_tag
-- ----------------------------
DROP TABLE IF EXISTS `gre_user_device_tag`;
CREATE TABLE `gre_user_device_tag`  (
  `user_id` int NOT NULL COMMENT '用户id',
  `device_id` int NULL DEFAULT NULL COMMENT '设备id',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_user_device_tag
-- ----------------------------

-- ----------------------------
-- Table structure for gre_user_gm
-- ----------------------------
DROP TABLE IF EXISTS `gre_user_gm`;
CREATE TABLE `gre_user_gm`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  `create_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_gm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_user_gm
-- ----------------------------
INSERT INTO `gre_user_gm` VALUES (1, 'admin', 'A', 1, NULL, NULL, NULL, '2024-05-19 21:57:26', 0);
INSERT INTO `gre_user_gm` VALUES (2, 'testuser', 'B', 1, NULL, '2024-05-19 20:08:42', NULL, '2024-05-20 10:57:19', 0);
INSERT INTO `gre_user_gm` VALUES (3, 'testuser1', 'B', 1, NULL, '2024-05-20 16:17:45', NULL, '2024-05-20 16:17:45', 0);
INSERT INTO `gre_user_gm` VALUES (4, 'testuser2', 'B', 1, NULL, '2024-05-20 16:18:51', NULL, '2024-05-20 16:18:51', 0);
INSERT INTO `gre_user_gm` VALUES (5, 'testuser3', 'B', 1, NULL, '2024-05-20 18:44:15', NULL, '2024-05-20 18:44:15', 0);
INSERT INTO `gre_user_gm` VALUES (6, 'testuser4', 'B', 1, NULL, '2024-05-21 01:20:48', NULL, '2024-05-21 01:20:48', 0);
INSERT INTO `gre_user_gm` VALUES (7, '2010647572', 'B', 1, NULL, '2024-05-21 02:18:50', NULL, '2024-05-21 02:18:50', 0);

-- ----------------------------
-- Table structure for gre_user_msg
-- ----------------------------
DROP TABLE IF EXISTS `gre_user_msg`;
CREATE TABLE `gre_user_msg`  (
  `user_id` int NOT NULL COMMENT '用户id',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别（0女 1男 2未知 ）',
  `user_avatar` int NULL DEFAULT NULL,
  `user_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户电话',
  `user_email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `user_identity_card` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户身份证',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除（1删除 0未删除）',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gre_user_msg
-- ----------------------------
INSERT INTO `gre_user_msg` VALUES (3, NULL, NULL, NULL, '15612341234', '2134@qq.com', NULL, NULL, 0);
INSERT INTO `gre_user_msg` VALUES (4, NULL, NULL, NULL, '15612341234', '21234@qq.com', NULL, NULL, 0);
INSERT INTO `gre_user_msg` VALUES (5, NULL, NULL, NULL, '15612341234', '2122234@qq.com', NULL, NULL, 0);
INSERT INTO `gre_user_msg` VALUES (6, NULL, NULL, NULL, '15612341234', '21422234@qq.com', NULL, NULL, 0);
INSERT INTO `gre_user_msg` VALUES (7, NULL, NULL, NULL, '15612341234', '43174440@qq.com', NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
