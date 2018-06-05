# springbootkotlinrest
A mini example of getting a [Spring Data REST](https://projects.spring.io/spring-data-rest/) backed entity repository online with 
[Spring Boot](https://spring.io/projects/spring-boot), in [Kotlin](https://kotlinlang.org) instead of Java. 
[RestAssured](http://rest-assured.io) is used for testing.

This example was done for a lightning talk of 10 minutes, giving a short sales pitch on why Spring Boot and Kotlin are truly a great match.

## How-to

* Clone the repository to your local machine
* Import project into an IDE capable of working with Maven and Kotlin (like IntelliJ)
* Build the project with the IDE, or Maven
* Start the Spring Boot application using the main class KotlinSpringApplication

The REST API is accessible via http://127.0.0.1:8080/ per default. It's HATEOAS enabled.
Remember to use Content-Type application/json when posting data to be persisted.

There is a ping method at http://127.0.0.1:8080/ping/

To run the tests, use the RestApplicationTest class.

## The lightning talk live-coding

The presentation is pretty much three slides, will be put here when it's done.

For the live coding, switch from master branch to the "for-demo" branch, which has no code in it,
just the pom.xml, application.properties and the documentation .md files.

Then follow the steps in [TODO](TODO.md). If you run into trouble, peek in the master branch,
as there is a solution there that works.

## Contact/feedback/praise

E-mail: [magnus.mickelsson@gmail.com](mailto:magnus.mickelsson@gmail.com)

If you want to buy me a beer, donate at https://www.paypal.com/pools/c/821lf4bmi6 (Pokeraidbot project donation page, but 
will reach me anyway)
