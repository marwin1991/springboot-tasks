package com.codecool.spingboot_tasks.error_handling.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
   
   private String errorMessage;
   
   public ProductNotFoundException(String message) {
      super(message);
      this.errorMessage = message;
   }
}