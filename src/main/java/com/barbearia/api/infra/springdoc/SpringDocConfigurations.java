package com.barbearia.api.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                        .info(new Info()
                                .title("Barbearia.com API")
                                .description("App Barbearia é um aplicativo para gestão de atendimento de clientes e barbeiros. O aplicativo deve possuir funcionalidades que permitam o cadastro de barbeiros e de clientes, e também o agendamento e cancelamento de atendimento")
                                .contact(new Contact()
                                        .name("Adriano Azevedo")
                                        .email("adr_ba@yahoo.com.br"))
                        .license(new License()
                                .name("MIT")
                                .url("https://github.com/adrianoazevedo/barbearia/blob/main/LICENSE")));
    }
}
