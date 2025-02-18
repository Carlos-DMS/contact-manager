# contact-manager

**Objetivo:**  
Gerenciar relações entre pessoas e seus contatos.

**Contexto:**  
Este projeto foi desenvolvido durante o processo de capacitação para a Indra Minsait, como parte de uma avaliação técnica.

---

## Tecnologias e Dependências

- **Linguagem:** Java (JDK 21)
- **Framework:** Spring Boot
- **Gerenciador de Dependências:** Maven
- **Principais Dependências:**
    - Spring Web
    - Spring Data JPA
    - H2 Database (em memória)
    - Spring Boot Starter Validation
    - SpringDoc OpenAPI (Swagger-UI)

---

## Pré-requisitos

- **JDK 21:** Certifique-se de que a JDK 21 esteja instalada e configurada em seu ambiente.
- **Maven:** Para baixar as dependências e compilar o projeto.
- **Ambiente de Desenvolvimento:** Recomenda-se utilizar uma IDE como o IntelliJ IDEA.

---

## Instalação e Execução

1. **Clone o Repositório:**

   ```bash
   git clone <https://github.com/Carlos-DMS/contact-manager.git>
   ```

2. **Abra o Projeto na IDE:**  
   Importe o projeto utilizando sua IDE preferida (ex.: IntelliJ IDEA) e configure o uso da JDK 21.

3. **Baixe as Dependências:**  
   Execute o Maven para baixar todas as dependências necessárias.

4. **Inicie o Projeto:**  
   Inicie a aplicação diretamente pela IDE ou via comando Maven:

   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a Aplicação:**
    - API: [http://localhost:8080](http://localhost:8080)
    - Swagger UI (Documentação da API): [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## Acessando o Banco de Dados H2

Após iniciar a aplicação, abra seu navegador e acesse:  
[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Na tela de login do H2, preencha os campos da seguinte forma:

- **Driver Class:** `org.h2.Driver`
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User Name:** `sa`
- **Password:** (deixe em branco)

Em seguida, clique em **Test Connection** (opcional) para verificar a conexão e depois em **Connect** para acessar o console do H2.

---

## Documentação da API

A API está completamente documentada com Swagger UI. Após iniciar o projeto, acesse a documentação em:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## Estrutura do Projeto (Arquitetura em Camadas)

A estrutura de diretórios do projeto está organizada da seguinte forma:

- **models:** Contém as classes que representam as entidades do domínio.
- **controllers:** Responsáveis por receber as requisições HTTP e direcioná-las para os serviços.
- **services:** Camada de lógica de negócio.
- **repositories:** Interface para a persistência dos dados.
- **dtos:** Objetos de transferência de dados entre as camadas.
- **exceptions:** Tratamento de exceções personalizadas.

---

## Contribuição

Contribuições são bem-vindas! Caso deseje contribuir:

- **Issues:** Abra uma _issue_ para sugerir melhorias ou reportar bugs.
- **Pull Requests:** Envie suas contribuições por meio de _pull requests_.  
  **Observação:** Os commits devem seguir as convenções em inglês, utilizando prefixos como `feat:`, `fix:` e `wip:`.

---

## Melhorias Futuras

- **Documentação de Funcionalidades com JavaDoc:** Implementar comentários JavaDoc em todas as classes e métodos para melhorar a compreensão e manutenção do código.
- **Integração com Testes:** Desenvolver testes unitários e de integração para garantir a qualidade da aplicação.

---

## Contato

- **LinkedIn:** [Carlos Daniel Martins Sanguino](https://www.linkedin.com/in/carlos-daniel-martins-sanguino-72b46a2a0/)
- **Email:** [carlos.dsanguino@gmail.com](mailto:carlos.dsanguino@gmail.com)