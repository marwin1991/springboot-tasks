package com.codecool.spingboot_tasks.configuration_provider.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    //private static final String name = "CodeCool B2B";

    @Value("${company.name}")
    private String name;

    public String getName(){
        return name;
    }

}
