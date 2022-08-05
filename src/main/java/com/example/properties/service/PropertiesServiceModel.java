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
