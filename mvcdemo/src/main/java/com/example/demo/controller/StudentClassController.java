/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.StudentClass;
import com.example.demo.service.StudentClassService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rahul
 */

@Component
public class StudentClassController {
    private StudentClassService studentClassService;

    @Autowired
    public StudentClassController(StudentClassService studentClassService) {
        this.studentClassService = studentClassService;
    }
    
    public void addStudentClassDetail() {
        this.studentClassService.addStudentClass(new StudentClass(1, 12, "Science"));
    }
    
    public List<StudentClass> getStudentClass() {
        return this.studentClassService.getStudentClassses();
    }
}
