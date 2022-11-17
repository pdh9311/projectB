-- test 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;

-- 테이블 test.tbl_worker_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_worker_info` (
  `worker_info_idx` BIGINT NOT NULL AUTO_INCREMENT,
  `worker_email` VARCHAR(50) NOT NULL,
  `worker_name` VARCHAR(50) NOT NULL,
  `worker_gender` BOOLEAN NOT NULL,
  `worker_phone` VARCHAR(20) NOT NULL,
  `worker_birth` VARCHAR(8) NOT NULL,
  `worker_career` TEXT DEFAULT NULL,
  `worker_photo_1` VARCHAR(255) DEFAULT NULL,
  `worker_photo_2` VARCHAR(255) DEFAULT NULL,
  `bank_name` VARCHAR(20) NOT NULL,
  `bank_account_number` VARCHAR(20) NOT NULL,
  `point` BIGINT NOT NULL,
  `agree_service` BOOLEAN NOT NULL,
  `agree_personal_info` BOOLEAN NOT NULL,
  `agree_sms` BOOLEAN DEFAULT NULL,
  `agree_email` BOOLEAN DEFAULT NULL,
  PRIMARY KEY (`worker_info_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- 테이블 test.tbl_worker 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_worker` (
  `login_type` INT NOT NULL,
  `worker_id` VARCHAR(255) NOT NULL,
  `worker_pw` VARCHAR(255) NOT NULL,
  `worker_info_idx` BIGINT NOT NULL,
  PRIMARY KEY (`login_type`,`worker_id`),
  FOREIGN KEY (`worker_info_idx`) REFERENCES `tbl_worker_info` (`worker_info_idx`)
) ENGINE=INNODB CHARSET='utf8mb4' COLLATE='utf8mb4_general_ci';

-- 테이블 test.tbl_employer_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_employer_info` (
  `employer_info_idx` BIGINT NOT NULL AUTO_INCREMENT,
  `employer_email` VARCHAR(100) NOT NULL,
  `employer_phone` VARCHAR(20) DEFAULT NULL,
  `business_number` VARCHAR(12) NOT NULL,
  `business_name` VARCHAR(50) DEFAULT NULL,
  `business_address` VARCHAR(100) DEFAULT NULL,
  `bank_name` VARCHAR(20) DEFAULT NULL,
  `bank_account_number` VARCHAR(20) DEFAULT NULL,
  `point` BIGINT DEFAULT 0,
  `expiration_date` DATETIME(6) NOT NULL,
  `agree_service` BOOLEAN NOT NULL,
  `agree_personal_info` BOOLEAN NOT NULL,
  `agree_sms` BOOLEAN DEFAULT NULL,
  `agree_email` BOOLEAN DEFAULT NULL,
  PRIMARY KEY (`employer_info_idx`)
) ENGINE=INNODB CHARSET='utf8mb4' COLLATE='utf8mb4_general_ci';

-- 테이블 test.tbl_employer 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_employer` (
  `employer_id` VARCHAR(255) NOT NULL,
  `employer_pw` VARCHAR(255) NOT NULL,
  `employer_status` BOOLEAN DEFAULT 1,
  `employer_info_idx` BIGINT NOT NULL,
  PRIMARY KEY (`employer_id`),
  FOREIGN KEY (`employer_info_idx`) REFERENCES `tbl_employer_info` (`employer_info_idx`)
) ENGINE=INNODB CHARSET='utf8mb4' COLLATE='utf8mb4_general_ci';

-- 테이블 test.tbl_apply_job 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_apply_job` (
  `apply_time` DATETIME(6) NOT NULL,
  `local_code_idx` BIGINT NOT NULL,
  `worker_info_idx` BIGINT NOT NULL,
  `apply_status` BOOLEAN NOT NULL
) ENGINE=INNODB CHARSET='utf8mb4' COLLATE='utf8mb4_general_ci';

-- 테이블 test.tbl_job_history 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_job_history` (
  `history_time` DATETIME(6) NOT NULL,
  `worker_info_idx` BIGINT NOT NULL,
  `employer_info_idx` BIGINT NOT NULL,
  `pay` INT NOT NULL,
  `worker_status` VARCHAR(10) NOT NULL,
  `payment_status` BOOLEAN NOT NULL
) ENGINE=INNODB CHARSET='utf8mb4' COLLATE='utf8mb4_general_ci';

-- 테이블 test.tbl_local_code 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_local_code` (
  `local_code_idx` BIGINT NOT NULL AUTO_INCREMENT,
  `sido_code` VARCHAR(2) NOT NULL,
  `sido_name` VARCHAR(30) NOT NULL,
  `sigungu_code` VARCHAR(3) NOT NULL,
  `sigungu_name` VARCHAR(30) NOT NULL,
  `eupmyeondong_code` VARCHAR(2) NOT NULL,
  `eupmyeondong_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`local_code_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4096 DEFAULT CHARSET=utf8mb4;

-- 테이블 test.tbl_point_history 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_point_history` (
  `point_history_idx` BIGINT NOT NULL AUTO_INCREMENT,
  `worker_info_idx` BIGINT NOT NULL,
  `employer_info_idx` BIGINT NOT NULL,
  `point_time` DATETIME(6) NOT NULL,
  `point_type` VARCHAR(10) NOT NULL,
  `money` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`point_history_idx`)
) ENGINE=INNODB CHARSET='utf8mb4' COLLATE='utf8mb4_general_ci';

-- 테이블 test.tbl_transfer_history 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_transfer_history` (
  `transfer_history_idx` BIGINT NOT NULL AUTO_INCREMENT,
  `worker_info_idx` BIGINT DEFAULT 0,
  `employer_info_idx` BIGINT DEFAULT 0,
  `transfer_time` DATETIME(6) NOT NULL,
  `transfer_type` VARCHAR(10) NOT NULL,
  `money` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`transfer_history_idx`)
) ENGINE=INNODB CHARSET='utf8mb4' COLLATE='utf8mb4_general_ci';

