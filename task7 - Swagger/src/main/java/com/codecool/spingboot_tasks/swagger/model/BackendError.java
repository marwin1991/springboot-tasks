package com.codecool.spingboot_tasks.swagger.model;

import lombok.Data;

@Data
public class BackendError {
    private String msg;
    private int lvl;
}
