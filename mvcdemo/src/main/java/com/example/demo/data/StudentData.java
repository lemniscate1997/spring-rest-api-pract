/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.data;

import com.example.demo.model.Student;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author rahul
 */

@Service
public class StudentData{
    private List<Student> students;

    public StudentData(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
    
    public List<Student> getStudents() {
        return students;
    }
}
