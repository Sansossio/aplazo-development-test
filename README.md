# Aplazo interest ms
```
Hola Jesús,
Continuando con el proceso te comparto la prueba técnica que requerimos resuelvas para
continuar con el proceso:
Simple Interest microservice:
Create a microservice with spring-boot that calculate and generates the list of
payments of the simple interest of a credit that must be paid in n terms and in weekly
form:
Input: {
"amount": Double,
"terms":Integer,
"rate":Double
}
Output: {
[
{
"payment_number":Integer,
"amount": Double,
"payment_date":Date
}
...
]
}
Must Be:
- Containerized with docker.
- storing the data [request and response] in a h2 database.
It's a Plus:
- having /health endpoint.
- at least 50% coverage
To complete the exam you must send a GitHub repository link with the code
Por favor esperamos la respuesta a más tardar el viernes 1 de octubre de 2021.
```

# Applications
I have created two applications:
- [Aplazo interest ms (SpringBoot)](./java+spring/)
- [Aplazo interest ms (NodeJS)](./node/)

This is because my main language is NodeJS and I wanted to show you all my skills in NodeJS.

## Run applications

If you want to start both applications you can use the following commands:

```sh
docker-compose up spring
docker-compose up nodejs
```

### Open Api specs
- Spring: click [http://localhost:3001/api](http://localhost:3001/api)
- NodeJS: click [http://localhost:3000/api](http://localhost:3000/api)
