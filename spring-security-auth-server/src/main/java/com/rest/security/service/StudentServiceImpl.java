/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.security.service;

import com.rest.security.errorhandler.StudentNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import com.rest.security.model.Student;
import com.rest.security.model.StudentMock;
import com.rest.security.repository.StudentRepositoryImpl;
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

    @Autowired(required = true)
    private StudentRepositoryImpl studentRepositoryImpl;

    @Override
    public List<Student> getStudents() {
        return studentRepositoryImpl.findAll();
//        return studentMock.getStudents();
    }

    @Override
    public Student getStudent(int id) {
//        try {
//            Student student1 = studentMock.getStudents().
//                    stream().filter(p -> p.getId() == id).findFirst().get();
//
//            int index = studentMock.getStudents().indexOf(student1);
//            return studentMock.getStudents().get(index);
//        } catch (Exception e) {
//            if (e.getLocalizedMessage() == "No value present") {
//                throw new StudentNotFoundException("Student Not Found With Id " + id);
//            } else {
//                throw new Error(e);
//            }
//        }
        try {
            return studentRepositoryImpl.findUserById(id);
        } catch (Exception e) {
            throw new StudentNotFoundException("Student Not Found With Id " + id);
        }
    }

    @Override
    public String addStudent(Student student) {
//        studentMock.getStudents().add(student);
        try {
            Student stud = studentRepositoryImpl.create(student);
            System.out.println("************** created **********" + stud);
            return "{message : Student Created successful}";
        } catch (Exception e) {
            throw new StudentNotFoundException("Student Creation failed");
        }
    }

    @Override
    public String updateStudent(int id, Student student) {
//        try {
//
//            Student student1 = studentMock.getStudents().
//                    stream().filter(p -> p.getId() == id).findFirst().get();
//            int index = studentMock.getStudents().indexOf(student1);
//            studentMock.getStudents().set(index, student);
//            return "{message : successful}";
//        } catch (Exception e) {
//            if (e.getLocalizedMessage() == "No value present") {
//                throw new StudentNotFoundException("Student Not Found With Id " + id);
//            } else {
//                throw new Error(e);
//            }
//        }

        try {
            Student stud = studentRepositoryImpl.findUserById(id);
            if (studentRepositoryImpl.modify(id, student)) {
                return "{message : student detail modified successfully}";
            } else {
                throw new StudentNotFoundException("Updation failed");
            }
        } catch (Exception e) {
            throw new StudentNotFoundException("Student Not Found With Id " + id);
        }
    }

    @Override
    public String deleteStudent(int id) {
//        try {
//            Student student1 = studentMock.getStudents().
//                    stream().filter(p -> p.getId() == id).findFirst().get();
//            int index = studentMock.getStudents().indexOf(student1);
//            studentMock.getStudents().remove(index);
//            return "{message : successful}";
//        } catch (Exception e) {
//            if (e.getLocalizedMessage() == "No value present") {
//                throw new StudentNotFoundException("Student Not Found With Id " + id);
//            } else {
//                throw new Error(e);
//            }
//        }
        try {
            Student stud = studentRepositoryImpl.findUserById(id);
            if (studentRepositoryImpl.remove(id)) {
                return "{message : student removed successfully}";
            } else {
                throw new StudentNotFoundException("Operation for delete failed");
            }
        } catch (Exception e) {
            throw new StudentNotFoundException("Student Not Found With Id " + id);
        }
    }

}
