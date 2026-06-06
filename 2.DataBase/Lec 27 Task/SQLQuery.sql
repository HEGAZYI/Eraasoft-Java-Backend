-- 1. Find all employees where emp_id is within the range 100 to 105
SELECT *
FROM employees
WHERE employee_id BETWEEN 100 AND 105;

-- 2. Find all employees with emp_id in a specific set
SELECT *
FROM employees
WHERE employee_id IN (151, 152, 153, 154, 155);

-- 3. Retrieve employees whose first_name starts with P or p
SELECT *
FROM employees
WHERE UPPER(first_name) LIKE 'P%';

-- 4. Retrieve employees whose first_name ends with A or a
SELECT *
FROM employees
WHERE UPPER(first_name) LIKE '%A';

-- 5. Retrieve employees whose first_name starts with A or a
SELECT *
FROM employees
WHERE UPPER(first_name) LIKE 'A%';

-- 6. Retrieve employees whose third character in first_name is E or e
SELECT *
FROM employees
WHERE UPPER(first_name) LIKE '__E%';

-- 7. Retrieve employees who don't have a manager assigned
SELECT *
FROM employees
WHERE manager_id IS NULL;

-- 8. Retrieve employees who have a manager assigned
SELECT *
FROM employees
WHERE manager_id IS NOT NULL;

-- 9. Insert a new employee without assigning a manager
INSERT INTO employees (
    employee_id,
    first_name,
    last_name,
    email,
    hire_date,
    job_id,
    salary,
    manager_id,
    department_id
)
VALUES (
    300,
    'Ahmed',
    'Hegazy',
    'AHEGAZY',
    SYSDATE,
    'IT_PROG',
    5000,
    NULL,
    60
);

-- 10. Find employees with job_id AD_VP or IT_PROG
SELECT *
FROM employees
WHERE job_id IN ('AD_VP', 'IT_PROG');

-- 11. Retrieve employees sorted by last_name ascending
SELECT *
FROM employees
ORDER BY last_name ASC;

-- 12. Retrieve employees sorted by hire_date descending
SELECT *
FROM employees
ORDER BY hire_date DESC;

-- 13. Sort by department ascending and salary descending
SELECT *
FROM employees
ORDER BY department_id ASC, salary DESC;

-- 14. Retrieve employees with last_name in lowercase
SELECT employee_id,
       LOWER(last_name) AS last_name_lower
FROM employees;

-- 15. Retrieve employees with first_name in uppercase
SELECT employee_id,
       UPPER(first_name) AS first_name_upper
FROM employees;

-- 16. Retrieve employees with first_name and last_name in title case
SELECT employee_id,
       INITCAP(first_name) AS first_name_title,
       INITCAP(last_name) AS last_name_title
FROM employees;

-- 17. Find employees whose last_name is 'smith' regardless of case
SELECT *
FROM employees
WHERE UPPER(last_name) = 'SMITH';