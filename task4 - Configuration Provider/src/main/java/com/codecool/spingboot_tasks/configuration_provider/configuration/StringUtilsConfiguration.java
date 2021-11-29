package com.codecool.spingboot_tasks.configuration_provider.configuration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringUtilsConfiguration {

    @Bean
    public StringUtils stringUtils(){
        return new StringUtils();
    }
}
