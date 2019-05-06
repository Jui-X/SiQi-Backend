package com.yinlingweilai.siqibackend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-05-04 19:21
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("file:C:/Users/50131/Documents/GitHub/SiQi-Backend/src/main/resources/face/");
    }
}
