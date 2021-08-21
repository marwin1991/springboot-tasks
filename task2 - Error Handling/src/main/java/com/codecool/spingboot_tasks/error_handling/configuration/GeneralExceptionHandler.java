package com.codecool.spingboot_tasks.error_handling.configuration;

import com.codecool.spingboot_tasks.error_handling.exception.ProductNotFoundException;
import com.codecool.spingboot_tasks.error_handling.model.BackendError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GeneralExceptionHandler {

}
