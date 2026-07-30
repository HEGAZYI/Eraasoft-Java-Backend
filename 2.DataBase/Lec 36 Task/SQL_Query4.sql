/*
✏️ 4. Renaming Constraints (Code Samples)
Rename a CHECK constraint named chk_age to check_min_age on the Students table.

Rename a FOREIGN KEY constraint fk_emp_dept to fk_employee_department on the Employees table.

Rename the PRIMARY KEY constraint on the Users table to pk_users_id.

Write SQL to rename the UNIQUE constraint on the username column to uk_user_name.

Provide the syntax to rename a constraint in SQL Server vs PostgreSQL.
*/

-- Rename CHECK chk_age → check_min_age on Students
ALTER TABLE Students DROP CHECK chk_age;
ALTER TABLE Students
ADD CONSTRAINT check_min_age CHECK (age >= 18);

-- Rename FOREIGN KEY fk_emp_dept → fk_employee_department on Employees
ALTER TABLE Employees DROP FOREIGN KEY fk_emp_dept;
ALTER TABLE Employees
ADD CONSTRAINT fk_employee_department
FOREIGN KEY (dept_id) REFERENCES Departments(dept_id);

-- Rename PRIMARY KEY on Users to pk_users_id
ALTER TABLE Users DROP PRIMARY KEY;
ALTER TABLE Users
ADD CONSTRAINT pk_users_id PRIMARY KEY (id);

-- Rename UNIQUE constraint on username to uk_user_name
ALTER TABLE Users DROP INDEX username;   -- or the actual index/constraint name
ALTER TABLE Users
ADD CONSTRAINT uk_user_name UNIQUE (username);