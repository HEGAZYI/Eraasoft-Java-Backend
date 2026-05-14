-- =========================================
-- Create Employees Table
-- =========================================
CREATE TABLE Employees_table (
    EmployeeID INT PRIMARY KEY,
    FIRST_NAME VARCHAR(50),
    LAST_NAME VARCHAR(50),
    DEPARTMENT VARCHAR(50),
    SALARY INT
);

-- =========================================
-- Insert 20 Rows
-- =========================================
INSERT INTO Employees_table VALUES
(1,  'Ahmed',   'Ali',      'IT',       5000),
(2,  'Bassem',  'Hassan',   'HR',       4500),
(3,  'Carlos',  'Mona',     'Finance',  7000),
(4,  'David',   'Samy',     'IT',       8000),
(5,  'Eman',    'Khaled',   'Sales',    3500),
(6,  'Farah',   'Nabil',    'HR',       4000),
(7,  'George',  'Adel',     'IT',       9000),
(8,  'Hany',    'Maher',    'Finance',  6000),
(9,  'Ibrahim', 'Mostafa',  'Sales',    3000),
(10, 'John',    'Doe',      'IT',       7500),
(11, 'Karim',   'Fathy',    'HR',       4200),
(12, 'Laila',   'Saeed',    'Finance',  5200),
(13, 'Mariam',  'Yasser',   'IT',       6100),
(14, 'Nader',   'Ramy',     'Sales',    3300),
(15, 'Omar',    'Tarek',    'HR',       4700),
(16, 'Peter',   'Nagy',     'Finance',  5800),
(17, 'Queen',   'Ali',      'IT',       8200),
(18, 'Rana',    'Mahmoud',  'Sales',    3900),
(19, 'Salma',   'Hesham',   'HR',       4100),
(20, 'Tamer',   'Ibrahim',  'IT',       6700);

-- =========================================
-- select task
-- =========================================
SELECT *
FROM Employees_table
WHERE FIRST_NAME BETWEEN 'a' AND 'c';