-- 1. Create Player table
CREATE TABLE Player (
    id INT NOT NULL UNIQUE,      
    name VARCHAR(100) UNIQUE,    
    age INT                      
);

-- 2. Create Manager table
CREATE TABLE Manager (
    id INT NOT NULL,            
    name VARCHAR(100),           
    salary DECIMAL(10,2),        

 
    UNIQUE (id, name)
);

-- 3. Create Manager table
CREATE TABLE Manager (
    id INT PRIMARY KEY,           
    name VARCHAR(100),           
    age INT                    
);