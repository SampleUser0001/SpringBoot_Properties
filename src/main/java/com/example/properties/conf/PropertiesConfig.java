package com.example.properties.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
// 任意のpropertiesを読み込む場合は必要。今回はapplication.propertiesなので宣言しない。
// @PropertySource(value = "classpath:custom.properties")
public class PropertiesConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer appProperties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
