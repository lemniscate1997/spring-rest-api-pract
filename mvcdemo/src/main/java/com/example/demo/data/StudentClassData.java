/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.data;

import com.example.demo.model.StudentClass;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author rahul
 */

@Service
public class StudentClassData {
    private List<StudentClass> studentClasses;

    public StudentClassData(List<StudentClass> studentClasses) {
        this.studentClasses = studentClasses;
    }
    
    public void addStudentClass(StudentClass studentClass) {
        this.studentClasses.add(studentClass);
    }
    
    public List<StudentClass> getStudentClasses() {
        return studentClasses;
    }
}
