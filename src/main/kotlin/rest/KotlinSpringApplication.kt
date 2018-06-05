package rest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = arrayOf("rest"))
class KotlinSpringApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringApplication::class.java, *args)
}