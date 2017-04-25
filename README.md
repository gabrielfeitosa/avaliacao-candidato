# Sistema de Avaliação do Candidato

Sistema de exemplo para estudo

#### Tecnologias

* Java
* Maven
* Spring Boot
* AngularJS
* Protractor
* Jasmine

## Configurações

O sistema faz envio de e-mail, mas por default está desabilitado. Os dados que seriam enviados por e-mail serão impressos no console.

Se quiser testar com o envio de e-mail, é necessário preencher o arquivo **backend/src/main/resources/application.properties**. Segue um exemplo:

```sh
#Configurações para envio de email
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=SEU_USUARIO
spring.mail.password=SUA_SENHA
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
email.from=SEU_EMAIL
email.habilitar=true
```

## Run

Na raiz do repositório disponibilizei o script **app-up.sh**, que pode ser usado para fazer o build e subir o sistema:

```sh
$ app-up.sh
```

Após a execução, o sistema estará no ar, é só acessar no seu browser http://localhost:8080

## Execução dos testes

### Frontend

Para executar os testes unitários com o Jasmine, abra o arquivo **frontend/unit-test/unit-test.html** no browser. Os testes serão realizados e o resultado será exibido na tela. 

Já para os testes com o Protractor, é necessário que o sistema esteja rodando. Após a etapa do **run**, entre no diretório **frontend** e execute o comando:

```sh
$ npm test
```

### Backend

Para executar os testes unitários do backend, acesso o diretório **backend** e execute o comando:

```sh
$ mvn test
```

Já para executar os testes de integração, execute o comando:

```sh
$ mvn integration-test
```

License
----

MIT

