/*
🚫 5. Disabling Constraints (Code Samples)
Disable a FOREIGN KEY constraint named fk_customer_order on the Orders table.

Temporarily disable all constraints on the Products table.

Write SQL to disable the CHECK constraint on the Accounts.balance column.

Disable the PRIMARY KEY constraint on Departments(dept_id).

How would you disable all constraints on a table before bulk inserting data?
*/

-- Disable a FOREIGN KEY (session-level)
SET FOREIGN_KEY_CHECKS = 0;

-- Temporarily disable all constraints on Products
-- (MySQL does not support table-level DISABLE CONSTRAINT.
--  Common practice for bulk load:)
SET FOREIGN_KEY_CHECKS = 0;
SET UNIQUE_CHECKS = 0;
-- then do the bulk insert
-- finally re-enable:
SET FOREIGN_KEY_CHECKS = 1;
SET UNIQUE_CHECKS = 1;

-- Disable CHECK constraint on Accounts.balance
-- MySQL 8.0.16+ supports CHECK, but you cannot disable an individual CHECK.
-- Workaround: drop it and recreate later
ALTER TABLE Accounts DROP CHECK chk_balance;

-- Disable PRIMARY KEY on Departments(dept_id)
-- Not directly possible. You must drop it:
ALTER TABLE Departments DROP PRIMARY KEY;

-- How to disable all constraints before bulk insert
SET FOREIGN_KEY_CHECKS = 0;
SET UNIQUE_CHECKS = 0;
-- (optionally also disable triggers if needed)
-- LOAD DATA / INSERT ...
SET FOREIGN_KEY_CHECKS = 1;
SET UNIQUE_CHECKS = 1;