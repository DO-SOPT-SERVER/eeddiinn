package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SeminarApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(SeminarApplication.class, args);
    }
}
