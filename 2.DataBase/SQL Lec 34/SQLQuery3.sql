-- 1. Create Language table
CREATE TABLE Language (
    id INT PRIMARY KEY,
    name VARCHAR(100)
);

-- 2. Create Teacher table
CREATE TABLE Teacher (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    salary DECIMAL(10,2),

    -- FK (Each teacher has one language)
    language_id INT,

    FOREIGN KEY (language_id) REFERENCES Language(id)
);