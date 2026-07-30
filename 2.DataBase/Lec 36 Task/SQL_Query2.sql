/*
🛠️ 2. Adding Constraints via ALTER TABLE (Code Samples)
Add a NOT NULL constraint to the email column in the Customers table.

Add a UNIQUE constraint to the username column in the Users table.

Add a FOREIGN KEY constraint on Orders.customer_id referencing Customers(id).

Use ALTER TABLE to add a CHECK constraint to the Accounts table to ensure balance >= 0.

Add a PRIMARY KEY constraint to the Departments table on the dept_id column.
*/

-- Add NOT NULL to email in Customers
ALTER TABLE Customers
MODIFY email VARCHAR(255) NOT NULL;

-- Add UNIQUE to username in Users
ALTER TABLE Users
ADD CONSTRAINT uk_username UNIQUE (username);

-- Add FOREIGN KEY on Orders.customer_id → Customers(id)
ALTER TABLE Orders
ADD CONSTRAINT fk_order_customer
FOREIGN KEY (customer_id) REFERENCES Customers(id);

-- Add CHECK (balance >= 0) to Accounts
ALTER TABLE Accounts
ADD CONSTRAINT chk_balance CHECK (balance >= 0);

-- Add PRIMARY KEY to Departments on dept_id
ALTER TABLE Departments
ADD CONSTRAINT pk_departments PRIMARY KEY (dept_id);