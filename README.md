# Sobre :blue_book:
Foi desenvolvida uma POC dentro do contexto: "A FIAP resolveu criar seu próprio cartão de crédito para ser utilizado pelos alunos e para isso necessita de um sistema para gerenciamento e integração com outras empresas". A estruturação do código é em MVC cujos packages são separados por contexto de negócio, onde a codificação foi feita seguindo as exigências: codificação de visualização do desenvolvedor em inglês, texto de exibição para o cliente em português e seguir os principios S(Single Responsibility Principle) e O (Open Closed Principle) do paradigma O.O. Por familiaridade a linguagem adotada foi o java 8 com maven conectando-se ao Postgresql, um banco relacional open source. Para facilitar no gerenciamento dos scripts em banco foi escolhido o Flyway e para documentação da API o Swagger. Para praticar a ideia de low code foi usado o Lombok junto ao SpringBoot. Na comunicação com o cliente via e-mail foi escolhida a G-MAIL API, onde possui uma integração e segurança de autenticação já validada pelo mercado.

# Tech Stag :clipboard:
- JUnit4
- Java 8
- Maven
- Postgresql
- Flyway
- G-mail API
- Swagger
- SpringBoot
- Lombok

# Executando o projeto :computer:
- Passo1: Escolha a pasta para download do projeto e execute o clone;
```
git clone https://github.com/rickdevbr-io/creditCard.git
```
- Passo2: Escolha a pasta para download do projeto e execute o clone;

- Passo3: No PostgreSQL local crie o database fiap;

- Passo4: Execute o boot do projeto;
```
mvn run
```
- Passo5: Abra a documentação API http://localhost:8080/fiap-spring/swagger-ui/

# Executando os testes unitários :arrow_forward:
- Passo1: Escolha a pasta "spring" ou alguma em específico, pressione com o botão direito e execute os testes selecionando a opção "Run Tests in...".

