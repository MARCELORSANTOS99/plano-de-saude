package com.marcelo.plano_de_saude.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfig {
	
	@Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Plano de Saúde")
                        .version("v1")
                        .description("API REST para manter o cadastro\r\n"
                        		+ "de beneficiários de um plano de saúde")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")
                        )
                )
                
                .tags(
                        Arrays.asList(
                                new Tag().name("Admin").description("Admin Messages"),
                                new Tag().name("User").description("User Messages")
                        )
                );
    }
}