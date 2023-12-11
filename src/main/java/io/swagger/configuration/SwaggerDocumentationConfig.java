package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

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
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("")));
    }
}
