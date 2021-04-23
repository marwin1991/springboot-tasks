package com.codecool.spingboot_tasks.request_counter.model;

import lombok.Data;

@Data
public class Statistics {
    private String methodName;
    private int usage;
}
