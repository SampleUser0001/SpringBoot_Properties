package com.example.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.properties.service.PropertiesServiceModel;

@SpringBootApplication
public class AppApplication {

    private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

    @Autowired
    PropertiesServiceModel properties;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            log.info("hoge: {}", properties.getHoge());
            log.info("piyo: {}", properties.getPiyo());
            log.info("sample.hoge: {}", properties.getSampleHoge());
        };
    }


}
