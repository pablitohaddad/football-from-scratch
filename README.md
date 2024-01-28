# Football From Scratch
 
Bem-vindo ao football from scratch, desenvolvida em Spring Boot. Esta API fornece endpoints para criação de times e gerenciamento deles.
 
## Requisitos
 
- Java 17 
- Banco de dados MySQL 
 
## Configuração
 
1. Clone o repositório:
 
```bash
git clone https://https://github.com/pablitohaddad/football-from-scratch
```
 
2. Configure o banco de dados no arquivo `application.properties`.
 
3. Execute a aplicação:
 
```bash
mvn spring-boot:run
```
 
A aplicação estará disponível em http://localhost:8080/footbalfromscratch.html
 
## Endpoints da API
 
### `Post /teams` 
 
Cria os times. [Finnality end-point]
 
**Exemplo de resposta:**
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
 
Traz o time por id.
 
**Exemplo de resposta:**
```json
{
    "id": 1,
    "name": "São Paulo",
    "surname" : "Soberano",
    "quantityTrophies": 37
}
```
### `PATCH /teams/trophies/{id}` 
 
Atualiza a quantidade de trofeus do time por id.
 
**Exemplo de resposta:**
```json
{
    "quantityTrophies": 40
}
```
### `PATCH /teams/age/{id}` 
 
Atualiza a idade do time do time por id.
 
**Exemplo de resposta:**
```json
{
    "age": 98
}
```
 

### Tratamento de Exceções

A football from scratch pode gerar diferentes códigos de resposta HTTP em caso de exceções. Aqui estão algumas situações que podem ocorrer:

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

### Importantes
```json
{

"Certifique-se que o time tenha idade e quantidade de títulos positiva ou nula (0)"

}
```
