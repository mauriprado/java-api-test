package com.devweb.modelvirtualbe.products.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("productsMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ShopMapper shopMapper() {
        return new ShopMapper();
    }
}