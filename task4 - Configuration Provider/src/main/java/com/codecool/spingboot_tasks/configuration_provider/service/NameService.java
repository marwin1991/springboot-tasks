package com.codecool.spingboot_tasks.configuration_provider.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    private static final String name = "CodeCool"

    public String getName(){
        return name;
    }

}
