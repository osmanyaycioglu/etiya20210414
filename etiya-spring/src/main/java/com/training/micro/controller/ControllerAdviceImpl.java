package com.training.micro.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.micro.error.MyError;

@RestControllerAdvice
public class ControllerAdviceImpl {

    @ExceptionHandler(IllegalArgumentException.class)
    public MyError handleExp(final IllegalArgumentException exp) {
        return MyError.getBuilder()
                      .setError(exp.getMessage())
                      .setCause(1000);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MyError handleExp(final MethodArgumentNotValidException exp) {
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        StringBuilder builderLoc = new StringBuilder();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            builderLoc.append(objectErrorLoc.getDefaultMessage());
            builderLoc.append("\n");
        }
        return MyError.getBuilder()
                      .setError(builderLoc.toString())
                      .setCause(2000);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public MyError handleExp(final ConstraintViolationException exp) {
        Set<ConstraintViolation<?>> constraintViolationsLoc = exp.getConstraintViolations();
        StringBuilder builderLoc = new StringBuilder();
        for (ConstraintViolation<?> objectErrorLoc : constraintViolationsLoc) {
            builderLoc.append(objectErrorLoc.toString());
            builderLoc.append("\n");
        }
        return MyError.getBuilder()
                      .setError(builderLoc.toString())
                      .setCause(3000);
    }

    @ExceptionHandler(Exception.class)
    public MyError handleExp(final Exception exp) {
        return MyError.getBuilder()
                      .setError(exp.getMessage())
                      .setCause(5000);
    }

}
