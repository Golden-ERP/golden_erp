package com.goldenconsultingci.erp.common;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SecurityScheme(
        name = "Authorization",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER,
        paramName = "Authorization")
public class SwaggerDocConfig {

    @Bean
    public OpenAPI openAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Server URL in Development environment");
        return new OpenAPI().info(info()).servers(List.of(devServer));
    }

    private Info info() {
        return new Info()
                .title("GOLDEN ERP")
                .version("1.0.0")
                .contact(contact())
                .description("This API exposes endpoints to manage ERP");
    }

    private Contact contact() {
        Contact contact =  new Contact();
        contact.setEmail("david.kouakou@aurosaas.com");
        contact.setName("David KY");
        contact.setUrl("https://www.aurosaas.com");
        return contact;
    }
}
