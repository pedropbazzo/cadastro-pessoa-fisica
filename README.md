# Cadastro de pessoas fisicas 

[![Build Status](https://travis-ci.org/bitcoinj/bitcoinj.png?branch=master)](https://travis-ci.org/bitcoinj/bitcoinj)   [![Coverage Status](https://coveralls.io/repos/bitcoinj/bitcoinj/badge.png?branch=master)](https://coveralls.io/r/bitcoinj/bitcoinj?branch=master) 


## Executar somente backend (Java 8 + Spring Boot)
No diretório backend/demo rodar:
1. docker build -t api .
2. docker run -p 8888:8888 api

## Executar somente frontend (Angular)
No diretório frontend/demo rodar:
1. docker build -t client . 
2. docker run -p 4200:4200 client

## Executar sistema completo (fullstack)
No diretório raiz do projeto, rodar:
* docker-compose up

## Backend Endpoints
* GET ALL: /pessoas
* GET BY ID: /pessoas/{id}
* GET BY NAME: /pessoas/fundByName/{nome}
* POST: /pessoas
* PUT: /pessoas/{id}
* DELETE: /pessoas/{id}
* DELETE ALL: /pessoas/deleteAll

* SOURCE: /source

## Testes
Executar a classe PessoaControllerTest no modo teste da IDE.

## Documentacao Swagger disponivel em:
http://localhost:8888/swagger-ui.html
![DocumentacaoSwagger](https://user-images.githubusercontent.com/7613528/102938861-df27c300-448b-11eb-8aaa-e37545903514.png)

## Deploy 

AWS
