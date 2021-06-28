package com.example.customer_management.config;

import com.example.customer_management.logger.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
    @Bean
    public Logger creatrLogger(){
        return new Logger();
    }
}
