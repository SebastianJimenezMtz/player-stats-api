# Player Stats API

A RESTful API for querying football player statistics, built with **Spring Boot** and **PostgreSQL**.

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven

## Endpoints

Base URL: `/api/v1/player`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/v1/player` | Get all players |
| `GET` | `/api/v1/player?team={team}` | Filter by team |
| `GET` | `/api/v1/player?name={name}` | Search by name |
| `GET` | `/api/v1/player?position={position}` | Filter by position |
| `GET` | `/api/v1/player?nation={nation}` | Filter by nationality |
| `GET` | `/api/v1/player?team={team}&position={position}` | Filter by team and position |
| `POST` | `/api/v1/player` | Add a new player |
| `PUT` | `/api/v1/player` | Update an existing player |
| `DELETE` | `/api/v1/player/{playerName}` | Delete a player |

## Running Locally

### Prerequisites
- Java 17+
- PostgreSQL
- Maven

### Setup

1. Clone the repo
   ```bash
   git clone https://github.com/SebastianJimenezMtz/player-stats-api.git
   cd player-stats-api
   ```

2. Create `src/main/resources/application-local.properties` with your DB credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. Run the app
   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080`

## Database

The app connects to a PostgreSQL database using the `football` schema and the `player_statistic` table. Player data was sourced from a CSV file containing Premier League statistics.

## Coming Soon

- Exception handling with proper HTTP error responses
- DTO layer
- Request validation
- React frontend with player search and filtering
- Deployment (Railway + Vercel)
