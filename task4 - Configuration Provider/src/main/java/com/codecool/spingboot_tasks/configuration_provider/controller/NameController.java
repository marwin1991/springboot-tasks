package com.codecool.spingboot_tasks.configuration_provider.controller;

import com.codecool.spingboot_tasks.configuration_provider.service.NameService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Scope("${name_controller.scope:singleton}")
@RestController
public class NameController {

    private final NameService nameService;

    @PostConstruct
    public void init(){
        System.out.println("NameService created");
    }

    @Autowired
    public NameController(NameService nameService, StringUtils stringUtils) {
        this.nameService = nameService;
    }

    @GetMapping("${about.path:/about}")
    public String about(){
        return nameService.getName();
    }
}
