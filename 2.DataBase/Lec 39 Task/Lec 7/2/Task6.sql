-- Employees earning more than at least one employee in dept 10
SELECT first_name, last_name, salary
FROM employees
WHERE salary > ANY (SELECT salary FROM employees WHERE department_id = 10);

-- Employees earning less than all employees in dept 20
SELECT first_name, last_name, salary
FROM employees
WHERE salary < ALL (SELECT salary FROM employees WHERE department_id = 20);

-- Products with price equal to any product in 'Electronics'
SELECT product_name, price
FROM products
WHERE price IN (SELECT price FROM products WHERE category = 'Electronics');

-- Customers who ordered a product > $1000
SELECT DISTINCT c.customer_name
FROM customers c
WHERE c.customer_id IN (
    SELECT o.customer_id
    FROM orders o
    JOIN order_details od ON o.order_id = od.order_id
    JOIN products p ON od.product_id = p.product_id
    WHERE p.price > 1000
);

-- Employees who share a job title with at least one other employee
SELECT first_name, last_name, job_id
FROM employees
WHERE job_id IN (
    SELECT job_id FROM employees
    GROUP BY job_id HAVING COUNT(*) > 1
);

-- Departments with more than one employee
SELECT department_name
FROM departments
WHERE department_id IN (
    SELECT department_id FROM employees
    GROUP BY department_id HAVING COUNT(*) > 1
);

-- Orders from cities where other customers also ordered
SELECT *
FROM orders
WHERE customer_id IN (
    SELECT customer_id FROM customers
    WHERE city IN (
        SELECT city FROM customers
        GROUP BY city HAVING COUNT(*) > 1
    )
);

-- Books by authors who published more than one book
SELECT title
FROM books
WHERE author_id IN (
    SELECT author_id FROM books
    GROUP BY author_id HAVING COUNT(*) > 1
);

-- Students enrolled in any course taught by 'Dr. Smith'
SELECT s.student_name
FROM students s
WHERE s.student_id IN (
    SELECT e.student_id
    FROM enrollments e
    WHERE e.course_id IN (
        SELECT course_id FROM courses WHERE instructor = 'Dr. Smith'
    )
);

-- Employees whose salary matches any salary in department 30
SELECT first_name, last_name, salary
FROM employees
WHERE salary IN (SELECT salary FROM employees WHERE department_id = 30);