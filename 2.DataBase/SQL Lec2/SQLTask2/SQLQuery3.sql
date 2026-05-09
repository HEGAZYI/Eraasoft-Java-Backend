-- I used SQL Server Management Studio 20 to make tasks
-- It is better for me, thanks for attention


-- =========================================
-- Create Employees table
-- =========================================
CREATE TABLE Employees1 (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10,2)
);

-- =========================================
-- Insert records
-- =========================================
INSERT INTO Employees1 VALUES
(101, 'John1', 'Doe1', 'HR', 20000),
(102, 'John2', 'Doe2', 'IT', 50000),
(103, 'John3', 'Doe3', 'CS', 40000),
(104, 'John4', 'Doe4', 'IT', 10000),
(105, 'John5', 'Doe5', 'ZX', 30000);

-- =========================================
-- Update salary for EmployeeID 101
-- =========================================
UPDATE Employees1
SET Salary = 600000
WHERE EmployeeID = 101;

-- =========================================
-- Delete employee with EmployeeID = 101
-- (Department = 101 is invalid because Department is text)
-- =========================================
DELETE FROM Employees1
WHERE EmployeeID = 101;

-- =========================================
-- Retrieve all employees in IT department
-- =========================================
SELECT *
FROM Employees1
WHERE Department = 'IT';

-- =========================================
-- Select all data with concatenated name
-- =========================================
SELECT 
    EmployeeID,
    FirstName + ' ' + LastName AS FullName,
    Department,
    Salary
FROM Employees1;