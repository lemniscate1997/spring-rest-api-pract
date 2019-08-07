/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.security.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.rest.security.model.User;
import com.rest.security.service.UserDetailsServices;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
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
@Component
public class AccessTokenGenerator {
    @Autowired
    private UserDetailsServices userDetailsService;
    
    @Autowired
    private AuthorizationServerTokenServices tokenServices;
    
    public OAuth2AccessToken generateAccessToken(GoogleIdToken.Payload payload) {
        HashMap<String, String> authorizationParameters = new HashMap<String, String>();
        authorizationParameters.put("scope", "read");
        authorizationParameters.put("username", payload.getEmail());
        authorizationParameters.put("client_id", payload.getEmail());

        Set<String> responseType = new HashSet<String>();
        responseType.add("password");

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        
        Set<String> scopes = new HashSet<String>();
        scopes.add("read");
        scopes.add("write");

        OAuth2Request authorizationRequest = new OAuth2Request(
                authorizationParameters, "client",
                authorities, true, scopes, null, "",
                responseType, null);

        User userPrincipal = userDetailsService.loadUserByEmail(payload.getEmail());

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userPrincipal.getUsername(), null, authorities);

        OAuth2Authentication authenticationRequest = new OAuth2Authentication(
                authorizationRequest, authenticationToken);
        authenticationRequest.setAuthenticated(true);

        OAuth2AccessToken accessToken = tokenServices
                .createAccessToken(authenticationRequest);

        return accessToken;

    }
}
