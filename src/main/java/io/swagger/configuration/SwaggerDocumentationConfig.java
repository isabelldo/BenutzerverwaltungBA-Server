package io.swagger.configuration;

import io.swagger.model.User;
import io.swagger.repository.UserRepository;
import io.swagger.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-10-13T12:32:13.695655691Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Rollenverwaltung-API")
                .description("Eine rollenbasierte REST-API für die Benutzerverwaltung")
                .termsOfService("")
                .version("1.0.0")
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://unlicense.org"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("")));
    }
}
