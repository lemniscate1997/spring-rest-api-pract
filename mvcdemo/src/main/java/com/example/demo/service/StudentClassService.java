package com.example.demo.service;


import com.example.demo.model.StudentClass;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rahul
 */
public interface StudentClassService {
    public void addStudentClass(StudentClass studentClass);
    
    public List<StudentClass> getStudentClassses();
}
