/* 
✅ 1. CHECK Constraint (Code Samples)
Create a table Employees with a CHECK constraint that ensures age is greater than or equal to 18.

Write a SQL query to enforce that salary in a Staff table must be between 3000 and 10000.

Add a CHECK constraint to an existing table Products that ensures price is greater than 0.

Create a table Students where the grade column only allows values from A to F using a CHECK constraint.
*/
-- Create Employees table with CHECK (age >= 18)
CREATE TABLE Employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    CONSTRAINT chk_age CHECK (age >= 18)
);

-- Enforce salary between 3000 and 10000 in Staff table
CREATE TABLE Staff (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    salary DECIMAL(10,2),
    CONSTRAINT chk_salary CHECK (salary BETWEEN 3000 AND 10000)
);

-- Add CHECK constraint to existing Products table (price > 0)
ALTER TABLE Products
ADD CONSTRAINT chk_price CHECK (price > 0);

-- Students table: grade only A–F
CREATE TABLE Students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    grade CHAR(1),
    CONSTRAINT chk_grade CHECK (grade IN ('A','B','C','D','E','F'))
);