-- All customers and all orders
SELECT c.customer_name, o.order_id
FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id
UNION
SELECT c.customer_name, o.order_id
FROM customers c
RIGHT JOIN orders o ON c.customer_id = o.customer_id;

-- All employees and all projects
SELECT e.first_name, e.last_name, p.project_name
FROM employees e
LEFT JOIN projects_assigned pa ON e.employee_id = pa.employee_id
LEFT JOIN projects p ON pa.project_id = p.project_id
UNION
SELECT e.first_name, e.last_name, p.project_name
FROM employees e
RIGHT JOIN projects_assigned pa ON e.employee_id = pa.employee_id
RIGHT JOIN projects p ON pa.project_id = p.project_id;

-- All products and all suppliers
SELECT p.product_name, s.supplier_name
FROM products p
LEFT JOIN suppliers s ON p.supplier_id = s.supplier_id
UNION
SELECT p.product_name, s.supplier_name
FROM products p
RIGHT JOIN suppliers s ON p.supplier_id = s.supplier_id;

-- All students and all courses
SELECT s.student_name, c.course_name
FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
LEFT JOIN courses c ON e.course_id = c.course_id
UNION
SELECT s.student_name, c.course_name
FROM students s
RIGHT JOIN enrollments e ON s.student_id = e.student_id
RIGHT JOIN courses c ON e.course_id = c.course_id;

-- All authors and all books
SELECT a.author_name, b.book_title
FROM authors a
LEFT JOIN books b ON a.author_id = b.author_id
UNION
SELECT a.author_name, b.book_title
FROM authors a
RIGHT JOIN books b ON a.author_id = b.author_id;

-- All employees and all departments
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id
UNION
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
RIGHT JOIN departments d ON e.department_id = d.department_id;

-- All transactions and all payment methods
SELECT t.transaction_id, pm.method_name
FROM transactions t
LEFT JOIN payment_methods pm ON t.payment_method_id = pm.payment_method_id
UNION
SELECT t.transaction_id, pm.method_name
FROM transactions t
RIGHT JOIN payment_methods pm ON t.payment_method_id = pm.payment_method_id;

-- Combine two customer lists (region1 & region2)
SELECT COALESCE(r1.customer_name, r2.customer_name) AS customer_name
FROM customers_region1 r1
LEFT JOIN customers_region2 r2 ON r1.customer_id = r2.customer_id
UNION
SELECT COALESCE(r1.customer_name, r2.customer_name) AS customer_name
FROM customers_region1 r1
RIGHT JOIN customers_region2 r2 ON r1.customer_id = r2.customer_id;