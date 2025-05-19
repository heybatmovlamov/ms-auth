ms-auth Microservice
ms-auth is a microservice designed for user authentication and authorization.

Overview
The ms-auth service handles user registration, login, token creation, and validation. It uses OAuth2 and JWT (JSON Web Token) standards and integrates securely with other microservices.

Key Features
User registration

User login

JWT token generation and validation

User role management

Password reset and update

Token refresh

REST API endpoints for integration

Technologies
Java 17+

Spring Boot (Spring Security, Spring Data JPA)

JWT (JSON Web Token)

PostgreSQL / MySQL (database)

Docker (containerization)

Maven / Gradle (build tool)

Installation & Running
Requirements
Java 17 or higher

Docker and Docker Compose (optional)

PostgreSQL or MySQL database

Configuration
Configure the following properties in application.yml or application.properties:

yaml
Copy
Edit
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/msauthdb
    username: your_db_user
    password: your_db_password

jwt:
  secret: very_secret_key
  expiration: 3600000  # 1 hour in milliseconds
Running Locally
To run the project locally:

bash
Copy
Edit
./mvnw spring-boot:run
# or
./gradlew bootRun
Using Docker:

bash
Copy
Edit
docker build -t ms-auth .
docker run -p 8080:8080 ms-auth
API Endpoints (example)
Method	URL	Description
POST	/api/auth/register	User registration
POST	/api/auth/login	User login
POST	/api/auth/refresh	Refresh JWT token
GET	/api/users/{id}	Get user details by ID

Development
Create feature branches for new features.

Maintain code quality (linting, tests).

Add unit and integration tests.

Review pull requests thoroughly.

Contact
For questions or support, please contact:

Heybat Movlamov (e.g., heybatmovlamov@gmail.com)
