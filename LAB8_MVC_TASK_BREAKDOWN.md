# I did not understand — what exactly should I do?

Perfectly okay. Here is the **exact work** you need to finish and submit.

---

## What you must submit (2 files)
1. **ZIP** of your Spring Boot project code.
2. **PDF** with screenshot of running output UI.

Also, screenshot must include your name:
- Odd problem: show as **User Name**
- Even problem: show as **Author Name**

---

## Your lab in one line
Build a small website where you can:
- enter package details in a form,
- click submit,
- save to DB,
- and see all saved packages in a table below.

---

## What to build (exactly)

### 1) Model (Entity class)
Create class representing package record with fields:
- id (auto-generated)
- trackingId (must be unique)
- senderName
- receiverName
- destinationCity
- deliveryStatus (mandatory)
- createdTime (auto-generated)

### 2) Repository
Create JPA repository to store and fetch package records.

### 3) Service
Add business logic:
- reject duplicate trackingId,
- validate required fields,
- save package.

### 4) Controller
Create endpoints:
- `GET /` → open home page
- `POST /save` → save submitted form and return to home page

### 5) View (HTML page)
Single home page containing:
- Package registration form
- Package tracking table below form

Form fields required:
- Tracking ID
- Sender Name
- Receiver Name
- Destination City
- Delivery Status dropdown: Dispatched / In Transit / Delivered
- Submit button

Table columns required:
- ID
- Tracking ID
- Sender Name
- Receiver Name
- Destination City
- Delivery Status
- Created Time

---

## 30-minute execution plan

### 0–10 min
- Run project (`mvn spring-boot:run`)
- Open `http://localhost:8080`
- Confirm form + table appear.

### 10–20 min
- Add 2–3 sample package entries.
- Try duplicate trackingId and confirm error is shown.
- Try empty delivery status and confirm validation blocks save.

### 20–30 min
- Replace `YOUR_NAME_HERE` on page with your actual name.
- Take screenshot with your name visible.
- Create PDF from screenshot.
- Zip full project folder.
- Upload ZIP + PDF to submission form.

---

## Quick self-check before submit
- [ ] MVC layers are separate (Model, View, Controller, Service)
- [ ] `trackingId` is unique
- [ ] `deliveryStatus` cannot be empty
- [ ] `createdTime` auto-generated
- [ ] Data persists in DB
- [ ] Screenshot includes your name
- [ ] ZIP + PDF ready

