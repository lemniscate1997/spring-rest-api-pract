/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.security.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.rest.security.model.User;
import com.rest.security.service.UserDetailsServices;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Component;

/**
 *
 * @author rahul
 */
@Configuration
@Component
public class GoogleTokenConfig {

    private static final HttpTransport transport = new NetHttpTransport();
    private static final JsonFactory jsonFactory = new JacksonFactory();
    //Google project client id
    private static String CLIENT_ID;
    
    @Autowired
    public GoogleTokenConfig(@Value("${spring.social.google.clients}") String CLIENT_ID) {
        System.out.println("Clint id" + CLIENT_ID);
        GoogleTokenConfig.CLIENT_ID = CLIENT_ID;
    }

    /**
     *
     * @param idTokenString
     * @return Payload if verified
     * @throws Exception
     */
    public static Payload verifyToken(String idTokenString) throws Exception {
        final GoogleIdTokenVerifier verifier
                = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                        .setIssuers(Arrays.asList("https://accounts.google.com", "accounts.google.com"))
                        .setAudience(Collections.singletonList(CLIENT_ID))
                        .build();
        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(idTokenString);
        } catch (IllegalArgumentException e) {
        }
        if (idToken == null) {
            return null;
        }
        return idToken.getPayload();
    }
}
