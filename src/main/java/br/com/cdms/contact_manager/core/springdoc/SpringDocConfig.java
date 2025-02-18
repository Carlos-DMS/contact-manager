package br.com.cdms.contact_manager.core.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Pessoas e seus contatos")
                        .version("v1")
                        .description("API REST que gerencia pessoas, contatos e a relação entre eles.")
                        .contact(new Contact()
                                .name("LinkedIn")
                                .url("https://www.linkedin.com/in/carlos-daniel-martins-sanguino-72b46a2a0/")
                        )
        );
    }
}
