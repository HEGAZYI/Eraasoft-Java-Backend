-- 1. Employees + Departments
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
JOIN departments d USING (department_id);

-- 2. Orders + Customers
SELECT o.order_id, o.order_date, c.customer_name
FROM orders o
JOIN customers c USING (customer_id);

-- 3. Products + Suppliers
SELECT p.product_name, s.supplier_name
FROM products p
JOIN suppliers s USING (supplier_id);

-- 4. Students + Enrollments
SELECT s.student_name, e.course_id
FROM students s
JOIN enrollments e USING (student_id);

-- 5. Invoices + Products
SELECT i.invoice_number, p.product_name
FROM invoices i
JOIN products p USING (product_id);

-- 6. Projects + Employees
SELECT p.project_name, e.first_name, e.last_name
FROM projects p
JOIN project_assignments pa USING (project_id)
JOIN employees e USING (employee_id);

-- 7. Authors + Books
SELECT a.author_name, b.book_title
FROM authors a
JOIN books b USING (author_id);

-- 8. Sales orders + Employees
SELECT so.order_id, e.first_name, e.last_name
FROM sales_orders so
JOIN employees e USING (employee_id);

-- 9. Course schedules + Instructors
SELECT cs.schedule_id, i.instructor_name
FROM course_schedules cs
JOIN instructors i USING (instructor_id);

-- 10. Transactions + Account holders
SELECT t.transaction_id, a.account_holder_name
FROM transactions t
JOIN accounts a USING (account_id);