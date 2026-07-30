-- JOB_HISTORY records with specific job_id values
SELECT *
FROM job_history
WHERE job_id IN (
    'AD_ASST',
    'FI_MGR',
    'FI_ACCOUNT',
    'AC_MGR',
    'AC_ACCOUNT',
    'SA_MAN',
    'SA_REP',
    'PU_MAN'
);

-- DEPARTMENTS with specific department_name values
SELECT *
FROM departments
WHERE department_name IN (
    'Administration',
    'Marketing',
    'Purchasing',
    'Human Resources',
    'Shipping'
);

-- Combined result (optional)
SELECT 'JOB_HISTORY' AS source, job_id AS key_value, employee_id, start_date, end_date
FROM job_history
WHERE job_id IN (
    'AD_ASST','FI_MGR','FI_ACCOUNT','AC_MGR',
    'AC_ACCOUNT','SA_MAN','SA_REP','PU_MAN'
)

UNION ALL

SELECT 'DEPARTMENTS' AS source, department_name AS key_value,
       department_id, NULL, NULL
FROM departments
WHERE department_name IN (
    'Administration','Marketing','Purchasing',
    'Human Resources','Shipping'
);