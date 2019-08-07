/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rahul
 */
@Controller
public class SpringController {
    
    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping("/login")
    public String login() {
        return "login.jsp";
    }

    @RequestMapping("/logout-success")
    public String logoutSuccess() {
        return "logout.jsp";
    }
    
    @RequestMapping("access-denied")
    public String accessDeniedPage() {
        return "access-denied.jsp";
    }
}
