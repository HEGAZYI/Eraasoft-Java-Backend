-- 1. Create Employee table
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    name VARCHAR(100),
	age INT 
);

-- 2. Create Phone table
CREATE TABLE Phone (
    id INT PRIMARY KEY,
    phoneNumber VARCHAR(20),

	-- FK (Each Employee Has One Phone Number )
	employeeId INT UNIQUE,
    

    FOREIGN KEY (employeeId) REFERENCES Employee(id)
);