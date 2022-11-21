# hello-quarkus Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```
And if you have docker installed locally you don't need to make any datasource config for testing application. 
Quarkus will do it instead of you. It's Quarkus magic for you, to focus on your business :)

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

# hello-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## hello-quarkus project description

This project is a simple Quarkus crud application that uses PanacheEntity

## Endpoints

- POST /users?name={name} - creating user with specific name as INACTIVE
- GET /users - getting all users on DB
- GET /users/{id} - getting user with specific id
- PUT /users/{id} - update specific user by id as ACTIVE