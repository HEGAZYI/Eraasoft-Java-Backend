-- 1. Employee names and manager names
SELECT CONCAT(e.first_name, ' ', e.last_name) AS employee_name,
       CONCAT(m.first_name, ' ', m.last_name) AS manager_name
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id;

-- 2. Customer names and salesperson names
SELECT c.name AS customer_name, e.name AS salesperson_name
FROM customers c
JOIN employees e ON c.salesperson_id = e.employee_id;

-- 3. Order IDs and product IDs
SELECT o.order_id, od.product_id
FROM orders o
JOIN order_details od ON o.order_id = od.order_id;

-- 4. Student names and instructor names
SELECT s.name AS student_name, i.name AS instructor_name
FROM students s
JOIN instructors i ON s.instructor_id = i.instructor_id;

-- 5. Employee salaries and department budgets
SELECT e.first_name, e.salary, d.department_name, d.budget
FROM employees e
JOIN departments d ON e.department_id = d.department_id;

-- 6. Project names and task names
SELECT p.name AS project_name, t.name AS task_name
FROM projects p
JOIN tasks t ON p.project_id = t.project_id;

-- 7. Courses and exams dates
SELECT c.course_name, c.start_date AS course_date, e.exam_date
FROM courses c
JOIN exams e ON c.course_id = e.course_id;

-- 8. Product name and category name
SELECT p.name AS product_name, c.name AS category_name
FROM products p
JOIN categories c ON p.category_id = c.category_id;

-- 9. Book title and publisher name
SELECT b.title AS book_title, p.name AS publisher_name
FROM books b
JOIN publishers p ON b.publisher_id = p.publisher_id;

-- 10. Employee names and department location
SELECT CONCAT(e.first_name, ' ', e.last_name) AS employee_name,
       d.location AS department_location
FROM employees e
JOIN departments d ON e.department_id = d.department_id;