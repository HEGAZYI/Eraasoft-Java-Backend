/*
 3. Dropping (Removing) Constraints (Code Samples)
Drop a CHECK constraint named chk_salary from the Employees table.

Remove the UNIQUE constraint on email from the Users table.

Drop the PRIMARY KEY from the Products table.

Drop a FOREIGN KEY constraint named fk_order_customer from the Orders table.

Write SQL to remove a NOT NULL constraint from the phone column in the Contacts table.
*/
-- Drop CHECK constraint chk_salary from Employees
ALTER TABLE Employees
DROP CHECK chk_salary;

-- Remove UNIQUE constraint on email from Users
-- (MySQL requires the constraint name; if unknown, find it first)
ALTER TABLE Users
DROP INDEX email;          -- common when UNIQUE was created without explicit name
-- or, if named:
-- ALTER TABLE Users DROP INDEX uk_email;

-- Drop PRIMARY KEY from Products
ALTER TABLE Products
DROP PRIMARY KEY;

-- Drop FOREIGN KEY fk_order_customer from Orders
ALTER TABLE Orders
DROP FOREIGN KEY fk_order_customer;

-- Remove NOT NULL from phone in Contacts
ALTER TABLE Contacts
MODIFY phone VARCHAR(20) NULL;