package com.yinlingweilai.siqibackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yinlingweilai.siqibackend.DAO")
@ComponentScan("com.yinlingweilai.siqibackend")
@SpringBootApplication
public class SiQiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiQiBackendApplication.class, args);
    }

}
