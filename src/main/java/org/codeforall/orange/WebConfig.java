/*package org.codeforall.orange;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Match all API paths
                .allowedOrigins("*") // Allow specific frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow methods
                .allowedHeaders("Content-Type", "Authorization") // Allow specific headers
                .allowCredentials(true) // Allow credentials (cookies, HTTP auth)
                .maxAge(3600); // Cache preflight requests for 1 hour
    }
}
*/