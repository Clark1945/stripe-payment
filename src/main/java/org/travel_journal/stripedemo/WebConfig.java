package org.travel_journal.stripedemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Allow any origin. avoid CORS error
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) { // 允許跨來源的存取
        registry.addMapping("/**")
                .allowedOrigins("*") // 或指定來源，例如 "http://localhost"
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);
    }
}

