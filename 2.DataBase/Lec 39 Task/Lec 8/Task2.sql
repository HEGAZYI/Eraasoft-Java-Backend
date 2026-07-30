-- 1. NATURAL JOIN
SELECT *
FROM jobs
NATURAL JOIN job_history;

-- 2. JOIN ... USING (job_id)
SELECT j.job_title, jh.employee_id, jh.start_date, jh.end_date
FROM jobs j
JOIN job_history jh USING (job_id);

-- 3. JOIN ... ON
SELECT j.job_title, jh.employee_id, jh.start_date, jh.end_date
FROM jobs j
JOIN job_history jh ON j.job_id = jh.job_id;

-- 4. INNER JOIN
SELECT j.job_title, jh.employee_id, jh.start_date, jh.end_date
FROM jobs j
INNER JOIN job_history jh ON j.job_id = jh.job_id;

-- 5. LEFT JOIN
SELECT j.job_title, jh.employee_id, jh.start_date, jh.end_date
FROM jobs j
LEFT JOIN job_history jh ON j.job_id = jh.job_id;

-- 6. RIGHT JOIN
SELECT j.job_title, jh.employee_id, jh.start_date, jh.end_date
FROM jobs j
RIGHT JOIN job_history jh ON j.job_id = jh.job_id;

-- 7. FULL OUTER JOIN (MySQL version)
SELECT j.job_title, jh.employee_id, jh.start_date, jh.end_date
FROM jobs j
LEFT JOIN job_history jh ON j.job_id = jh.job_id
UNION
SELECT j.job_title, jh.employee_id, jh.start_date, jh.end_date
FROM jobs j
RIGHT JOIN job_history jh ON j.job_id = jh.job_id;