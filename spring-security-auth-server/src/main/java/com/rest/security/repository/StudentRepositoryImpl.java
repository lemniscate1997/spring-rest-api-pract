/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.security.repository;

import com.rest.security.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rahul
 */
@Transactional
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public Student findUserById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from student where id=?",
                new Object[]{id}, new StudentRowMapper());
    }

    @Override
    public Student create(final Student student) {
        final String sql = "insert into student(name,mob,email) values(?,?,?)";

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, student.getName());
                ps.setString(2, student.getMob());
                ps.setString(3, student.getEmail());
                return ps;
            }
        }, holder);

        int newUserId = (Integer) holder.getKeys().get("id");
        student.setId(newUserId);
        return student;
    }

    @Override
    public boolean modify(final int id, final Student student) {
        final String sql = "update student set name=?, mob=?, email=? where id=?";

//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.setString(1, student.getName());
//                ps.setString(2, student.getMob());
//                ps.setString(3, student.getEmail());
//                ps.setInt(4, id);
//                return ps;
//            }
//        });

        Object[] params = new Object[]{student.getName(), student.getMob(), student.getEmail(), student.getId()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};

        int result = jdbcTemplate.update(sql, params, types);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        final String sql = "delete from student where id=?";

//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.setInt(1, id);
//                return ps;
//            }
//        });
//        return true;
        Object[] params = new Object[]{id};
        int[] types = new int[]{Types.INTEGER};
        
        int result = jdbcTemplate.update(sql, params, types);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
}

class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setMob(rs.getString("mob"));
        student.setEmail(rs.getString("email"));

        return student;
    }

}
