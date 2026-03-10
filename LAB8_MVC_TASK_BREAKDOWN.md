# Lab 8 (MVC) — What You Need To Do

## 1) Build a Spring Boot MVC web app
Create a **Smart Package Delivery Tracking System** using:
- Spring Boot (MVC architecture)
- Hibernate/JPA
- Relational DB (MySQL or H2)

You should run it at `http://localhost:8080/`.

## 2) Implement the MVC layers clearly

### Model (Entity)
Create a `Package` entity with fields:
- `id` (auto-generated primary key)
- `trackingId` (**unique**)
- `senderName`
- `receiverName`
- `destinationCity`
- `deliveryStatus` (required)
- `createdTime` (auto-generated when saved)

Use proper JPA annotations such as `@Entity`, `@Id`, `@GeneratedValue`, `@Column(unique = true)`.

### Controller
Implement endpoints:
- `GET /` → show home page with form + package table
- `POST /save` → validate and save package, then refresh page

Controller should pass data to service layer and return view templates.

### Service Layer
Business logic required:
- reject duplicate `trackingId`
- ensure mandatory fields are non-empty (especially `deliveryStatus`)
- set `createdTime` automatically

### View (UI)
Home page must contain package registration form with:
- Tracking ID
- Sender Name
- Receiver Name
- Destination City
- Delivery Status dropdown (`Dispatched`, `In Transit`, `Delivered`)
- Submit button

Below the form, show a table listing all records:
- ID
- Tracking ID
- Sender Name
- Receiver Name
- Destination City
- Delivery Status
- Created Time

## 3) CRUD expectations
Minimum required operations from statement:
- **Create** package record
- **Read** all packages
- **Read** package by `trackingId`

(You can keep update/delete optional unless your instructor asked explicitly.)

## 4) Validation + persistence checks
Your app should demonstrate:
- package registration works
- list view works
- duplicate tracking ID is blocked
- delivery status is mandatory
- data persists in DB (restart-safe if using file-based DB/MySQL)

## 5) Submission package required
You must submit:
1. **ZIP file** with complete source code in proper directory structure (Model, View, Controller, Service, Repository, configs, templates, etc.)
2. **PDF file** containing screenshot(s) of UI/output

Important screenshot note from prompt:
- Your name must appear in screenshot as:
  - **User Name** for Odd problem
  - **Author Name** for Even problem

## 6) Rubric alignment checklist (from shared image)
To score well, ensure:
- MVC separation is clean (Model / View / Controller)
- JPA mapping is correct with auto-generated ID
- Controller endpoints are correctly implemented and return proper responses
- Service layer has business logic separation
- UI form submits and table displays DB data
- DB integration with Hibernate/JPA persists records correctly

## 7) Suggested directory structure
A typical layout:
- `src/main/java/.../model/Package.java`
- `src/main/java/.../repository/PackageRepository.java`
- `src/main/java/.../service/PackageService.java`
- `src/main/java/.../controller/PackageController.java`
- `src/main/resources/templates/index.html`
- `src/main/resources/application.properties`

## 8) Final pre-submission checklist
- App runs on localhost:8080
- Form submit saves to DB
- Table shows newly added record
- Duplicate tracking ID test performed
- Empty delivery status blocked
- Screenshot includes your name as required
- ZIP generated successfully
- PDF with output screenshot generated successfully
- Submission uploaded to given Google Form before deadline
