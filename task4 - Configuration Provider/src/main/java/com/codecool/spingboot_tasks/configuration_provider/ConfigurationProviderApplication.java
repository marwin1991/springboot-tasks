package com.codecool.spingboot_tasks.configuration_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ConfigurationProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationProviderApplication.class, args);
	}

}
