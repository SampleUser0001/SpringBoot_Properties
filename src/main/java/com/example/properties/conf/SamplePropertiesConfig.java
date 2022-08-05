package com.example.properties.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
// 任意のpropertiesを読み込む場合は必要。application.propertiesの場合、Serviceがあれば読める。
@PropertySource(value = "classpath:sample.properties")
public class SamplePropertiesConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer sampleProperties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}