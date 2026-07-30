/*
✅ 6. Enabling Constraints (Code Samples)
Enable the FOREIGN KEY constraint fk_customer_order on the Orders table.

Re-enable all constraints on the Products table after a data load.

Write SQL to enable a CHECK constraint on salary in the Staff table.

Enable the PRIMARY KEY constraint on Departments(dept_id) after it was disabled.

How do you enable a constraint only if it's currently disabled?
*/

-- Enable the FOREIGN KEY fk_customer_order
SET FOREIGN_KEY_CHECKS = 1;
-- (or re-add the constraint if it was dropped)
ALTER TABLE Orders
ADD CONSTRAINT fk_customer_order
FOREIGN KEY (customer_id) REFERENCES Customers(id);

-- Re-enable all constraints on Products after data load
SET FOREIGN_KEY_CHECKS = 1;
SET UNIQUE_CHECKS = 1;

-- Enable CHECK constraint on salary in Staff
-- (re-create it)
ALTER TABLE Staff
ADD CONSTRAINT chk_salary CHECK (salary BETWEEN 3000 AND 10000);

-- Enable PRIMARY KEY on Departments(dept_id)
ALTER TABLE Departments
ADD CONSTRAINT pk_departments PRIMARY KEY (dept_id);

-- Enable a constraint only if it is currently disabled
-- MySQL has no built-in “IF DISABLED” syntax.
-- Practical approach:
-- 1. Check information_schema
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = DATABASE()
  AND TABLE_NAME = 'Orders'
  AND CONSTRAINT_NAME = 'fk_customer_order';

-- 2. If missing → add it
ALTER TABLE Orders
ADD CONSTRAINT fk_customer_order
FOREIGN KEY (customer_id) REFERENCES Customers(id);