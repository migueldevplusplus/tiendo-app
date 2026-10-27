# tiendo

Multi-tenant ordering system for restaurants. Each restaurant gets a public menu and an admin panel.

## Stack
- Backend: Java 21, Spring Boot 4.1, PostgreSQL, Flyway
- Frontend: React, Vite, TypeScript

## Run
```
cp .env.example .env        # then set a password in .env
docker compose up -d
cd backend && ./mvnw spring-boot:run
cd frontend && npm install && npm run dev
```