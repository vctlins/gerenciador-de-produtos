# 🚀 Gerenciador de Produtos em Java com PostgreSQL

Sistema simples de gerenciamento de produtos que realiza as operações de cadastro, listagem, atualização e remoção, com persistência em banco de dados PostgreSQL. A aplicação roda via terminal e foi estruturada em camadas seguindo o padrão MVC, com separação entre dados, regras de negócio e interface textual.

Em vez de seguir o caminho tradicional com frameworks que resolvem tudo com uma linha de código, decidi mergulhar mais fundo: **nada de JPA ou Hibernate**. Aqui, tudo foi feito na base do **JDBC**, desde a criação da conexão até a execução manual de SQL com `PreparedStatement` e `ResultSet`. A proposta era justamente entender o que acontece por baixo dos panos e fortalecer minha base.

Essa abordagem me ajudou a consolidar conceitos importantes como a **arquitetura MVC**, o uso dos padrões **DAO e Singleton**, além de reforçar a lógica da **programação orientada a objetos** com foco na organização e separação de responsabilidades.

---

## 🧱 Estrutura e funcionalidades

O projeto oferece todas as operações CRUD, com os dados armazenados de forma persistente em PostgreSQL e a aplicação dividida de forma clara entre modelo, controle, visualização e camada de acesso aos dados.

Foi uma ótima experiência para aprimorar tanto o domínio do Java quanto o raciocínio estruturado por trás do que usamos diariamente com frameworks.

---

## 💡 Tecnologias e padrões usados

- Java
- PostgreSQL
- JDBC
- Padrões de projeto: MVC, DAO, Singleton

---

## 🔧 Requisitos para rodar o projeto

- JDK 11 ou superior
- PostgreSQL instalado
- Um banco chamado `produtos_db` com a seguinte tabela:

```sql
CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE PRECISION NOT NULL
);
```

- Driver JDBC do PostgreSQL (ex: `postgresql-42.7.5.jar` incluído no projeto)

---

> Obs: no Linux/Mac, troque `;` por `:` no classpath
