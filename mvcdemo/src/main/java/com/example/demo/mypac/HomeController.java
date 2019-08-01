/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.mypac;

import com.example.demo.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }
    /*
    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return null;
    }
    
    @GetMapping("/getStudent/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return null;
    }

    @PostMapping("/addStudent")
    public String addStudent() {
        System.out.println("HelloController");
//        studentController.addStudentData(student);
//        System.out.println(studentController.getStudents());
//        return "" + studentController.getStudents();
        return "successful";
    }
*/
}