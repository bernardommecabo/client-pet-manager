# Client Pet Manager

Project originally started based on Petz's senior backend challenge, now developed further as a broader Java/Spring Boot backend study.

## About the project

API for managing clients and their pets, including ownership validation (a client can only access/modify pets that belong to them).

Some architecture and domain decisions:
- **Records** used for all DTOs (requests and responses), prioritizing immutability.
- **Client** and **Pet** as decoupled aggregates (no `@ManyToOne` relationship between the entities), following DDD principles.
- **Centralized exception handling**, with a generic exception (`APIException`) and a `GlobalExceptionHandler` standardizing error responses.
- **MapStruct** for mapping between DTOs and entities.

## Tech stack

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- Bean Validation (Jakarta Validation)
- MapStruct
- Lombok
- PostgreSQL
- Docker Compose

## Upcoming additions

- Authentication/credentials
- Unit and integration tests
- Pagination on listing endpoints
- Swagger documentation
- React frontend

## Author

Developed by [Bernardo Guilherme Madruga Mecabô](https://github.com/bernardommecabo) as a study project.
