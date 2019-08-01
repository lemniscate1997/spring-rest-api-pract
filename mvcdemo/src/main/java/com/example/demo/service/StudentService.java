/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.dto.StudentClassDetail;
import java.util.List;

/**
 *
 * @author rahul
 */
public interface StudentService {
    public void addStudent(Student student);
    
    public List<Student> getStudents();
    
    public StudentClassDetail getStudentClassDetail(); 
}
