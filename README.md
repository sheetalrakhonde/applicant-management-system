# Applicant Management System

A RESTful backend application built using **Java, Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL** to manage applicant information through CRUD (Create, Read, Update, Delete) operations.

## Overview

The Applicant Management System provides REST APIs for creating, retrieving, updating, and deleting applicant records. It demonstrates the development of a backend application using Spring Boot and PostgreSQL.

The project follows a layered architecture to separate HTTP request handling, business logic, database access, and entity management.

## Features

- Create new applicant records.
- Retrieve all applicants.
- Retrieve an applicant by ID.
- Update existing applicant information.
- Delete applicant records.
- Store applicant data in PostgreSQL.
- Map Java objects to database tables using Hibernate.
- Validate applicant information using Jakarta Validation.
- Expose RESTful APIs for client applications.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Backend programming language |
| Spring Boot | Backend application framework |
| Spring Web | REST API development |
| Spring Data JPA | Database access and repository management |
| Hibernate | Object-relational mapping (ORM) |
| PostgreSQL | Relational database |
| Maven | Dependency management and build automation |
| Lombok | Reduces boilerplate Java code |
| Jakarta Validation | Input validation |
| Git | Version control |
| GitHub | Source code hosting |

## Architecture

The application follows a layered architecture.

```text
                Client
                  |
                  | HTTP Requests
                  v
        +----------------------+
        |  Controller Layer    |
        | ApplicantController  |
        +----------------------+
                  |
                  v
        +----------------------+
        |    Service Layer     |
        |   ApplicantService   |
        +----------------------+
                  |
                  v
        +----------------------+
        |   Repository Layer   |
        |  ApplicantRepository |
        +----------------------+
                  |
                  v
        +----------------------+
        |  PostgreSQL Database |
        +----------------------+
```

### Architecture Components

**1. Controller Layer**

Handles incoming HTTP requests and exposes REST endpoints for applicant management.

**2. Service Layer**

Contains the application's business logic and coordinates operations between the controller and repository.

**3. Repository Layer**

Uses Spring Data JPA to interact with the database and perform persistence operations.

**4. Entity Layer**

Defines the `Applicant` entity, which maps Java objects to records in the database.

**5. Database Layer**

PostgreSQL stores applicant information persistently.

## Database Design

The application uses PostgreSQL as its relational database.

### Applicant Table

The applicant entity maps to the `applicant_table` database table.

| Column | Description |
|---|---|
| `app_id` | Primary key; generated automatically |
| `fname` | Applicant's first name |
| `lname` | Applicant's last name |
| `email` | Applicant's email address; unique |
| `phone` | Applicant's phone number |
| `bdate` | Applicant's birth date |

### Entity Relationships

The current applicant management module uses a single applicant entity. Relationships with other entities, such as institutions, courses, or applications, can be introduced as the system expands.

## REST API Documentation

### Base URL

```text
http://localhost:8080/api/applicants
```

### Available Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/applicants` | Create a new applicant |
| `GET` | `/api/applicants` | Retrieve all applicants |
| `GET` | `/api/applicants/{id}` | Retrieve an applicant by ID |
| `PUT` | `/api/applicants/{id}` | Update an applicant |
| `DELETE` | `/api/applicants/{id}` | Delete an applicant |

### 1. Create an Applicant

**Method:** `POST`

**Endpoint:**

```text
/api/applicants
```

**Request Body:**

```json
{
  "firstName": "Aarav",
  "lastName": "Sharma",
  "email": "aarav@example.com",
  "phone": "9876543210",
  "birthDate": "2003-05-15"
}
```

**cURL Example:**

```bash
curl -X POST http://localhost:8080/api/applicants \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Aarav",
    "lastName": "Sharma",
    "email": "aarav@example.com",
    "phone": "9876543210",
    "birthDate": "2003-05-15"
  }'
```

### 2. Retrieve All Applicants

**Method:** `GET`

**Endpoint:**

```text
/api/applicants
```

**cURL Example:**

```bash
curl http://localhost:8080/api/applicants
```

### 3. Retrieve an Applicant by ID

**Method:** `GET`

**Endpoint:**

```text
/api/applicants/{id}
```

**cURL Example:**

