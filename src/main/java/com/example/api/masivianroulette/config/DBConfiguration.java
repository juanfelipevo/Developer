package com.example.api.masivianroulette.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.api.masivianroulette.repository")
@EntityScan("com.example.api.masivianroulette.model")
public class DBConfiguration {

}
