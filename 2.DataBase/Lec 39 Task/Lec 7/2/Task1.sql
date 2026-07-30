-- All employees + department names
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
LEFT OUTER JOIN departments d ON e.department_id = d.department_id;

-- All products + categories
SELECT p.product_name, c.category_name
FROM products p
LEFT JOIN categories c ON p.category_id = c.category_id;

-- All students + courses
SELECT s.student_name, c.course_name
FROM students s
LEFT OUTER JOIN enrollments e ON s.student_id = e.student_id
LEFT OUTER JOIN courses c ON e.course_id = c.course_id;

-- All orders + customer names
SELECT o.order_id, o.order_date, c.customer_name
FROM orders o
LEFT JOIN customers c ON o.customer_id = c.customer_id;

-- All departments + managers
SELECT d.department_name, CONCAT(e.first_name, ' ', e.last_name) AS manager_name
FROM departments d
LEFT OUTER JOIN employees e ON d.manager_id = e.employee_id;

-- All books + authors
SELECT b.book_title, a.author_name
FROM books b
LEFT JOIN authors a ON b.author_id = a.author_id;

-- All invoices + payment status
SELECT i.invoice_id, i.amount, p.status
FROM invoices i
LEFT JOIN payments p ON i.invoice_id = p.invoice_id;

-- All employees + projects
SELECT e.first_name, e.last_name, p.project_name
FROM employees e
LEFT OUTER JOIN projects_assigned pa ON e.employee_id = pa.employee_id
LEFT OUTER JOIN projects p ON pa.project_id = p.project_id;