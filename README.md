# 🔐 SpringSec

A simple Spring Boot REST API demonstrating JWT-based authentication using Spring Security, JPA, and MySQL.

---

## 🚀 Features

- Stateless authentication using JWT (JSON Web Token)
- Secure REST APIs with Spring Security
- User registration and login
- Password encryption using BCrypt
- MySQL database integration using Spring Data JPA
- Clean and modular architecture

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- JWT (jjwt)
- MySQL
- Gradle

---

## 📁 Project Structure

```
src/main/java/org/example/springsec/

├── configuration/
│   ├── SecurityConfig.java
│   └── JwtFilter.java
│
├── services/
│   ├── JwtService.java
│   └── UserService.java
│
├── repository/
│   └── UserRepo.java
│
├── model/
│   └── Users.java
│
└── controller/
    └── AuthController.java
```

---

## ⚙️ Setup Instructions

### 1. Clone Repository

```bash
git clone https://github.com/your-username/springsec.git
cd springsec
```

---

### 2. Configure Database

Create MySQL database:

```sql
CREATE DATABASE springsecurity;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springsecurity
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3. Run Application

```bash
./gradlew bootRun
```

Windows:

```bash
gradlew.bat bootRun
```

---

## 🔑 API Endpoints

### ✅ Register

```
POST /register
```

**Request Body**
```json
{
  "id": 1,
  "username": "alice",
  "password": "password"
}
```

---

### 🔐 Login

```
POST /login
```

**Request Body**
```json
{
  "username": "alice",
  "password": "password"
}
```

**Response**
```
<JWT_TOKEN>
```

---

### 🔒 Protected API

```
GET /students
```

**Header**
```
Authorization: Bearer <JWT_TOKEN>
```

---

### 🌐 Public API

```
GET /
```

Response:
```
Hello World
```

---

## 🧠 How It Works

1. User registers → stored in MySQL
2. Login → credentials validated
3. JWT token generated
4. Requests pass through JwtFilter
5. Token validated → access granted

---

## 🔐 Security

- BCrypt password hashing
- Stateless authentication
- Custom JWT filter
- DaoAuthenticationProvider used

---

## 📌 Future Improvements

- Role-based access (Admin/User)
- Refresh tokens
- Swagger documentation
- Docker support
- Unit testing

---

## 🤝 Contributing

Pull requests are welcome!

---

## 📜 License

MIT License