```bash
curl http://localhost:8080/api/applicants/1
```

Replace `1` with the ID of the applicant you want to retrieve.

### 4. Update an Applicant

**Method:** `PUT`

**Endpoint:**

```text
/api/applicants/{id}
```

**cURL Example:**

```bash
curl -X PUT http://localhost:8080/api/applicants/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Aarav",
    "lastName": "Patil",
    "email": "aarav@example.com",
    "phone": "9876543210",
    "birthDate": "2003-05-15"
  }'
```

Replace `1` with the ID of the applicant you want to update.

### 5. Delete an Applicant

**Method:** `DELETE`

**Endpoint:**

```text
/api/applicants/{id}
```

**cURL Example:**

```bash
curl -X DELETE http://localhost:8080/api/applicants/1
```

Replace `1` with the ID of the applicant you want to delete.

> **Note:** The examples assume the controller accepts the request formats shown. Actual response bodies and HTTP status codes depend on the implementation.

## Prerequisites

Install the following software before running the application:

- Java Development Kit (JDK)
- PostgreSQL
- Maven, if the project does not include the Maven Wrapper
- Git
- An IDE such as Spring Tools for Eclipse or IntelliJ IDEA

## Installation and Setup

### Step 1: Clone the Repository

```bash
git clone https://github.com/sheetalrakhonde/applicant-management-system.git
```

### Step 2: Navigate to the Project Directory

```bash
cd applicant-management-system
```

### Step 3: Create the PostgreSQL Database

Open PostgreSQL and execute:

```sql
CREATE DATABASE applicant_db;
```

If you already have a database configured for the application, use that database name instead.

### Step 4: Configure Database Connectivity

Open:

```text
src/main/resources/application.properties
```

Add or update the following configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/applicant_db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Set your PostgreSQL credentials in the terminal:

```bash
export DB_USERNAME=your_postgres_username
export DB_PASSWORD=your_postgres_password
```

Replace the example values with your actual PostgreSQL credentials.

**Security:** Do not commit database passwords or other sensitive credentials to GitHub.

### Step 5: Build the Application

If the project includes the Maven Wrapper, run:

```bash
./mvnw clean package
```

Otherwise, use:

```bash
mvn clean package
```

### Step 6: Run the Application

Using the Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Or using Maven:

```bash
mvn spring-boot:run
```

The application will typically be available at:

```text
http://localhost:8080
```

### Step 7: Test the APIs

Use Postman or cURL to send HTTP requests to the available endpoints.

For example:

```bash
curl http://localhost:8080/api/applicants
```

## Project Structure

The following is an illustrative Spring Boot project structure. The actual files may differ depending on the current implementation.

```text
applicantmanagement/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── des/
│   │   │           └── applicantmanagement/
│   │   │               ├── controller/
│   │   │               │   └── ApplicantController.java
│   │   │               ├── entity/
│   │   │               │   └── Applicant.java
│   │   │               ├── repository/
│   │   │               │   └── ApplicantRepository.java
│   │   │               ├── service/
│   │   │               │   └── ApplicantService.java
│   │   │               └── ApplicantmanagementApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Learning Objectives

This project demonstrates practical experience with:

- Developing RESTful APIs using Spring Boot.
- Implementing CRUD operations.
- Understanding layered backend architecture.
- Connecting Java applications to PostgreSQL.
- Mapping entities to database tables using Hibernate.
- Using Spring Data JPA repositories.
- Managing dependencies with Maven.
- Validating incoming data.
- Testing APIs with HTTP clients.
- Managing source code using Git and GitHub.

## Future Enhancements

Potential improvements include:

- Spring Security authentication and authorization.
- Role-based access control.
- Pagination and sorting.
- Applicant search and filtering.
- Centralized exception handling.
- Unit and integration testing.
- API documentation using Swagger/OpenAPI.
- Docker containerization.
- CI/CD pipeline integration.
- Institution and course management.
- Application status tracking.
- Support for applicants applying to multiple courses or institutions.

## Author

**Sheetal Sopan Rakhonde**

GitHub: [sheetalrakhonde](https://github.com/sheetalrakhonde)

## License

This project is intended for educational and learning purposes. A formal open-source license can be added if the project is intended for public distribution or reuse.
