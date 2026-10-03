<div align="center">

# 💰 Expense Tracker

### Track every rupee. Know where your money goes.

A clean, server-rendered expense tracker built with **Java**, **Spring Boot** and **Thymeleaf**. Add, edit and delete expenses and see your running total at a glance.

<br>

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white&style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.2-6DB33F?logo=springboot&logoColor=white&style=for-the-badge)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf&logoColor=white&style=for-the-badge)
![H2](https://img.shields.io/badge/Database-H2-1021FF?style=for-the-badge)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white&style=for-the-badge)

[![Stars](https://img.shields.io/github/stars/shivamjaiswal45/Expense-Tracker?style=flat-square&color=F59E0B)](https://github.com/shivamjaiswal45/Expense-Tracker/stargazers)
[![Forks](https://img.shields.io/github/forks/shivamjaiswal45/Expense-Tracker?style=flat-square&color=10B981)](https://github.com/shivamjaiswal45/Expense-Tracker/fork)

</div>

---

## 📖 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Architecture](#-architecture)
- [Routes](#-routes)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Using the H2 Console](#-using-the-h2-console)
- [Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [Author](#-author)

---

## 🌟 Overview

Expense Tracker is a small full-stack web application that lets you record what you spend and keep an eye on the total. It follows a classic layered **Spring MVC** design (controller, service, repository, model) with **Spring Data JPA** for persistence and **Thymeleaf** templates for the UI, so it is easy to read, run and extend.

It works well as a reference project for learning how a CRUD app is put together in Spring Boot.

---

## ✨ Features

| | Feature | Details |
| :-: | :--- | :--- |
| ➕ | **Add expenses** | Save a new expense with a description and an amount |
| ✏️ | **Edit expenses** | Update the description or amount of any existing entry |
| 🗑️ | **Delete expenses** | Remove an entry with a single click |
| 🧮 | **Automatic total** | The home page shows the combined total of all expenses, calculated with `BigDecimal` for accurate money math |
| 🗄️ | **Zero-setup database** | Uses an in-memory H2 database, so there is nothing to install |
| 🔍 | **Built-in H2 console** | Browse the database from your browser while developing |
| 🎨 | **Custom styling** | Hand-written CSS with a background image for a polished look |

---

## 🛠 Tech Stack

| Layer | Technology |
| :--- | :--- |
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.3.2 |
| **Web** | Spring MVC |
| **Templating** | Thymeleaf |
| **Persistence** | Spring Data JPA and Hibernate |
| **Database** | H2 (in-memory) |
| **Build tool** | Maven (wrapper included) |

---

## 🏛 Architecture

The app uses a standard layered structure:

```text
  Browser
     │
     ▼
┌─────────────────┐   renders    ┌──────────────────────┐
│ ExpenseController│ ───────────▶ │ Thymeleaf templates  │
└────────┬────────┘              │ index / add / update │
         │ calls                 └──────────────────────┘
         ▼
┌─────────────────┐
│  ExpenseService │   business logic
└────────┬────────┘
         ▼
┌─────────────────┐
│ExpenseRepository│   Spring Data JPA
└────────┬────────┘
         ▼
┌─────────────────┐
│   H2 Database   │   Expense(id, description, amount)
└─────────────────┘
```

**Data model:** each `Expense` has an auto-generated `id`, a `description` and an `amount`.

---

## 🧭 Routes

| Method | URL | Description |
| :---: | :--- | :--- |
| `GET` | `/` | Home page: lists all expenses and the total amount |
| `GET` | `/addExpense` | Shows the add-expense form |
| `POST` | `/saveExpense` | Saves a new expense, then redirects home |
| `GET` | `/editExpense/{id}` | Shows the edit form for an expense |
| `POST` | `/updateExpense/{id}` | Updates the expense, then redirects home |
| `GET` | `/deleteExpense/{id}` | Deletes the expense, then redirects home |

---

## 🗂 Project Structure

```text
Expense-Tracker/
├── .mvn/wrapper/                      # Maven wrapper files
├── src/
│   ├── main/
│   │   ├── java/com/example/expensetracker/
│   │   │   ├── ExpenseTrackerApplication.java   # Spring Boot entry point
│   │   │   ├── controller/
│   │   │   │   └── ExpenseController.java       # Routes and page logic
│   │   │   ├── model/
│   │   │   │   └── Expense.java                 # JPA entity
│   │   │   ├── repository/
│   │   │   │   └── ExpenseRepository.java       # Data access layer
│   │   │   └── service/
│   │   │       └── ExpenseService.java          # Business logic
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/style.css                # Styling
│   │       │   └── images/background.png        # Background image
│   │       ├── templates/
│   │       │   ├── index.html                   # Expense list and total
│   │       │   ├── add-expense.html             # Add form
│   │       │   └── update-expense.html          # Edit form
│   │       └── application.properties           # App and database config
│   └── test/                                    # Tests
├── mvnw / mvnw.cmd                    # Maven wrapper scripts
└── pom.xml                            # Dependencies and build config
```

---

## 🚀 Getting Started

**Prerequisites**

- **Java 17** or newer
- Any modern browser (Maven is not required, the wrapper is included)

**1. Clone the repository**

```bash
git clone https://github.com/shivamjaiswal45/Expense-Tracker.git
cd Expense-Tracker
```

**2. Run the application**

On macOS or Linux:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

You can also open the project in **IntelliJ IDEA** and run `ExpenseTrackerApplication`.

**3. Open the app**

Go to **http://localhost:8080** in your browser and start adding expenses.

> **Note:** the app uses an in-memory H2 database, so your data is cleared every time the application stops. To keep data between runs, switch to a file-based H2 database or MySQL/PostgreSQL (see the [Roadmap](#-roadmap)).

---

## 🔍 Using the H2 Console

The H2 web console is enabled so you can inspect the data while developing.

1. Start the app and open **http://localhost:8080/h2-console**
2. Enter these connection details:

| Field | Value |
| :--- | :--- |
| **JDBC URL** | `jdbc:h2:mem:testdb` |
| **User Name** | `sa` |
| **Password** | `password` |

3. Click **Connect** and run queries such as `SELECT * FROM EXPENSE;`

> These credentials are for local development only. Do not reuse them in a real deployment.

---

## 🗺 Roadmap

- [x] Add, edit and delete expenses
- [x] Automatic total calculation
- [x] Layered architecture with Spring Data JPA
- [ ] 📸 Add app screenshots to this README
- [ ] 🗂 Expense categories
- [ ] 📅 Date for each expense and filtering by date range
- [ ] ✅ Form validation with Bean Validation
- [ ] 💾 Persistent database (MySQL or PostgreSQL)
- [ ] 🔒 Switch delete to a `POST`/`DELETE` request with a confirmation prompt
- [ ] 📊 Charts and monthly summaries
- [ ] 🔐 User accounts and login

Have an idea? [Open an issue](https://github.com/shivamjaiswal45/Expense-Tracker/issues) and let's talk.

---

## 🤝 Contributing

Contributions are welcome!

1. **Fork** the project
2. **Create** a feature branch: `git checkout -b feature/amazing-feature`
3. **Commit** your changes: `git commit -m "Add amazing feature"`
4. **Push** to the branch: `git push origin feature/amazing-feature`
5. **Open** a Pull Request

---

## 👨‍💻 Author

**Shivam Jaiswal**

[![GitHub](https://img.shields.io/badge/GitHub-shivamjaiswal45-181717?style=flat-square&logo=github)](https://github.com/shivamjaiswal45)

---

<div align="center">

### If this project helped you learn something new, drop a ⭐. It means a lot!

<sub>Built with ☕, Java and a growing list of expenses.</sub>

</div>
