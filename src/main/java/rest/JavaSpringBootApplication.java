package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"rest"})
public class JavaSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootApplication.class, args);
    }
}
