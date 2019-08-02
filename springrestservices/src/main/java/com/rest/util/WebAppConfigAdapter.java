/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author rahul
 */
@Component
public class WebAppConfigAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    InterceptorConfig interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        System.out.println("this method will get invoked by container while deployment");
        System.out.println("value of interceptor is " + interceptor);
        //adding custom interceptor
        interceptorRegistry.addInterceptor(interceptor);
    }
}
