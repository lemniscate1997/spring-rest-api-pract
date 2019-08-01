/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.serviceimpl;

import com.example.demo.data.StudentClassData;
import com.example.demo.model.StudentClass;
import com.example.demo.service.StudentClassService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rahul
 */

@Service
public class StudentClassServiceImpl implements StudentClassService{

    private StudentClassData studentClassData;

    @Autowired
    public StudentClassServiceImpl(StudentClassData studentClassData) {
        this.studentClassData = studentClassData;
    }
        
    @Override
    public void addStudentClass(StudentClass studentClass) {
        this.studentClassData.addStudentClass(studentClass);
    }

    @Override
    public List<StudentClass> getStudentClassses() {
        return this.studentClassData.getStudentClasses();
    }
    
}
