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

SELECT sido_code, sido_name
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

SELECT * FROM tbl_apply_job

SELECT * FROM tbl_job_history;