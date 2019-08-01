/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author nihar
 */


public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public StudentNotFoundException(String message) {
        super(message);
    }
    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

}
