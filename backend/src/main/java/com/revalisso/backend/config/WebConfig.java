package com.revalisso.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //Con esto se va a poder servir las imagenes del backend
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // carpeta "uploads" en la raíz del proyecto
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/")  // <- importante "file:"
                .setCachePeriod(3600)                    // opcional, para cache
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}
