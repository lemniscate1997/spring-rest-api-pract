/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.security.service;

import java.util.List;
import com.rest.security.model.Student;

/**
 *
 * @author rahul
 */
public interface StudentService {
    public List<Student> getStudents();
    public Student getStudent(int id);
    public String addStudent(Student student);
    public String updateStudent(int id, Student student);
    public String deleteStudent(int id);
}
