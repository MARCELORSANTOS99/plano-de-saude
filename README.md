# Aplicação de Exemplo com Spring Boot e Banco de Dados H2

Esta é uma aplicação de exemplo desenvolvida utilizando o Spring Boot 3 e o banco de dados H2. A aplicação inclui implementação de autenticação JWT para fornecer segurança aos endpoints.

## Tecnologias Utilizadas

- Spring Boot 3
- Banco de Dados H2 (em memória)
- Autenticação JWT

## Instruções para Execução

### Requisitos

- Java JDK 8 ou superior
- Maven

### Passos

1. Clone o repositório:

2. Navegue até o diretório do projeto:


3. Execute o comando Maven para construir o projeto:


4. Após a construção, você pode iniciar a aplicação:

5. A aplicação estará disponível em `http://localhost:8081`. Você pode acessar a documentação da API através deste link.

## Documentação da API

A documentação da API está disponível em `http://localhost:8081/swagger-ui/index.html`.

## Configuração da Autenticação JWT

A autenticação JWT foi implementada utilizando Spring Security e JWT. As configurações podem ser encontradas em `src/main/java/com/plano-de-saude/config/SecurityConfig.java`.

## Estrutura do Projeto

A estrutura do projeto segue a convenção do Spring Boot, com os principais diretórios sendo:

- `src/main/java`: Contém o código-fonte Java da aplicação.
- `src/main/resources`: Contém arquivos de configuração e recursos estáticos.

## Contribuindo

Se você gostaria de contribuir com este projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request.



