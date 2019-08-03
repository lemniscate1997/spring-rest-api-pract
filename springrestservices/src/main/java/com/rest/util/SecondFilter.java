/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.util;

import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author rahul
 */
//@Component
//@Order(2)
public class SecondFilter implements Filter {

    //this method will be called by container when we send any request 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Second doFilter() method is invoked");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        chain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("Second doFilter() method is ended");

    }

    // this method will be called by container while deployment
    public void init(FilterConfig config) throws ServletException {

        System.out.println("init() method has been get invoked");
        System.out.println("Filter name is " + config.getFilterName());
        System.out.println("ServletContext name is" + config.getServletContext());
        System.out.println("init() method is ended");
    }

    public void destroy() {
        //do some stuff like clearing the resources

    }
}
