/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.service;

import com.security.model.Role;
import com.security.model.User;
import com.security.model.UserPrincipal;
import com.security.repository.AuthRepository;
import com.security.repository.UserRepository;
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
public class UserDetailsServices implements UserDetailsService{
    
    @Autowired(required=true)
    private UserRepository userRepository;
    
    @Autowired(required=true)
    private AuthRepository authRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        user.setRole(userRepository.getRolesByUserId(user.getId()));
        return new UserPrincipal(user);
    }
    
    public List<Role> getAuthorizationList(){
        return authRepository.getRoles();
    }
}
