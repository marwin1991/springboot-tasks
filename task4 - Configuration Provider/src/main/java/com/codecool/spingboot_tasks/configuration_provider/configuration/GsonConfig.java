package com.codecool.spingboot_tasks.configuration_provider.configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GsonConfig {

    @Primary
    @Bean("simpleGson")
    public Gson getGson(){
        return new Gson();
    }

    @Bean("superGson")
    public Gson getSuperGson(){
        return new Gson();
    }

}
