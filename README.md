# Smart Package Delivery Tracking System (MVC Lab)

This is a ready-to-run Spring Boot MVC project for the OOAD lab statement.

## Run
```bash
mvn spring-boot:run
```
Open app: `http://localhost:8080/`

## H2 Console (SQL CRUD)
Open: `http://localhost:8080/h2-console`

Use these login values:
- Driver Class: `org.h2.Driver`
- JDBC URL: `jdbc:h2:file:./data/package_tracker_db`
- User Name: `sa`
- Password: *(leave empty)*

After login, you can run SQL like:
```sql
SELECT * FROM PACKAGES;
```

## What is implemented
- Model: `PackageRecord`
- Repository: `PackageRepository`
- Service: `PackageService`
- Controller: `PackageController`
- View: `templates/index.html`
- DB: H2 file database (persists at `./data/package_tracker_db`)

## Required demo checks
1. Add a package from form -> row appears in table.
2. Add same tracking ID again -> duplicate blocked.
3. Submit without status -> validation error.
4. Open H2 console and query `PACKAGES` table.

## Submission
1. In `index.html`, replace `YOUR_NAME_HERE` with your real name.
2. Take screenshot while app is running.
3. Create PDF from screenshot.
4. Zip complete project and submit ZIP + PDF.
