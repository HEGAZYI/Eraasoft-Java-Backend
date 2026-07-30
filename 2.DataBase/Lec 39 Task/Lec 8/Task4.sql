-- 1. Create the user
CREATE USER 'yourname'@'localhost' IDENTIFIED BY 'yourpassword';

-- 2. Grant privileges
GRANT CREATE ON *.* TO 'yourname'@'localhost';          -- needed to create tables
GRANT SELECT, INSERT, UPDATE, DELETE ON *.* TO 'yourname'@'localhost';

-- Apply the privileges
FLUSH PRIVILEGES;

-- 3. Connect as the new user and create the Student table
-- (In MySQL Workbench: open a new connection with the new user)

CREATE TABLE Student (
    id   INT PRIMARY KEY,
    name VARCHAR(100)
);

-- Insert
INSERT INTO Student (id, name) VALUES (1, 'Ali');
INSERT INTO Student (id, name) VALUES (2, 'Mona');

-- Select
SELECT * FROM Student;

-- Update
UPDATE Student SET name = 'Ali Mohamed' WHERE id = 1;

-- Delete
DELETE FROM Student WHERE id = 2;

-- 4. Revoke all privileges
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'yourname'@'localhost';

-- Optional: Drop the user completely
-- DROP USER 'yourname'@'localhost';