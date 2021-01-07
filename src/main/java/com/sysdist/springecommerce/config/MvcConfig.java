package com.sysdist.springecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public  class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/notprotected").setViewName("notprotected");
        registry.addViewController("/").setViewName("notprotected");
        registry.addViewController("/protected").setViewName("protected");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("disconnected");
    }
}
