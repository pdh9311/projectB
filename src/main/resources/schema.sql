SHOW DATABASES;

SHOW TABLES;

DROP TABLE IF EXISTS employer;
CREATE TABLE IF NOT EXISTS employer(
    i bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id varchar(100) NOT NULL,
    pw varchar(100) NOT NULL,
    email varchar(100),
#     phone varchar(100) NOT NULL,
    business_number varchar(100) NOT NULL,
    expiration_period datetime NOT NULL,
    agree_service boolean NOT NULL,
    agree_personal_info boolean NOT NULL,
    agree_sms boolean,
    agree_email boolean
);

DESC employer;

SELECT * FROM employer;

# IF(컬럼명, 'true', 'false') AS 컬럼명