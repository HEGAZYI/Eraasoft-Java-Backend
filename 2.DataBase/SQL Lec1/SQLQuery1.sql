-- I used SQL Server Management Studio 20 to make tasks
-- It is better for me, thanks for attention

-- =========================================
-- Create table Manager
-- =========================================
CREATE TABLE Manager (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    birth_date DATE,
    address VARCHAR(200)
);

-- =========================================
-- Drop address column
-- =========================================
ALTER TABLE Manager
DROP COLUMN address;

-- =========================================
-- Add new columns
-- =========================================
ALTER TABLE Manager
ADD city_address VARCHAR(100),
    street VARCHAR(100);

-- =========================================
-- Modify column name -> full_name
-- =========================================
EXEC sp_rename 'Manager.name', 'full_name', 'COLUMN';

-- =========================================
-- Make table read only
-- (deny insert, update, delete)
-- =========================================
CREATE VIEW ReadOnly_Manager AS
SELECT * FROM Manager;

-- =========================================
-- Create Owner table from Manager
-- with only selected columns
-- =========================================
SELECT 
    id,
    full_name,
    birth_date
INTO Owner
FROM Manager
WHERE 1 = 0;

-- =========================================
-- Rename Manager table to Master
-- =========================================
EXEC sp_rename 'Manager', 'Master';

-- =========================================
-- Drop all tables
-- =========================================
DROP TABLE Owner;
DROP TABLE Master;