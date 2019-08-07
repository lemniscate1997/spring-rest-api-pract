/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.security.model;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 *
 * @author rahul
 */
@Component
public class StudentMock {

    private ArrayList<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("Rahul Patel", "9714319500", "patelrahul1997.pn@gmail.com"));
        students.add(new Student("Ravi Patel", "9714319500", "patelravi1997.pn@gmail.com"));
        students.add(new Student("Rushbh Patel", "9714319500", "patelrushbh1997.pn@gmail.com"));
        students.add(new Student("Dhruvin Patel", "9714319500", "pateldhruvin1997.pn@gmail.com"));
        students.add(new Student("Brijesh Patel", "9714319500", "patelbrijesh1997.pn@gmail.com"));
        students.add(new Student("Nikunj Patel", "9714319500", "patelnukunj1997.pn@gmail.com"));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
