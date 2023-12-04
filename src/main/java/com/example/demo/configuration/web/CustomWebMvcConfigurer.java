package com.example.demo.configuration.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;


@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/js/**", "/css/**", "/images/**", "/img /**")
                .addResourceLocations("classpath:src/main/resources/static/img/","classpath:src/main/resources/static/js/", "classpath:src/main/resources/static/css/",
                        "file:/Univer/PBL_anul2_sem/Uploaded_files") //to change in dependence of resources path
//                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}

