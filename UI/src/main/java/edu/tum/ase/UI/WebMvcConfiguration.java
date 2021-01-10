package edu.tum.ase.UI;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("*").addResourceLocations("/static/index.html");
        registry.addResourceHandler("/*").addResourceLocations("/static/index.html");
        //registry.addResourceHandler("/**/*").addResourceLocations("/static/index.html");
        //registry.addResourceHandler("/**/**/*").addResourceLocations("/static/index.html");
    }
}

