# SpringBoot Properties

SpringBootでpropertiesを読み込む。

- [SpringBoot Properties](#springboot-properties)
  - [Spring Initalizer](#spring-initalizer)
  - [src](#src)
    - [SamplePropertiesConfig.java](#samplepropertiesconfigjava)
    - [PropertiesServiceModel.java](#propertiesservicemodeljava)
    - [main](#main)
  - [実行](#実行)
    - [実行結果](#実行結果)
  - [参考](#参考)


## Spring Initalizer

- None

## src

### SamplePropertiesConfig.java

```java
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
```

### PropertiesServiceModel.java

``` java
package com.example.properties.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
@Service
public class PropertiesServiceModel {
    @Value("${props.hoge}")
    private String hoge;
    @Value("${props.piyo}")
    private String piyo;
    @Value("${sample.hoge}")
    private String sampleHoge;
}

```

### main

``` java
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

```

## 実行

``` bash
mvn clean compile spring-boot:run
```

### 実行結果

```
2023-09-03 18:52:14.925  INFO 18563 --- [           main] com.example.properties.AppApplication    : hoge: hoge
2023-09-03 18:52:14.925  INFO 18563 --- [           main] com.example.properties.AppApplication    : piyo: piyo
2023-09-03 18:52:14.925  INFO 18563 --- [           main] com.example.properties.AppApplication    : sample.hoge: samplehog

```

## 参考

- [【Spring Boot】プロパティファイル:b1san's Blog](https://b1san-blog.com/post/spring/spring-properties/)