SHOW DATABASES;

SHOW TABLES;

DROP TABLE IF EXISTS tbl_employer;
CREATE TABLE IF NOT EXISTS tbl_employer(
    idx bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employer_id varchar(100) NOT NULL UNIQUE KEY ,
    employer_pw varchar(255) NOT NULL,
    email varchar(100),
--  phone varchar(100) NOT NULL,
    business_number varchar(100) NOT NULL,
    expiration_period datetime NOT NULL,
    agree_service boolean NOT NULL,
    agree_personal_info boolean NOT NULL,
    agree_sms boolean,
    agree_email boolean
);

DESC tbl_employer;

SELECT * FROM tbl_employer;

SELECT *
FROM tbl_employer
WHERE employer_id = 'pdh9311'
  AND employer_pw = 'qwe123!@#';


# IF(컬럼명, 'true', 'false') AS 컬럼명
