## 💻 Sobre o projeto

O App Barbearia é um aplicativo para gestão de atendimento de clientes e barbeiros. O aplicativo deve possuir funcionalidades que permitam o cadastro de barbeiros e de clientes, e também o agendamento e cancelamento de atendimento.

Enquanto um time de desenvolvimento será responsável pelo aplicativo mobile, o nosso será responsável pelo desenvolvimento das APIs Rest utilizando Spring.

---

## ⚙️ Funcionalidades

- [x] CRUD de barbeiros;
- [x] CRUD de clientes;
- [ ] Agendamento de Atendimentos;
- [ ] Cancelamento de Atendimentos.
- [x] Validação de Cadastros, Agendamento e Cancelamento.
- [x] Controle de Autorização de Acesso por token JWT c/ persistência.
- [x] Docker com Postgres e PGAdmin.
- [x] Data migrations com versionamento usando o Flyway
- [ ] Documentação da API 
- [ ] Testes Automatizados com JUnit
- [ ] Build do projeto e deploy em produção

---

## 🎨 Layout (em breve)

O layout da aplicação mobile está disponível neste link: <a href="https://i.postimg.cc/brcPLbFg/cadeiras-vintage-na-barbearia.jpg">Barbearia</a>

---

## 📄 Kanban

O kanban das funcionalidades da aplicação pode ser acessada neste link: <a href="https://adriano-azevedo.notion.site/fbe80de1652a4bf59f15366335803805?v=4a94aba0b73847fbb900d330b485e924&pvs=4">Notion</a>

---

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[Postgres](https://www.postgresql.org/)**
- **[Docker](https://www.docker.com/)**
- **[Hibernate](https://hibernate.org)**
- **[Flyway](https://flywaydb.org)**
- **[Lombok](https://projectlombok.org)**

---

## 📝 Usuário de Teste

- login: teste@gmail.com
- senha: 123456

---

## 📝 Instruções para rodar o projeto

- baixar projeto
- abrir no intelliJ
- aguarde o intelliJ baixar todas as dependências
- RUN o file compose.yaml (postgres e pgadmin no docker)
- RUN o ApiApplication, na pasta java/com.barbearia.api
- importe o collection postman
- utilize a request efetuar login, com as credenciais acima, para gerar um token JWT
- atualize o token em Authorization (tipo Bearer Token) com o gerado
- tempo de vida do token: 2hs

---

## 📝 Collection Postman
![Collection](https://github.com/adrianoazevedo/barbearia/blob/main/assets/postman.png "Json collection")

---

