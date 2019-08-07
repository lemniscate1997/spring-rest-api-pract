/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.security.repository;

import com.rest.security.model.Student;
import java.util.List;

/**
 *
 * @author rahul
 */
public interface StudentRepository {
    public List<Student> findAll();
    public Student findUserById(int id);
    public Student create(final Student student);
    public boolean modify(final int id, final Student student);
    public boolean remove(int id);
}
