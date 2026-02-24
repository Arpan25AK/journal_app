# 📓 Journal App Backend REST API

A robust, scalable backend REST API designed to manage dynamic user journal entries. Built from the ground up using **Java** and **Spring Boot**, this application utilizes a clean N-Tier architecture, high-performance caching, and automated background tasks to ensure rapid data retrieval and a seamless user experience.

## 🏗️ Architecture & Design

This application strictly adheres to the standard Spring Boot layered architecture to process data efficiently:

* **Controller Layer (`@RestController`):** Intercepts incoming HTTP requests from the client, routes them to the appropriate service methods, and returns standardized JSON responses.
* **Service Layer (`@Service`):** Contains the core business logic. It handles data processing, complex operations (like cache invalidation), and triggers automated emails.
* **Repository Layer (`@Repository`):** Utilizes **Spring Data MongoDB** to handle direct database interactions and abstract away boilerplate queries.
* **Security Layer:** Implements **Spring Security** filters to intercept requests and ensure endpoints are protected from unauthorized access.
* **Background Processing:** Utilizes Spring's task execution thread pool to run automated jobs independently of the main web traffic.

## 🚀 Key Features

* **Secure Authentication:** Implemented **Spring Security** to protect sensitive journal endpoints, ensuring users can only access and modify their own personal data.
* **Beautiful Email Scheduling:** Configured automated Cron jobs using `@Scheduled` and `JavaMailSender` to send visually appealing, HTML-formatted email reminders and notifications to users in the background.
* **High-Performance Caching:** Integrated **Redis** to cache heavy API responses and user authentication data, drastically reducing database load and latency.
* **Smart Cache Invalidation:** Custom logic implemented to automatically delete stale cache entries (e.g., during password changes) ensuring absolute data consistency.
* **Complete CRUD Operations:** Create, Read, Update, and Delete journal entries effortlessly.
* **Advanced Update API:** A custom-built update endpoint designed to handle modifications of existing database records without overwriting omitted fields.
* **Document-Based Storage:** Leverages **MongoDB**'s schema-less document structure to store journal entries flexibly.

## 🛠️ Detailed Tech Stack

* **Core Language:** Java (JDK 17+)
* **Backend Framework:** Spring Boot 3.x
* **Security Module:** Spring Security
* **Background Tasks & Alerts:** Spring Scheduling (`@EnableScheduling`) & JavaMailSender (MimeMessage/HTML)
* **Caching Layer:** Redis & Spring Data Redis (Custom JSON Serialization)
* **Persistence Module:** Spring Data MongoDB
* **Database:** MongoDB
* **Containerization:** Docker (Redis Server)
* **Build Automation:** Maven
* **API Testing Tool:** Postman

## 📡 API Endpoints Reference

| HTTP Method | Endpoint | Action | Access |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/journals` | Retrieve a list of all journal entries. | Authenticated |
| `GET` | `/api/journals/{id}` | Retrieve a specific journal entry by its unique ID. | Authenticated |
| `POST` | `/api/journals` | Create and persist a new journal entry. | Authenticated |
| `PUT` | `/api/journals/{id}` | Update an existing journal entry (Full/Partial). | Authenticated |
| `DELETE` | `/api/journals/{id}` | Remove a journal entry from the database. | Authenticated |

### Example JSON Payload (POST / PUT)
```json
{
  "title": "Mastering Spring Boot & Redis",
  "content": "Today I implemented Spring Security, configured Redis caching, and set up automated HTML email schedules!",
  "date": "2025-12-29T10:00:00"
}

```

## ⚙️ Local Setup & Installation

### Prerequisites

* Java 17 or higher installed on your machine
* Maven installed
* **Docker** installed and running
* A running instance of MongoDB (Default port: `27017`)

### Steps to Run

1. **Clone the repository:**
```bash
git clone [https://github.com/Arpan25AK/journal_app.git](https://github.com/Arpan25AK/journal_app.git)
cd journal_app

```


2. **Spin up the Redis Cache via Docker:**
```bash
docker run -d --name redis-stack -p 6379:6379 redis/redis-stack-server:latest

```


3. **Configure the Environment Properties:**
Navigate to `src/main/resources/application.properties` (or `.yml`) and verify your connection strings and email SMTP credentials:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/journaldb
spring.data.redis.host=localhost
spring.data.redis.port=6379

# Email Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password

```


4. **Build and Execute:**
```bash
mvn clean install
mvn spring-boot:run

```


*The server will start locally on `http://localhost:8080`.*

## 👨‍💻 Author

**Arpan Anand Kotian**

* [LinkedIn](https://linkedin.com/in/arpan-a-k-104897364/)
* [GitHub](https://www.google.com/search?q=https://github.com/Arpan25AK)

```
