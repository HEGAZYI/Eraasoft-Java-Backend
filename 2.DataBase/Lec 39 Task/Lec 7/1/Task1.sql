-- 1. Employees and department names
SELECT first_name, last_name, department_name
FROM employees
NATURAL JOIN departments;

-- 2. Orders with customer names
SELECT order_id, order_date, customer_name
FROM orders
NATURAL JOIN customers;

-- 3. Student names and courses
SELECT student_name, course_name
FROM students
NATURAL JOIN enrollments
NATURAL JOIN courses;

-- 4. Project names and employees
SELECT project_name, first_name, last_name
FROM projects
NATURAL JOIN project_assignments
NATURAL JOIN employees;

-- 5. Invoice details with product names
SELECT invoice_id, invoice_date, product_name, quantity
FROM invoices
NATURAL JOIN invoice_items
NATURAL JOIN products;

-- 6. Books with author names
SELECT book_title, author_name
FROM books
NATURAL JOIN authors;

-- 7. Class schedules with instructor names
SELECT schedule_id, class_time, instructor_name
FROM class_schedules
NATURAL JOIN instructors;

-- 8. Supplier names and products
SELECT supplier_name, product_name
FROM suppliers
NATURAL JOIN products;

-- 9. Customer orders with shipping details
SELECT order_id, customer_name, shipping_address, shipping_date
FROM orders
NATURAL JOIN customers
NATURAL JOIN shipping;

-- 10. Employees with job titles
SELECT first_name, last_name, job_title
FROM employees
NATURAL JOIN jobs;