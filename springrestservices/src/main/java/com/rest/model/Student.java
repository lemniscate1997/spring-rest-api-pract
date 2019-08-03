/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rahul
 */
public class Student {

    private int id;

    @NotNull(message = "Please enter name")
    @Size(min = 3, max = 15, message = "Name must be between 10 and 200 characters")
    private String name;

    @NotNull(message = "Please enter mob")
    @Size(min = 10, max = 10, message = "Mobile number must be size of 10")
    private String mob;

    @NotNull(message = "Please enter mailId")
    @Email(message = "Email should be valid")
    private String email;

//    static int sequence;

//    static {
//        sequence = 1;
//    }
//
//    {
//        this.id = sequence;
//        sequence++;
//    }

    public Student() {
    }

    public Student(String name, String mob, String email) {
        this.name = name;
        this.mob = mob;
        this.email = email;
    }

    public Student(int id, String name, String mob, String email) {
        this.id = id;
        this.name = name;
        this.mob = mob;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", mob=" + mob + ", email=" + email + '}';
    }

}
