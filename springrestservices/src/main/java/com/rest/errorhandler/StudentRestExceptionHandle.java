/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.errorhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author nihar
 */
@ControllerAdvice
public class StudentRestExceptionHandle {

    @ExceptionHandler
    public ResponseEntity<StudentErrorRespone> handleException(StudentNotFoundException ex) {

        StudentErrorRespone error = new StudentErrorRespone();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Content-Type", "application/json").body(error);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorRespone> handleException(Exception ex) {

        StudentErrorRespone error = new StudentErrorRespone();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Content-Type", "application/json").body(error);
    }
}
