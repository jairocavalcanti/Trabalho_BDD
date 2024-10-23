# Projeto Spring Boot - Gerenciamento de Eventos e Participantes

## Pré-requisitos
- Java 17+
- MySQL 8.0+
- Maven 3.6+

## Como executar o projeto

### 1. Configurar o MySQL:
- Crie um banco de dados chamado `trabalho ` ou altere as configurações de `/application.properties`.
- Ajuste as configurações de usuário e senha no arquivo `src/main/resources/application.properties` conforme necessário.

### 2. Executar o projeto:
No terminal, execute os seguintes comandos:

```bash
./mvnw clean package
java -jar target/seu-projeto.jar