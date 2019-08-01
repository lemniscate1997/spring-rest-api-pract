/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.serviceimpl;

import com.example.demo.data.StudentClassData;
import com.example.demo.data.StudentData;
import com.example.demo.model.Student;
import com.example.demo.model.dto.StudentClassDetail;
import com.example.demo.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rahul
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentData studentData;
    private StudentClassData studentClassData;

    @Autowired
    public StudentServiceImpl(StudentData studentData, StudentClassData studentClassData) {
        this.studentData = studentData;
        this.studentClassData = studentClassData;
    }

    @Override
    public void addStudent(Student student) {
        this.studentData.addStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        return this.studentData.getStudents();
    }

    @Override
    public StudentClassDetail getStudentClassDetail() {
        return new StudentClassDetail(this.studentData.getStudents(), this.studentClassData.getStudentClasses());
    }

}
