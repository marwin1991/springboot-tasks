package com.codecool.spingboot_tasks.configuration_provider.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    private Gson gson;

    @Value("${client.name:CodeCool}")
    private String name;

    @Autowired
    public NameService(Gson gson) {
        this.gson = gson;
    }

    public String getName(){
        return name;
    }

}
