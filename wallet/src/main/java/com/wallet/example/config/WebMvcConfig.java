package com.wallet.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public WebMvcConfig() {
    }
    @Bean
    public HandlerInterceptor getAuthorizeMiddleware() {
        return new AuthorizeMiddleware();
    }
}
