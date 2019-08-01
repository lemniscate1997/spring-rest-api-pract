/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service;

import com.rest.errorhandler.StudentNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import com.rest.model.Student;
import com.rest.model.StudentMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rahul
 */
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired(required = true)
    private StudentMock studentMock;

    @Override
    public List<Student> getStudents() {
        return studentMock.getStudents();
    }

    @Override
    public Student getStudent(int id) {
        try {
            Student student1 = studentMock.getStudents().
                    stream().filter(p -> p.getId() == id).findFirst().get();

            int index = studentMock.getStudents().indexOf(student1);
            return studentMock.getStudents().get(index);
        } catch (Exception e) {
            if (e.getLocalizedMessage() == "No value present") {
                throw new StudentNotFoundException("Student Not Found With Id " + id);
            } else {
                throw new Error(e);
            }
        }
    }

    @Override
    public String addStudent(Student student) {
        studentMock.getStudents().add(student);
        return "{message : successful}";
    }

    @Override
    public String updateStudent(int id, Student student) {
        try {

            Student student1 = studentMock.getStudents().
                    stream().filter(p -> p.getId() == id).findFirst().get();
            int index = studentMock.getStudents().indexOf(student1);
            studentMock.getStudents().set(index, student);
            return "{message : successful}";
        } catch (Exception e) {
            if (e.getLocalizedMessage() == "No value present") {
                throw new StudentNotFoundException("Student Not Found With Id " + id);
            } else {
                throw new Error(e);
            }
        }
    }

    @Override
    public String deleteStudent(int id) {
        try {
            Student student1 = studentMock.getStudents().
                    stream().filter(p -> p.getId() == id).findFirst().get();
            int index = studentMock.getStudents().indexOf(student1);
            studentMock.getStudents().remove(index);
            return "{message : successful}";
        } catch (Exception e) {
            if (e.getLocalizedMessage() == "No value present") {
                throw new StudentNotFoundException("Student Not Found With Id " + id);
            } else {
                throw new Error(e);
            }
        }
    }

}
