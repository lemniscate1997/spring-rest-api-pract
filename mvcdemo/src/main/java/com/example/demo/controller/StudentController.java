/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.dto.StudentClassDetail;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rahul
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String intialize() {
        return "In student controller";
    }

    @PostMapping("/addStudent")
    public String addStudentData(@RequestBody Student student) throws IOException {
        System.out.println("Hello");
//        ObjectMapper mapper = new ObjectMapper();
//        Student st = mapper.readValue(student, Student.class);
//        System.out.println("" + st.getName());
//        this.studentService.addStudent(st);
        System.out.println("" + student.getName());
        this.studentService.addStudent(student);
        return "successful";
    }

    @GetMapping("/getStudents")
    public String getStudents() {
        return "" + this.studentService.getStudents();
    }

    @RequestMapping("/getStudent/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return null;
    }

    public StudentClassDetail getStudentClassDetail() {
        return this.studentService.getStudentClassDetail();
    }
}
