package com.codecool.spingboot_tasks.error_handling.configuration;

import com.codecool.spingboot_tasks.error_handling.exeption.ProductCreateException;
import com.codecool.spingboot_tasks.error_handling.exeption.ProductUpdateException;
import com.codecool.spingboot_tasks.error_handling.model.BackendError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ResponseBody
    @ExceptionHandler({ProductUpdateException.class, ProductCreateException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public BackendError productUpdateExceptionHandler(RuntimeException ex) {
        return new BackendError(ex.getMessage(), 3);
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BackendError handleException(Exception ex) {
        return new BackendError(ex.getMessage(), 1);
    }

}
