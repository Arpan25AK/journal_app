# 📓 Journal App Backend REST API

A robust, scalable backend REST API designed to manage dynamic user journal entries. Built from the ground up using **Java** and **Spring Boot**, this application utilizes a clean N-Tier architecture to ensure maintainability, clear separation of concerns, and seamless data flow.

## 🏗️ Architecture & Design

This application strictly adheres to the standard Spring Boot layered architecture to process data efficiently:

* **Controller Layer (`@RestController`):** Intercepts incoming HTTP requests from the client, routes them to the appropriate service methods, and returns standardized JSON responses alongside the correct HTTP status codes.
* **Service Layer (`@Service`):** Contains the core business logic. It acts as a bridge between the Controller and the Repository, ensuring data is processed, validated, and formatted correctly before interacting with the database.
* **Repository Layer (`@Repository`):** Utilizes **Spring Data MongoDB** (`MongoRepository`) to handle direct database interactions and abstract away boilerplate queries.

## 🚀 Key Features

* **Complete CRUD Operations:** Create, Read, Update, and Delete journal entries effortlessly.
* **Advanced Update API:** A custom-built update endpoint designed to handle modifications of existing database records, ensuring data integrity without overwriting omitted fields.
* **Document-Based Storage:** Leverages **MongoDB**'s schema-less document structure to store journal entries flexibly, mapping Java POJOs directly to MongoDB Collections.
* **RESTful Principles:** Predictable, resource-oriented URLs utilizing proper HTTP verbs.

## 🛠️ Detailed Tech Stack

* **Core Language:** Java (JDK 17+)
* **Backend Framework:** Spring Boot 3.x
* **Web Module:** Spring Web (for REST API and JSON serialization)
* **Persistence Module:** Spring Data MongoDB
* **Database:** MongoDB (Local / Atlas)
* **Build Automation:** Maven
* **API Testing Tool:** Postman

## 📡 API Endpoints Reference

| HTTP Method | Endpoint | Action |
| :--- | :--- | :--- |
| `GET` | `/api/journals` | Retrieve a list of all journal entries. |
| `GET` | `/api/journals/{id}` | Retrieve a specific journal entry by its unique ID. |
| `POST` | `/api/journals` | Create and persist a new journal entry. |
| `PUT` | `/api/journals/{id}` | Update an existing journal entry (Full/Partial). |
| `DELETE` | `/api/journals/{id}` | Remove a journal entry from the database. |

### Example JSON Payload (POST / PUT)
```json
{
  "title": "Mastering Spring Boot",
  "content": "Today I implemented a clean service layer and a custom update API using MongoDB.",
  "date": "2025-12-29T10:00:00"
}

```

## ⚙️ Local Setup & Installation

### Prerequisites

* Java 17 or higher installed on your machine
* Maven installed
* A running instance of MongoDB (Default port: `27017`)

### Steps to Run

1. **Clone the repository:**
```bash
git clone [https://github.com/Arpan25AK/journal_app.git](https://github.com/Arpan25AK/journal_app.git)
cd journal_app

```


2. **Configure the Database Connection:**
Navigate to `src/main/resources/application.properties` (or `.yml`) and verify your MongoDB connection string:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/journaldb

```


3. **Build and Execute:**
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
