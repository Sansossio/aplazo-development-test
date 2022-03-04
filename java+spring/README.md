# Aplazo interest ms (SpringBoot)

## Environment variables
```env
# App
APP_PORT=3001
# Swagger
SWAGGER_ENABLE=true
SWAGGER_PATH=api
# Database
DATABASE_NAME=aplazo_interest
DATABASE_USER=root
DATABASE_PASSWORD=root
```

## Run application

### Gradle

To run the application you must execute the following command:
```sh
# Remember, you must have the gradle plugin installed
# Environment variables must be set
gradle bootRun
```

### VsCode

Just press `F5` to run the application.

### Docker
```sh
docker-compose up # run application
```

### OpenApi specs
When you start the application you can see the swagger documentation at: [http://localhost:3001/api](http://localhost:3001/api) (or the path you defined in the environment variables)

## Test

Run the tests with gradle:
```sh
gradle test
```
