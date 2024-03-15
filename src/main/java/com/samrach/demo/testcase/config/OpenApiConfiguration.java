package com.samrach.demo.testcase.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public GroupedOpenApi backendGroup(){
        return GroupedOpenApi.builder().group("Backend Api").addOpenApiCustomizer(
                openApi -> openApi.info(
                        getBackendInfo()
                )
        ).packagesToScan("com.samrach.demo.testcase.controller").build();
    }

    private Info getBackendInfo() {
        Contact contact = new Contact();
        contact.setEmail("samrach@gmail.com");
        contact.setName("Samrach");
        contact.setUrl("https://github.com/pksrach");

        return new Info()
                .title("Backend API Demo")
                .description("Backend API for the application")
                .version("1.0.0")
                .contact(contact);
    }


}
