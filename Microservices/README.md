## Technology

Spring Boot + Gradle + Kotlin

## Microservices Architecture

* **Eureka Server** - for service discovery
  * http://localhost:8761/
* **User Service** - provides a list of users (fetched from [Random User Generator](https://randomuser.me/))
  * http://localhost:8080/users
* **Horoscope Service** - consumes User Service, have circuit breaker enabled
  * http://basgeekball:8081/fortune

## HowTo

```bash
# To launch service
./gradlew bootRun
```
