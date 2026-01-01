🏥 Insurance Claim Management System – Microservices Architecture

A Spring Boot–based Microservices Project that manages the complete lifecycle of insurance claims including creation, processing, and tracking using RESTful APIs.

This project demonstrates real-world backend development, microservices architecture, and clean coding practices.

📌 Project Overview

The Insurance Claim Management System is built using Spring Boot microservices where each service handles a specific responsibility.

🔹 Key Features:

Create insurance claims

Process submitted claims

Track claim status

Database persistence using MySQL

🧱 Microservices Architecture
InsuranceClaimMicroservice
│
├── create-claim-service
├── process-claim-service
├── track-claim-service
└── database-service


Each microservice:

Runs independently

Communicates via REST APIs

Follows clean layered architecture

⚙️ Tech Stack
🔹 Backend

Java 17

Spring Boot

Spring Web (REST APIs)

Spring Data JPA

JDBC

🔹 Database

MySQL

🔹 Tools

Maven

Postman

Git & GitHub

🧠 Architecture Flow
Client (Postman / Frontend)
        ↓
Create Claim Service
        ↓
Process Claim Service
        ↓
Track Claim Service
        ↓
Database (MySQL)

📂 Project Structure
src/main/java
│
├── controller     # REST Controllers
├── service        # Business Logic
├── repository     # Database Layer
├── model/entity   # Entity Classes
└── Application.java

🚀 How to Run the Project
✅ Prerequisites

Make sure you have:

Java 17+

Maven

MySQL

IntelliJ IDEA / Eclipse

Postman

🔧 Step 1: Clone Repository
git clone https://github.com/KaustubhPatil2004/InsuranceclaimMicroservice.git
cd InsuranceclaimMicroservice

🔧 Step 2: Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/insurance_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Create database:

CREATE DATABASE insurance_db;

▶️ Step 3: Run the Application

Run each microservice using:

mvn spring-boot:run


OR directly run from your IDE.

🧪 API Testing (Postman)
Method	Endpoint	Description
POST	/claims/create	Create new claim
GET	/claims/{id}	Track claim
PUT	/claims/process/{id}	Process claim
🧾 Sample JSON Request
{
  "claimId": 101,
  "policyHolder": "John Doe",
  "claimAmount": 45000,
  "status": "PENDING"
}

🛡️ Features

✔ Microservices architecture
✔ RESTful APIs
✔ Clean code structure
✔ Database integration
✔ Scalable design

📈 Future Enhancements

Spring Security + JWT

API Gateway

Service Discovery (Eureka)

Docker & Kubernetes

Frontend Integration

👨‍💻 Author

Kaustubh Patil
📌 Computer Science / IT Student
🔗 GitHub: https://github.com/KaustubhPatil2004

⭐ Support

If you like this project, don’t forget to ⭐ the repository!
