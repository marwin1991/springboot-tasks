package com.codecool.spingboot_tasks.configuration_provider.service;

import org.springframework.stereotype.Service;

@Service
public class NameService {

    private static final String NAME = "CodeCool";

    public String getName(){
        return NAME;
    }
}
