# 💳 E-Wallet Web Application

Professional secure e-wallet system built with **Java Servlets / JSP**, **MySQL**, and **BCrypt**.

Converted from the original console OOP project into a full dynamic web application.

---

## Features

| Feature | Description |
|---------|-------------|
| **Secure Auth** | Login / Signup / Logout with session management |
| **BCrypt** | Passwords hashed with cost factor 12 |
| **Deposit / Withdraw / Transfer** | Full wallet operations with atomic transfers |
| **Transaction History** | Per-user history with timestamps |
| **Profile & Change Password** | View details, update password securely |
| **Admin Panel** | View all accounts, activate/deactivate, delete |
| **Auth Filter** | Protects all private routes |
| **Input Validation** | Server-side validation (username, password, phone, age, amount) |
| **SQL Injection Protection** | Prepared statements everywhere |
| **Session Fixation Protection** | New session created on login |
| **HttpOnly cookies** | Configured in `web.xml` |

---

## Tech Stack

- **Java 17**
- **Jakarta Servlet 6 / JSP 3.1** (Tomcat 10+)
- **MySQL 8**
- **jBCrypt** for password hashing
- **Bootstrap 5** for UI
- **Maven** for build

---

## Project Structure

```
EwalletWebApp/
├── pom.xml
├── sql/
│   └── schema.sql
├── src/main/java/com/ewallet/
│   ├── model/          Account, Transaction
│   ├── dao/            AccountDAO, TransactionDAO
│   ├── service/        AuthService, WalletService
│   ├── servlet/        Login, Signup, Logout, Dashboard, ...
│   ├── filter/         AuthFilter
│   └── util/           DBConnection, PasswordUtil, ValidationUtil
└── src/main/webapp/
    ├── css/style.css
    └── WEB-INF/
        ├── web.xml
        └── views/      JSP pages
```

---

## Setup Instructions

### 1. Database (MySQL Workbench)

1. Open MySQL Workbench and connect to your local server.
2. Run the script: `sql/schema.sql`
3. Update credentials in:
   ```
   src/main/java/com/ewallet/util/DBConnection.java
   ```
   Change `USER` and `PASSWORD` to match your MySQL setup.

### 2. Build & Deploy

**Option A – Maven + Tomcat**

```bash
cd EwalletWebApp
mvn clean package
# Deploy target/EwalletWebApp.war to Tomcat 10+ webapps/
```

**Option B – IntelliJ IDEA**

1. Open the project as a Maven project.
2. Add Tomcat 10+ run configuration.
3. Deploy the artifact.

**Option C – Eclipse**

1. Import as Existing Maven Project.
2. Configure Tomcat 10+ server.
3. Run on server.

### 3. Create Admin Account

After first deploy, open in browser:

```
http://localhost:8080/EwalletWebApp/setup-admin
```

This creates (or resets) the admin user:

| Field    | Value      |
|----------|------------|
| Username | `Admin`    |
| Password | `Admin@123`|

**⚠️ Remove or protect the `/setup-admin` servlet in production!**

### 4. Login

```
http://localhost:8080/EwalletWebApp/login
```

---

## Validation Rules (same as original + extras)

| Field    | Rule |
|----------|------|
| Username | ≥ 3 chars, starts with **uppercase**, letters/digits/`_` only |
| Password | ≥ 6 chars, must contain upper + lower + digit |
| Phone    | Egyptian format: `01` + 9 digits |
| Age      | ≥ 18 |
| Amount   | > 0 and ≤ 1,000,000 |

---

## Security Highlights

1. **BCrypt** – passwords never stored in plain text
2. **PreparedStatement** – no SQL injection
3. **AuthFilter** – every private URL requires a valid session
4. **Session invalidation** on login (prevents session fixation)
5. **HttpOnly** session cookie
6. **Admin routes** blocked for non-admin users
7. Admin cannot deactivate/delete themselves
8. Inactive accounts cannot log in

---

## Default Admin

After running `/setup-admin`:

- **Username:** Admin  
- **Password:** Admin@123  

---

## License

Educational project – free to use and modify.
