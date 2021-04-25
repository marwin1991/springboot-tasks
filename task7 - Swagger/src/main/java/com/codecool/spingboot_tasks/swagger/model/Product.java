package com.codecool.spingboot_tasks.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Product base information")
public class Product {
    @ApiModelProperty(required = true, value = "Identifier")
    private long id;
    @ApiModelProperty(required = true, value = "Name of the product")
    private String name;
    @ApiModelProperty(value = "Price of the product")
    private int price;
}