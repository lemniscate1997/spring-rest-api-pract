/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.controller;

import java.util.ArrayList;
import java.util.List;
import com.rest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.service.StudentService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author rahul
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @RequestMapping(value = "")
    public ResponseEntity<Map<String, String>> init(@RequestHeader Map<String, String> headers) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", headers.get("content-type"))
                .body(headers);
    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getStudents(@RequestHeader Map<String, String> headers) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", headers.get("content-type"))
                .body(studentService.getStudents());
    }

//    @GetMapping(value = "/student/{studentId}", produces = "application/xml")
    @GetMapping(value = "/student/{studentId}")
    public ResponseEntity<Student> getStudent(@RequestHeader Map<String, String> headers, @PathVariable int studentId) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", headers.get("content-type"))
                .body(studentService.getStudent(studentId));
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PostMapping(value = "/add")
    public ResponseEntity<String> addStudent(@RequestHeader Map<String, String> headers, @RequestBody @Valid Student student) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", headers.get("content-type"))
                .body(studentService.addStudent(student));
    }

    @PutMapping(value = "/modify")
    public ResponseEntity<String> updateStudentDetails(@RequestHeader Map<String, String> headers, @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", headers.get("content-type"))
                .body(studentService.updateStudent(student.getId(), student));
    }

    @DeleteMapping(value = "/remove/{studentId}")
    public ResponseEntity<String> removeStudent(@RequestHeader Map<String, String> headers, @PathVariable int studentId) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", headers.get("content-type"))
                .body(studentService.deleteStudent(studentId));
    }
}
