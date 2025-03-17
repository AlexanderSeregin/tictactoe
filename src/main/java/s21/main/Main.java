package s21.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("s21.web.controller")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}