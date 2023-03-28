package com.dynamicdoers.hwapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public int getMyId(){
        return 5;
    }

    @Bean
    public String getMyName(){
        return "Mr.Tra";
    }

    @Bean
    public String getMyEmail(){
        return "mr.tra@gmail.com";
    }
}
