# g-autos

## Details
A Spring Boot CRUD API with persistence to PostgreSQL
- Java 11
- Spring Boot 2.7.6
- Gradle
- Archive output: Jar

## Requirements
- Java 11
- PostgreSQL

### PostgreSQL Docker quickstart
```
docker run -p 5432:5432 --name postgres -e POSTGRES_USER=autos -e  POSTGRES_PASSWORD=autos123 -d postgres
```
To connect to a remote database, edit the values in `src/main/resources/application.properties`

## Usage
- Build
  ```
  ./gradlew build
  ```
  - Output directory: `build/libs`
- Run
  ```
  ./gradlew bootRun
  ```
- Test
  ```
  ./gradlew test
  ```