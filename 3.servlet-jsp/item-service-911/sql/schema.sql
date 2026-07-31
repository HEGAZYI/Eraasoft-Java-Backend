-- Run in MySQL Workbench against your schema (e.g. employees or item_service)
-- CREATE DATABASE IF NOT EXISTS item_service;
-- USE item_service;

DROP TABLE IF EXISTS item_details;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    username      VARCHAR(50)  NOT NULL UNIQUE,
    email         VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    full_name     VARCHAR(100),
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE item (
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(100) NOT NULL UNIQUE,
    price         DECIMAL(12,2) NOT NULL,
    total_number  INT NOT NULL,
    user_id       BIGINT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT chk_price_positive CHECK (price > 0),
    CONSTRAINT chk_total_number_nonneg CHECK (total_number >= 0),
    CONSTRAINT fk_item_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE item_details (
    id               BIGINT PRIMARY KEY AUTO_INCREMENT,
    item_id          BIGINT NOT NULL UNIQUE,
    description      VARCHAR(1000),
    category         VARCHAR(100),
    manufacturer     VARCHAR(100),
    warranty_months  INT DEFAULT 0,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_details_item FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE CASCADE,
    CONSTRAINT chk_warranty_nonneg CHECK (warranty_months >= 0)
);
