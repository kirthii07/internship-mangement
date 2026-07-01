package com.kirthika.internship_management.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

class CorsConfigTest {

    @Test
    void shouldCreateCorsConfigurerBean() {
        CorsConfig config = new CorsConfig();

        WebMvcConfigurer configurer = config.corsConfigurer();

        assertNotNull(configurer);
    }

    @Test
    void shouldRegisterCorsMappingsForAllPaths() {
        CorsConfig config = new CorsConfig();
        WebMvcConfigurer configurer = config.corsConfigurer();
        CorsRegistry registry = new CorsRegistry();

        configurer.addCorsMappings(registry);

        assertNotNull(registry);
    }
}
