-- Employees earning more than average salary
SELECT first_name, last_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- Customers with the highest number of orders
SELECT customer_id, customer_name
FROM customers
WHERE customer_id IN (
    SELECT customer_id
    FROM orders
    GROUP BY customer_id
    HAVING COUNT(*) = (
        SELECT MAX(cnt)
        FROM (SELECT COUNT(*) AS cnt FROM orders GROUP BY customer_id) AS t
    )
);

-- Products more expensive than any product in 'Accessories'
SELECT product_name, price
FROM products
WHERE price > ANY (
    SELECT price FROM products WHERE category = 'Accessories'
);

-- Employees in the same department as 'John Smith'
SELECT first_name, last_name
FROM employees
WHERE department_id = (
    SELECT department_id FROM employees
    WHERE first_name = 'John' AND last_name = 'Smith'
);

-- Orders from customers in 'New York'
SELECT *
FROM orders
WHERE customer_id IN (
    SELECT customer_id FROM customers WHERE city = 'New York'
);

-- Departments with no employees
SELECT department_name
FROM departments d
WHERE NOT EXISTS (
    SELECT 1 FROM employees e WHERE e.department_id = d.department_id
);

-- Students not enrolled in any course
SELECT student_name
FROM students s
WHERE NOT EXISTS (
    SELECT 1 FROM enrollments e WHERE e.student_id = s.student_id
);

-- Second highest salary
SELECT MAX(salary) AS second_highest
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);

-- Products above average price
SELECT product_name, price
FROM products
WHERE price > (SELECT AVG(price) FROM products);

-- Customers who ordered all products in category 'A'
SELECT c.customer_name
FROM customers c
WHERE NOT EXISTS (
    SELECT 1
    FROM products p
    WHERE p.category = 'A'
      AND NOT EXISTS (
          SELECT 1
          FROM order_details od
          JOIN orders o ON od.order_id = o.order_id
          WHERE o.customer_id = c.customer_id
            AND od.product_id = p.product_id
      )
);