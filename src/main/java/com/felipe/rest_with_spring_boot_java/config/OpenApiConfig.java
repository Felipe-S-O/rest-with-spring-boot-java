package com.felipe.rest_with_spring_boot_java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API with Spring Boot and Java Kubernetes and Docker")
                        .version("v1")
                        .description("REST API's RESTful from 0 with java, Spring Bott, Kubernetes and Docker")
                        .termsOfService("https://inottec.com.br")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://inottec.com.br")));
    }
}
