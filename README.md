# 🎵 CodexisMusic - API REST

Uma API RESTful para gerenciamento de músicas desenvolvida em Java com **Spring Boot**, **Spring Data JPA** e **H2 Database**.

O projeto nasceu de uma refatoração: uma aplicação que funcionava via terminal (CLI) foi transformada em uma arquitetura web moderna, aplicando boas práticas do mercado, validações de dados e o padrão DTO com Java Records.

---

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **Spring Web (REST API)**
* **Bean Validation (`jakarta.validation`)**
* **H2 Database** (Banco de dados em memória)
* **Maven** (Gerenciador de dependências)

---

## 🛠️ Arquitetura e Boas Práticas Aplicadas

- **Arquitetura em Camadas:** Divisão clara de responsabilidades entre `Controller`, `Service`, `Repository` e `DTO`.
- **Padrão DTO (Data Transfer Objects):** Uso de **Java Records** (`MusicaRequestDTO` e `MusicaResponseDTO`) para garantir o encapsulamento, a imutabilidade e a segurança das entidades do banco de dados.
- **Validação de Dados:** Uso de anotações do Bean Validation (`@NotBlank`, `@Size`, `@Valid`) para assegurar a integridade dos dados trafegados nas requisições `POST` e `PUT`.
- **Mapeamento Objeto-Relacional (ORM):** Persistência de dados simplificada via Hibernate e interfaces estendidas do `JpaRepository`.

---

## 📌 Endpoints da API

A rota base para o gerenciamento de músicas é `/musicas`.

| Método | Endpoint | Descrição | Status HTTP |
| :--- | :--- | :--- | :--- |
| **GET** | `/musicas` | Lista todas as músicas cadastradas | `200 OK` |
| **GET** | `/musicas/{nome}` | Busca uma música pelo título | `200 OK` / `404 Not Found` |
| **POST** | `/musicas` | Cadastra uma nova música | `201 Created` / `400 Bad Request` |
| **PUT** | `/musicas/{id}` | Atualiza uma música existente por ID | `200 OK` / `404 Not Found` |
| **DELETE** | `/musicas/{id}` | Remove uma música do banco por ID | `204 No Content` / `404 Not Found` |

---

## 📥 Exemplos de Requisição JSON

### 1. Cadastrar Música (`POST /musicas`)

**Body (JSON):**
```json
{
  "titulo": "505",
  "album": "Favourite Worst Nightmare",
  "artista": "Arctic Monkeys",
  "genero": "Indie Rock"
}