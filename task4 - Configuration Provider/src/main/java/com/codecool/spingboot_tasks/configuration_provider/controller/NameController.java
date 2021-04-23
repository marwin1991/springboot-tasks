package com.codecool.spingboot_tasks.configuration_provider.controller;

import com.codecool.spingboot_tasks.configuration_provider.service.NameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    private final NameService nameService;


    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/about")
    public String about(){
        return nameService.getName();
    }
}
