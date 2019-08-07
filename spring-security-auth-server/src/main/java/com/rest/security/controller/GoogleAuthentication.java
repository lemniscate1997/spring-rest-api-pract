/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.security.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.rest.security.config.GoogleTokenConfig;
import java.io.IOException;
import java.security.GeneralSecurityException;
import static java.util.Objects.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rahul
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/list")
public class GoogleAuthentication {

    @Autowired
    AccessTokenGenerator tokenGenerator;
    
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public OAuth2AccessToken verifyToken(@RequestBody String idToken) throws GeneralSecurityException, IOException, Exception {
        Payload payload = GoogleTokenConfig.verifyToken(idToken);
        if (isNull(payload)) {
            throw new RuntimeException("Unauthenticated User by google");
        }
        return tokenGenerator.generateAccessToken(payload);
    }
}
