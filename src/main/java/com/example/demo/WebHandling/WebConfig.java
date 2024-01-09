package com.example.demo.WebHandling;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@Configuration
@EnableWebMvc
@CrossOrigin(origins = "http://97.70.139.147:8080")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/public/", "classpath:/static/").setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
    }
    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				/*registry.addMapping("/api").allowedOrigins("http://localhost:8081");
                registry.addMapping("/api").allowedOrigins("http://localhost:8000");*/
                //registry.addMapping("/resources/update.html").allowedOrigins("*");
			}
		};
	}

}
