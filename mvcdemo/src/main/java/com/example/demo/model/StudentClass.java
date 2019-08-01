/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

/**
 *
 * @author rahul
 */
public class StudentClass {

    private int id;
    private int roomNo;
    private String className;

    public StudentClass() {
    }

    public StudentClass(int id, int roomNo, String className) {
        this.id = id;
        this.roomNo = roomNo;
        this.className = className;
    }
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "StudentClass{" + "id=" + id + ", roomNo=" + roomNo + ", className=" + className + '}';
    }
    
    
}
