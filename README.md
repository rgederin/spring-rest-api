# Simple Spring REST API  [![CircleCI](https://circleci.com/gh/rgederin/spring-rest-api.svg?style=svg)](https://circleci.com/gh/rgederin/spring-rest-api) [![codecov](https://codecov.io/gh/rgederin/spring-rest-api/branch/master/graph/badge.svg)](https://codecov.io/gh/rgederin/spring-rest-api)

Simple Spring REST API wich demonstrates basic approach for building REST endpoints with Spring
 
## How to run

```
Be sure that you have docker or docker tools installed on your machine

cd spring-rest-api/

Build: mvn clean install docker:build
Run:   mvn docker:run

http://localhost:8080/swagger-ui.html#/  - Swagger API documentation
``` 


## Technologies and tools

```
Spring 5
Spring Boot 2
Spring Data
H2
Spring Web
MapStruct
Spring-fox Swagger2
Docker
CircleCi
Codecov 
```