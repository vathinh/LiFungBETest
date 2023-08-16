package com.tvt.lifungbetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.ZonedDateTime;
import java.util.Optional;

@SpringBootApplication
@ConfigurationPropertiesScan({"com.tvt.lifungbetest.config"})
public class LifungBeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifungBeTestApplication.class, args);
    }


}
