package com.java.banhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BanhangApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanhangApplication.class, args);
    }

}
