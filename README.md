# hibernate-jpa

## In this project: 

### - Entity Manager Implementation

(pr-br)
O EntityManager é uma interface do Hibernate (usada principalmente com a especificação JPA) que gerencia operações com entidades no banco de dados. Ele é responsável por:

EntityManager is an interface from Hibernate (primarily used with the JPA specification) that manages operations with entities in the database. It is responsible for:

### - DAO (Data Access Object)

Em um aplicativo Spring, o DAO (Data Access Object, ou Objeto de Acesso a Dados) é um padrão de projeto que abstrai as operações de banco de dados. Ele oferece uma maneira de encapsular toda a lógica de acesso a dados, como consultas, atualizações e exclusões, em uma camada separada.
- Abstração: Isola a lógica de acesso a dados, facilitando mudanças de tecnologia.
- Operações de banco de dados: Define métodos para inserir, atualizar, excluir e consultar dados.
- Integração com Spring: Utiliza tecnologias de acesso a dados, como JDBC ou JPA.
- Injeção de dependência: DAOs podem ser injetados em outros componentes da aplicação.
- Transações: Trabalha com transações para garantir a consistência dos dados.