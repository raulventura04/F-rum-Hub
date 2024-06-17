# ForumHub

## Descrição
O ForumHub é uma aplicação de fórum desenvolvida em Java usando o framework Spring Boot. A aplicação permite que usuários se registrem, façam login, criem tópicos e participem de discussões. Utiliza JWT para autenticação e Flyway para gerenciamento de migrações de banco de dados.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **JPA (Java Persistence API)**
- **Flyway**
- **MySQL**
- **Lombok**
- **Swagger/OpenAPI**

## Requisitos

Para rodar o projeto localmente, você precisará dos seguintes componentes:

- **Java 17** ou superior
- **Maven**
- **MySQL** (ou outro banco de dados compatível)

## Configuração do Ambiente

### Banco de Dados

1. **Instale e configure o MySQL:**
   - Crie um banco de dados chamado `Forum`.
   - Ajuste o nome de usuário e a senha conforme necessário.

   ```sql
   CREATE DATABASE Forum;
   
Configure as credenciais do banco de dados no arquivo src/main/resources/application.properties:

properties
Copiar código
spring.datasource.url=jdbc:mysql://localhost:3306/Forum
spring.datasource.username=root
spring.datasource.password=raul123

Aplicação
Clone o repositório:

bash
Copiar código
git clone https://github.com/seu-usuario/ForumHub.git
cd ForumHub
Compile o projeto com Maven:

bash
Copiar código
mvn clean install
Inicie a aplicação:

bash
Copiar código
mvn spring-boot:run
A aplicação estará disponível em http://localhost:8081.

Flyway
O Flyway será executado automaticamente ao iniciar a aplicação, aplicando as migrações necessárias para criar a tabela usuarios e outras tabelas necessárias.

Uso da API
Endpoints Disponíveis
Autenticação
Registrar Usuário

POST /usuarios
Request Body:
json
Copiar código
{
  "nome": "Nome do Usuário",
  "email": "usuario@exemplo.com",
  "password": "senhaSegura"
}
Response:
json
Copiar código
{
  "id": 1,
  "nome": "Nome do Usuário",
  "email": "usuario@exemplo.com"
}
Login

POST /login
Request Body:
json
Copiar código
{
  "email": "usuario@exemplo.com",
  "password": "senhaSegura"
}
Response:
json
Copiar código
{
  "tipo": "Bearer",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
Tópicos
Criar Tópico

POST /topicos
Headers:
text
Copiar código
Authorization: Bearer {token}
Request Body:
json
Copiar código
{
  "titulo": "Título do Tópico",
  "mensagem": "Mensagem do Tópico"
}
Response:
json
Copiar código
{
  "id": 1,
  "titulo": "Título do Tópico",
  "mensagem": "Mensagem do Tópico",
  "autorId": 1
}
Listar Tópicos

GET /topicos
Response:
json
Copiar código
[
  {
    "id": 1,
    "titulo": "Título do Tópico",
    "mensagem": "Mensagem do Tópico",
    "autorId": 1
  }
]
Detalhar Tópico

GET /topicos/{id}
Response:
json
Copiar código
{
  "id": 1,
  "titulo": "Título do Tópico",
  "mensagem": "Mensagem do Tópico",
  "autorId": 1
}
Atualizar Tópico

PUT /topicos/{id}
Headers:
text
Copiar código
Authorization: Bearer {token}
Request Body:
json
Copiar código
{
  "titulo": "Novo Título do Tópico",
  "mensagem": "Nova Mensagem do Tópico"
}
Response:
json
Copiar código
{
  "id": 1,
  "titulo": "Novo Título do Tópico",
  "mensagem": "Nova Mensagem do Tópico",
  "autorId": 1
}
Excluir Tópico

DELETE /topicos/{id}
Headers:
text
Copiar código
Authorization: Bearer {token}
Testando a API
Você pode usar o Insomnia ou o Postman para testar os endpoints da API. Use o token JWT recebido no login para autenticar as requisições que requerem autenticação.

Configuração do Insomnia
Criar uma nova coleção e adicionar os endpoints acima.
Configurar a autenticação Bearer para os endpoints que requerem.
Testar os endpoints conforme necessário.
Documentação da API
A documentação completa da API está disponível através do Swagger. Após iniciar a aplicação, acesse:

bash
Copiar código
http://localhost:8081/swagger-ui.html
Contribuição
Fork o repositório
Crie sua feature branch: git checkout -b minha-nova-feature
Commit suas mudanças: git commit -m 'Adicionando uma nova feature'
Push para a branch: git push origin minha-nova-feature
Abra um Pull Request
Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

Esperamos que você aproveite o desenvolvimento com o ForumHub!

perl
Copiar código

