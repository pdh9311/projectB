SHOW DATABASES;
SHOW TABLES;

SELECT *
FROM tbl_employer;

SELECT *
FROM tbl_employer_info;

SELECT *
FROM tbl_employer_info AS a
         INNER JOIN tbl_employer AS b
                    ON a.employer_info_idx = b.employer_info_idx;

SELECT local_code_idx, sido_code, sido_name
FROM tbl_local_code
GROUP BY sido_code;

SELECT sigungu_code, sigungu_name
FROM tbl_local_code
WHERE sido_code = '11'
GROUP BY sigungu_code;

SELECT eupmyeondong_code, eupmyeondong_name
FROM tbl_local_code
WHERE sigungu_code = '100'
GROUP BY eupmyeondong_code;

SELECT *
FROM tbl_local_code
WHERE sigungu_name = '양산시';

SELECT *
FROM tbl_local_code
WHERE sigungu_code = '100';

SELECT eupmyeondong_code, eupmyeondong_name
FROM tbl_local_code
WHERE sido_code = '38'
  AND sigungu_code = '100'
GROUP BY eupmyeondong_code;

-- -----------------------------------------------

SELECT *
FROM tbl_worker_info;

INSERT INTO tbl_worker_info(worker_name, worker_birth, worker_gender, worker_email, worker_phone, agree_service, agree_personal_info)
VALUES ('hihi', '2020-11-11', 'man', 'worker@wokre.com', '010-1111', 1, 1);


SELECT *
FROM tbl_worker;

-- -----------------------------------------------

-- 사용자는 하나의 지역에 하루에 한번만 등록 가능하다.
SELECT Z.worker_info_idx,
       Z.worker_name,
       Z.worker_birth,
       Z.worker_gender,
       Z.worker_email,
       Z.worker_phone,
       Z.worker_career,
       Z.worker_photo_1,
       Z.worker_photo_2
FROM tbl_apply_job AS Y
         INNER JOIN tbl_worker_info AS Z
                    ON Y.worker_info_idx = Z.worker_info_idx
WHERE Y.local_code_idx = 144
GROUP BY Z.worker_info_idx;

SELECT Z.worker_info_idx,
       Z.worker_name,
       Z.worker_birth,
       Z.worker_gender,
       Z.worker_email,
       Z.worker_phone,
       Z.worker_career,
       Z.worker_photo_1,
       Z.worker_photo_2
FROM tbl_apply_job AS Y
         INNER JOIN tbl_worker_info AS Z ON Y.worker_info_idx = Z.worker_info_idx
WHERE Y.local_code_idx = 144
   OR Y.local_code_idx = 153
GROUP BY Z.worker_info_idx;


SELECT Z.worker_info_idx,
       Z.worker_name,
       Z.worker_birth,
       Z.worker_gender,
       Z.worker_email,
       Z.worker_phone,
       Z.worker_career,
       Z.worker_photo_1,
       Z.worker_photo_2
FROM tbl_apply_job AS Y
         INNER JOIN tbl_worker_info AS Z ON Y.worker_info_idx = Z.worker_info_idx
WHERE Y.local_code_idx = 3277
GROUP BY Z.worker_info_idx;


UPDATE tbl_apply_job
    SET apply_status = true
    WHERE worker_info_idx = 4 AND local_code_idx = 144;

SELECT * FROM tbl_apply_job;

SELECT * FROM tbl_job_history;


-- --------------------------------------------------------------------------------
-- 근로자 회원 가입
INSERT INTO tbl_worker_info(worker_info_idx,
                            worker_name,
                            worker_birth,
                            worker_gender,
                            worker_email,
                            worker_phone,
                            agree_service,
                            agree_personal_info)
VALUES (1, '근로자', '1993-03-11', '남', 'worker1@worker.com', '010-6381-0086', true, true);
INSERT INTO tbl_worker(login_type,
                       worker_id,
                       worker_pw,
                       worker_info_idx)
VALUES (0, 'worker1', 'worker1', 1);
-- 고용자 회원 가입
INSERT INTO tbl_employer_info(employer_info_idx,
                              employer_email,
                              employer_phone,
                              business_number,
                              expiration_date,
                              agree_service,
                              agree_personal_info)
VALUES (1, 'employer1@empployer.com', '010-1111-1111', '123-12-12311', '2023-12-31 00:00:00', true, true);
INSERT INTO tbl_employer(employer_id, employer_pw, employer_info_idx)
VALUES ('employer1', 'employer1', 1);

-- 근로자 신청
INSERT INTO tbl_apply_job (apply_time, local_code_idx, worker_info_idx, apply_status)
VALUES ('2022-12-04 23:03:03', 1, 1, 0);
-- 고용자 고용
UPDATE tbl_apply_job
SET apply_status = 1
WHERE worker_info_idx = 1;

INSERT INTO tbl_job_history(history_time, worker_info_idx, employer_info_idx, local_code_idx,pay, worker_status, payment_status)
VALUES ('2022-12-04 23:05:03', 1, 1, 1, 100000, '고용됨', false);

-- 고용자 고용 리스트
SELECT *
FROM tbl_job_history AS A
INNER JOIN tbl_worker_info AS B
ON A.worker_info_idx = B.worker_info_idx;

-- --------------------------------------------------------------------------------
SELECT A.history_time, B.worker_name, A.pay, A.worker_status, A.payment_status
FROM tbl_job_history AS A
INNER JOIN tbl_worker_info AS B
ON A.worker_info_idx = B.worker_info_idx
WHERE A.employer_info_idx = :employerInfoIdx;

SELECT * FROM tbl_local_code;

SELECT A.history_time, B.worker_name, A.pay, A.worker_status, A.payment_status, C.local_code_idx, C.sido_name, C.sigungu_name, C.eupmyeondong_name
FROM tbl_job_history AS A
INNER JOIN tbl_worker_info AS B
ON A.worker_info_idx = B.worker_info_idx
INNER JOIN tbl_local_code AS C
ON A.local_code_idx = C.local_code_idx
WHERE A.employer_info_idx = 1;
