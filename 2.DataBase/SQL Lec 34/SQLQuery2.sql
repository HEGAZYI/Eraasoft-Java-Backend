-- 1. Create Doctor table
CREATE TABLE Doctor (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    salary DECIMAL(10,2)
);

-- 2. Create Patient table
CREATE TABLE Patient (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT
);

-- 3. Many-to-Many relationship
CREATE TABLE DoctorPatient (
    doctor_id INT,
    patient_id INT,
    PRIMARY KEY (doctor_id, patient_id),

    -- Foreign Keys
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
    FOREIGN KEY (patient_id) REFERENCES Patient(id)
);