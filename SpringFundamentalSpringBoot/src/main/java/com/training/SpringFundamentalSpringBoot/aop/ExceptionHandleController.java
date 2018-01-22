package com.training.SpringFundamentalSpringBoot.aop;

import com.training.SpringFundamentalSpringBoot.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity handleResourceNotFound(ResourceNotFoundException e) {

        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
