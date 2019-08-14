package com.codeinvestigator.demodatarepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoDataRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDataRepositoryApplication.class, args);
    }

}
