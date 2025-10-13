# TrackAssets — API de Listas de Ativos

## Descrição do Projeto
O TrackAssets é uma API REST desenvolvida em Java + Spring Boot, que permite que usuários criem uma conta e gerenciem uma lista personalizada de ativos financeiros. Cada ativo é consultado em tempo real por meio da API Alpha Vantage, retornando o preço atualizado.

---

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3
- Spring Data JPA / Hibernate
- MySQL
- AlphaVantage API
- Jackson para parsing JSON

---

## Configuração do Banco de Dados
No arquivo `application.properties`:
```properties
spring.application.name=TrackAssets

# MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/db_trackassets?createDatabaseIfNotExist=true
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# API KEY
alpha.vantage.api.key=YOUR_ALPHA_VANTAGE_API_KEY
```
- Substitua `YOUR_ALPHA_VANTAGE_API_KEY` pela sua chave da AlphaVantage.
- Substitua `YOUR_USERNAME` pelo seu Username do MySQL.
- Substitua `YOUR_PASSWORD` pela sua Password do MySQL

---

## Endpoints da API

### Usuários

#### 1. Criar usuário
- **POST** `/users`
- **Request:**
```json
{
  "name": "João"
}
```
- **Response:**
```json
{
  "id": 1,
  "name": "João"
}
```

#### 2. Listar usuários
- **GET** `/users`
- **Response:**
```json
[
  { "id": 1, "name": "João" },
  { "id": 2, "name": "Maria" }
]
```

#### 3. Deletar usuário
- **DELETE** `/users/{userId}`
- **Response:**
```
HTTP 200 OK
```
- **Erro (400 Bad Request):**
```json
{
  "error": "User not found with ID: {userId}"
}
```

---

### Ativos

#### Consultar preço de ativo
- **GET** `/asset/{symbol}`
- **Response (200 OK):**
```json
{
  "symbol": "AAPL",
  "price": 175.30
}
```
- **Erro (400 Bad Request):**
```json
{
  "error": "Asset not found or invalid symbol: {symbol}"
}
```

---

### Portfólio

#### 1. Adicionar ativo ao portfólio
- **POST** `/portfolio/users/{userId}/assets`
- **Request:**
```json
{
  "symbol": "AAPL"
}
```
- **Response:**
```json
{
  "symbol": "AAPL",
  "price": 175.30
}
```
- **Erro (400 Bad Request):**
```json
{
  "error": "Asset not found or invalid symbol: {symbol}"
}
```

#### 2. Listar portfólio do usuário
- **GET** `/portfolio/users/{userId}/assets`
- **Response:**
```json
[
  { "Symbol": "AAPL", "Price": 175.30 },
  { "Symbol": "GOOGL", "Price": 132.50 }
]
```

#### 3. Remover ativo do portfólio
- **DELETE** `/portfolio/users/{userId}/assets/{symbol}`
- **Response:**
```
Asset removed successfully
```
- **Erro (400 Bad Request):**
```json
{
  "error": "Asset not found in portfolio: {symbol}"
}
```

---

## Como Rodar
1. Clone o repositório:
```
git clone <seu-repositorio-url>
```
2. Configure `application.properties`.
3. Execute a aplicação Spring Boot:
```
./mvnw spring-boot:run
```
4. Teste os endpoints via Postman, Insomnia ou CURL.

## Observações


- A API **consulta preços em tempo real** via AlphaVantage a cada requisição.
- `GlobalExceptionHandler` garante respostas consistentes em caso de erro.
---

## Autor

- **Gabriel Teodoro** — Desenvolvedor Backend
- LinkedIn: [gabrielteodoro-dev](https://www.linkedin.com/in/gabrielteodoro-dev/)
- GitHub: [gabrielteodoro-dev](https://github.com/gabrielteodoro-dev)