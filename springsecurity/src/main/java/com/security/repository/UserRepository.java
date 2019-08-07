/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.repository;

import com.security.model.Role;
import com.security.model.User;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rahul
 */
@Service
public class UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return jdbcTemplate.queryForObject(
                "select * from users where username=?",
                new Object[]{username},  new int[]{Types.VARCHAR}, new UserRowMapper());
    }
    
    @Transactional(readOnly = true)
    public List<Role> getRolesByUserId(int userId) {
        return jdbcTemplate.query(
                "select roles.id, role from roles inner join user_role on roles.id=user_role.user_id where user_id=?",
                new Object[]{userId},  new int[]{Types.INTEGER}, new RoleRowMapper());
    }
}

class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));

        return user;
    }

}

