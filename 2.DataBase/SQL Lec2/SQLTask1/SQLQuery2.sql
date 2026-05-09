-- I used SQL Server Management Studio 20 to make tasks
-- It is better for me, thanks for attention


-- =========================================
-- Create Doctor table
-- =========================================
CREATE TABLE Doctor (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    salary DECIMAL(10,2),
    address VARCHAR(200)
);

-- =========================================
-- Insert 10 rows
-- =========================================
INSERT INTO Doctor VALUES
(1, 'Ahmed',   1000, 'Cairo'),
(2, 'Ali',     2000, 'Alex'),
(3, 'Mona',    3000, 'Mansoura'),
(4, 'Sara',    4000, 'Tanta'),
(5, 'Omar',    5000, 'Giza'),
(6, 'Nour',    6000, 'Aswan'),
(7, 'Khaled',  7000, 'Luxor'),
(8, 'Yara',    8000, 'Suez'),
(9, 'Hassan',  9000, 'Ismailia'),
(10,'Laila',  10000, 'Port Said');

-- =========================================
-- Update record number 3 salary
-- =========================================
UPDATE Doctor
SET salary = 20000
WHERE id = 3;

-- =========================================
-- Delete record number 9
-- =========================================
DELETE FROM Doctor
WHERE id = 9;

-- =========================================
-- Concatenate name with salary
-- =========================================
SELECT 
    name + ' - ' + CAST(salary AS VARCHAR) AS Name_Salary
FROM Doctor;

-- =========================================
-- Display all records with salary * 2
-- =========================================
SELECT 
    id,
    name,
    salary,
    salary * 2 AS Double_Salary,
    address
FROM Doctor;

-- =========================================
-- Select records with salary 1000, 2000, 3000
-- =========================================
SELECT *
FROM Doctor
WHERE salary IN (1000, 2000, 3000);

-- =========================================
-- Rename table Doctor to PRD_DOCTOR
-- =========================================
EXEC sp_rename 'Doctor', 'PRD_DOCTOR';