SELECT sido_code, sido_name FROM tbl_local_code
GROUP BY sido_code;

SELECT sigungu_code, sigungu_name FROM tbl_local_code
WHERE sido_code = '11'
GROUP BY sigungu_code;

SELECT eupmyeondong_code, eupmyeondong_name FROM tbl_local_code
WHERE sigungu_code = '010'
GROUP BY eupmyeondong_code;