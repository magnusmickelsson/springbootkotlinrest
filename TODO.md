#To-do coding to get example running

This is a list of the code needed to get the example up and running, as part of a live-coding exercise of about 5 minutes.

* Create main class for Spring Boot: KotlinSpringApplication
* Create ping REST controller
* Create BlogEntry entity class (Kotlin data class)
    * Override the toString method
* Create BlogEntry repository Spring Data JPA repository interface
    * Annotate that it should be a REST repository
* Test starting the application, and browsing the main REST API URL, and the ping URL
* Create tests in RestApplicationTest
    * Ping method verification
    * Test verifying that create BlogEntry entity works
* Run tests