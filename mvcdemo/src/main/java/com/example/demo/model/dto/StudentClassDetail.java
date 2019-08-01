/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.dto;

import com.example.demo.data.StudentClassData;
import com.example.demo.data.StudentData;
import com.example.demo.model.Student;
import com.example.demo.model.StudentClass;
import java.util.List;

/**
 *
 * @author rahul
 */
public class StudentClassDetail {
    private List<Student> students;
    private List<StudentClass> studentClasses;

    public StudentClassDetail(List<Student> students, List<StudentClass> studentClasses) {
        this.students = students;
        this.studentClasses = studentClasses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<StudentClass> getStudentClasses() {
        return studentClasses;
    }

    public void setStudentClasses(List<StudentClass> studentClasses) {
        this.studentClasses = studentClasses;
    }

    @Override
    public String toString() {
        return "StudentClassDetail{" + "students=" + students + ", studentClasses=" + studentClasses + '}';
    }
    
}
