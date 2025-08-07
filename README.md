# 💰 Smart Expense Tracker

A Spring Boot backend application to manage personal expenses securely with JWT authentication, MySQL integration, and RESTful APIs. Designed to track, add, update, and delete expenses for authenticated users only.

---

## 🚀 Features

- 🔐 **User Registration & Login**
  - JWT-based secure authentication
  - BCrypt password encryption
- 📒 **Expense Management**
  - Add, update, delete, and list expenses
  - Expenses are tied to the logged-in user
- ✅ **Input Validation**
  - Validates fields like title, amount, date, etc.
- 🔧 **Global Exception Handling**
  - Custom structured error responses
- 🧪 **Swagger Integration**
  - Interactive API documentation at `/swagger-ui/index.html`
- 🔐 **Spring Security**
  - Protects endpoints with role-based access
- 🗂 **DTO Usage**
  - Clean separation between entities and client-facing objects
- 🔄 **ModelMapper**
  - Easy mapping between DTOs and Entities

---

## 🛠 Tech Stack

| Layer        | Tech                                 |
|--------------|---------------------------------------|
| Language     | Java 17                              |
| Backend      | Spring Boot 3.2.5                    |
| Database     | MySQL                                |
| Security     | Spring Security + JWT + BCrypt       |
| API Docs     | Swagger (springdoc-openapi)          |
| ORM          | Spring Data JPA + Hibernate          |
| Mapping      | ModelMapper                          |
| Testing      | JUnit, Mockito                       |
| Tools        | Lombok, Devtools, Maven              |

---

## 📁 Project Structure

```plaintext
src/
├── controller/          → AuthController, ExpenseController
├── service/             → AuthService, ExpenseService
├── entity/              → User, Expense
├── dto/                 → UserDTO, ExpenseDTO, ResponseDTO
├── repository/          → UserRepository, ExpenseRepository
├── security/            → JwtAuthFilter, SecurityConfig
├── util/                → JwtUtil
├── config/              → ModelMapperConfig
├── exception/           → GlobalExceptionHandler, custom exceptions

📄 API Endpoints
🔐 Authentication
Method	Endpoint	Description
POST	/auth/register	Register a user
POST	/auth/login	Login & get token

📒 Expenses
Method	Endpoint	Description
POST	/api/expenses/{userId}	Add expense (auth required)
PUT	/api/expenses/{expenseId}	Update expense
DELETE	/api/expenses/{expenseId}	Delete expense
GET	/api/expenses/user/{userId}	View expenses by user

⚙️ Setup Instructions
Clone the repository

git clone https://github.com/your-username/smart-expense-tracker.git
cd smart-expense-tracker
Configure the database

Set your DB credentials in application.properties

Build & Run

mvn clean install
mvn spring-boot:run
Access

Swagger UI: http://localhost:8081/swagger-ui/index.html

📸 Swagger Preview
<!-- Optional: include a screenshot -->

🤝 Contributing
Pull requests are welcome! If you’d like to contribute, feel free to fork the repo and submit a PR.

🧠 Future Enhancements
User roles (ADMIN, USER)
Monthly summaries / charts
Email notifications
Angular or React frontend

📜 License
This project is open-source and free to use.
