# Football From Scratch
 
Welcome to Football From Scratch, developed in Spring Boot. This API provides endpoints for creating teams and managing them.
 
## Requiriments
 
- Java 17 
- MySQL database 
 
## Configuration
 
1. Clone the repository:
 
```bash
git clone https://https://github.com/pablitohaddad/football-from-scratch
```
 
2. Configure the database in the `application.properties` file.
 
3. Execute the aplication:
 
```bash
mvn spring-boot:run
```
 
A aplicação estará disponível em http://localhost:8080/footbalfromscratch.html
 
## API Endpoints
 
### `Post /teams` 
 
Create teams
 
**Exemple response:**
```json
{
    "name": "São Paulo",
    "country": "Brazil",
    "city": "São Paulo",
    "age": 94,
    "quantityTrophies": 37,
    "surname" : "Soberano"
}
```
### `GET /teams/{id}` 
 
Get the team by id
 
**Exemple response:**
```json
{
    "id": 1,
    "name": "São Paulo",
    "surname" : "Soberano",
    "quantityTrophies": 37
}
```
### `PATCH /teams/trophies/{id}` 
 
Update the team's quantity trophies by id
 
**Exemple response:**
```json
{
    "quantityTrophies": 40
}
```
### `PATCH /teams/age/{id}` 
 
Update the team's age by id
 
**Exemple response:**
```json
{
    "age": 98
}
```
 

### Exception Handling

Football From Scratch can generate different HTTP response codes in case of exceptions. Here are some possible situations:

```json
{
  "error": "400 Bad Request",
  "message": "The request contains invalid data."
}

{
  "error": "404 Not Found",
  "message": "The team with the specified ID was not found."
}

{
  "error": "500 Internal Server Error",
  "message": "An internal server error occurred. Check the logs for more details."
}


```

### Important
```json
{

"Ensure that the team has a positive or null (0)"

}
```
