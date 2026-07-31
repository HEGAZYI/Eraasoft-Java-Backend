-- ============================================================
-- E-Wallet System Database Schema
-- MySQL Workbench compatible
-- ============================================================

CREATE DATABASE IF NOT EXISTS ewallet_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE ewallet_db;

-- Accounts table
CREATE TABLE IF NOT EXISTS accounts (
    id            INT AUTO_INCREMENT PRIMARY KEY,
    username      VARCHAR(50)  NOT NULL UNIQUE,
    password_hash VARCHAR(60)  NOT NULL,          -- BCrypt hash
    phone_number  VARCHAR(15)  NOT NULL UNIQUE,
    age           INT          NOT NULL,
    balance       DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    is_admin      TINYINT(1)   NOT NULL DEFAULT 0,
    is_active     TINYINT(1)   NOT NULL DEFAULT 1,
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    CONSTRAINT chk_age      CHECK (age >= 18),
    CONSTRAINT chk_balance  CHECK (balance >= 0),
    INDEX idx_username (username),
    INDEX idx_phone (phone_number)
) ENGINE=InnoDB;

-- Transactions table
CREATE TABLE IF NOT EXISTS transactions (
    id            INT AUTO_INCREMENT PRIMARY KEY,
    account_id    INT          NOT NULL,
    username      VARCHAR(50)  NOT NULL,
    type          ENUM('SIGNUP','LOGIN','DEPOSIT','WITHDRAW','TRANSFER','PASSWORD_CHANGE') NOT NULL,
    amount        DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    details       VARCHAR(255),
    related_user  VARCHAR(50)  NULL,              -- for transfers
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE,
    INDEX idx_username (username),
    INDEX idx_type (type),
    INDEX idx_created (created_at)
) ENGINE=InnoDB;

-- ============================================================
-- After deploying the app, visit:
--   http://localhost:8080/EwalletWebApp/setup-admin
-- to create the default Admin account (password: Admin@123)
-- ============================================================
