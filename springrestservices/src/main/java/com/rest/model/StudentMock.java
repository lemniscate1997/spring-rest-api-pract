/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.model;

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

        students.add(new Student("Nihar Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student("Viren Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student("Nikunj Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student("Priyam Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student("Chandu Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student("Purvit Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
