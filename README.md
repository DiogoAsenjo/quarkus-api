# API REST/CRUD de treinos de canoa havaia.

## Objetivo
Fiz esse projeto como um Desafio proposto pela ModalGR para aprimorar meus conhecimentos em Java e Quarkus, para uma possível oportunidade de trabalho. Vale ressaltar que apesar da vontade nunca antes tinha visto a linguagem e tive apenas 03 dias para fazer essa API.

## Tecnologias, Ferramentas e Linguagems utilizadas
- Java
- Quarkus
- Docker
- MongoDB
- Jakarta Bean Validation
- Swagger
- IntelliJ

## Funcionamento do projeto
Eu gosto muito de remar. Acontece que onde remo nós temos um problema que apesar de marcarmos os dados dos treinos através de relógio com GPS, nós nunca conseguimos de fato manter um acompanhamento do desempenho, se melhoramos, pioramos, etc. 

Por isso, criei essa API que funciona como um CRUD, onde é possível realizar todas as ações da sigla com os treinos, além de conseguir ordenar os melhores treinos de acordo com a distância, velocidade máxima e velocidade média. Também é possível filtrar apenas os treinos de determinado usuário para facilitar o acompanhamento dos treinos pelo mesmo.

Apesar de simples, fiz um simples diagrama que demonstra como deveria funcionar o projeot que me guiou durante o desenvolvimento:
<div align="center">
  <img src="/Diagrama.PNG" alt="Diagrama aplicação">
</div>

## Documentação
Também consegui fazer a documentação com todas as rotas do projeto usando o Swagger, no momento o projeto está apenas rodando localmente, então caso clone o projeto basta acessar o endereço: http://localhost:8080/api/

Porém segue uma imagem com todas as rotas da aplicação, para mais detalhes será necessário acessar o link citado acima.
<div align="center">
  <img src="/Rotas.png" alt="Diagrama aplicação">
</div>

## Pontos de melhoria
Apesar do pouco tempo, fiquei bem satisteito com o resultado do meu projeto e não consigo me imaginar fazendo melhor em tão pouco tempo, mas segue alguns pontos que gostaria de melhroar em futuros projetos pessoais ou na minha atuação profissional:
- Swagger ficou incompleto na questão dos schemas para utilização completa da ferramenta;
- Conseguir usar os DTOs de melhor forma no projeto;
- Melhorar o tratamento de erros;
- Melhorar o status e as respostas da API;
- Melhorar meus conhecimentos em Java como um todo;

# README Original que já vem com os projetos em Quarkus

# code-with-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- MongoDB client ([guide](https://quarkus.io/guides/mongodb)): Connect to MongoDB in either imperative or reactive style
- REST resources for MongoDB with Panache ([guide](https://quarkus.io/guides/rest-data-panache)): Generate Jakarta REST resources for your MongoDB entities and repositories
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- SmallRye Health ([guide](https://quarkus.io/guides/smallrye-health)): Monitor service health

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

### SmallRye Health

Monitor your application's health using SmallRye Health

[Related guide section...](https://quarkus.io/guides/smallrye-health)
