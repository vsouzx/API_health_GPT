package br.com.souza.healthGPT.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();

        contact.setEmail("abs@absoftware.com.br");
        contact.setName("Vitor Souza");
        contact.setUrl("https://vsportfolio.com.br");

        Info info = new Info()
                .title("Diet Generator")
                .version("1.0")
                .description("Diet Generator REST API integrated with Open AI Api.")
                .contact(contact);

        return new OpenAPI().info(info);
    }
}
