package com.morgana.common.config;

import com.morgana.common.util.IdUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public IdUtils idUtils(){
        return new IdUtils(0,0);
    }
}
