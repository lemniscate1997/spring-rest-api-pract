/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.security.service;

import com.rest.security.model.Role;
import com.rest.security.model.User;
import com.rest.security.model.UserPrincipal;
import com.rest.security.repository.AuthRepository;
import com.rest.security.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author rahul
 */
@Service
public class UserDetailsServices implements UserDetailsService {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Autowired(required = true)
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        List<Role> roles = userRepository.getRolesByUserId(user.getId());
        return new UserPrincipal(user, roles);
    }

    public List<Role> getAuthorizationList() {
        return authRepository.getRoles();
    }

    public User loadUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user;
    }
}
