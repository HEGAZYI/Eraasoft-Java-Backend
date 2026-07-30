-- All departments + employees
SELECT d.department_name, e.first_name, e.last_name
FROM employees e
RIGHT OUTER JOIN departments d ON e.department_id = d.department_id;

-- All customers + orders
SELECT c.customer_name, o.order_id
FROM orders o
RIGHT JOIN customers c ON o.customer_id = c.customer_id;

-- All courses + enrolled students
SELECT c.course_name, s.student_name
FROM enrollments e
RIGHT OUTER JOIN courses c ON e.course_id = c.course_id
LEFT JOIN students s ON e.student_id = s.student_id;

-- All projects + employees
SELECT p.project_name, e.first_name, e.last_name
FROM employees e
RIGHT OUTER JOIN projects_assigned pa ON e.employee_id = pa.employee_id
RIGHT OUTER JOIN projects p ON pa.project_id = p.project_id;

-- All payment methods + transactions
SELECT pm.method_name, t.transaction_id
FROM transactions t
RIGHT JOIN payment_methods pm ON t.payment_method_id = pm.payment_method_id;

-- All authors + books
SELECT a.author_name, b.book_title
FROM books b
RIGHT OUTER JOIN authors a ON b.author_id = a.author_id;

-- All categories + products
SELECT c.category_name, p.product_name
FROM products p
RIGHT JOIN categories c ON p.category_id = c.category_id;

-- All dorm rooms + students
SELECT d.room_number, s.student_name
FROM students s
RIGHT OUTER JOIN dorm_rooms d ON s.dorm_id = d.dorm_id;