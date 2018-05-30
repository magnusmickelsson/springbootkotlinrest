# springbootkotlinrest
A mini example of getting a Spring Data REST backed entity repository online with Spring Boot, in Kotlin. Features RestAssured for testing.

This example was done for a lightning talk of 10 minutes, giving a short sales pitch on why Spring Boot and Kotlin are truly a great match.

## How-to

* Clone the repository
* Import project into an IDE capable of working with Kotlin (using IntelliJ)
* Build the project with the IDE, or Maven
* Start the Spring Boot project using the main class KotlinSpringApplication

The REST API is accessible via http://127.0.0.1:8080/ per default. It's HATEOAS enabled.
Remember to use Content-Type application/json when posting data to be persisted.

There is a ping method at http://127.0.0.1:8080/ping/

To run the tests, use the RestApplicationTest class.

magnus.mickelsson@gmail.com
