package fr.alexander.apicsharp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig {
    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/ApiSharp/api/v1/User/**")
                    .allowedOrigins("http://192.168.1.73:8080")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*")
                    .exposedHeaders("Authorization")

                registry.addMapping("/ApiSharp/api/v1/Article/**")
                    .allowedOrigins("http://192.168.1.73:8080")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*")
                    .exposedHeaders("Authorization")

                registry.addMapping("/ApiSharp/api/v1/Conference/**")
                    .allowedOrigins("http://192.168.1.73:8080")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*")
                    .exposedHeaders("Authorization")
            }
        }
    }
}