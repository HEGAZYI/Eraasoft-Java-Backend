# Item Service 911 – MySQL + Jakarta Servlet

## Database (MySQL)

1. In MySQL Workbench, select schema `employees` (or create one).
2. Run `sql/schema.sql` to create tables: `users`, `item`, `item_details`.

## Connection

Edit `src/main/webapp/META-INF/context.xml`:

- `username` / `password` → your MySQL user
- `url` → `jdbc:mysql://localhost:3306/employees?...` (change DB name if needed)

## Driver JAR

1. Download **mysql-connector-j-8.x.x.jar**
2. Put it in `src/main/webapp/WEB-INF/lib/`
3. Remove `ojdbc8.jar` (Oracle) if present

## Run

Tomcat 10.1 + project deployed →  
`http://localhost:8080/item-service-911/login.jsp`
