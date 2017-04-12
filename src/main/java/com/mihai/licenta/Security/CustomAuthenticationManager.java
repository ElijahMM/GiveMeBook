package com.mihai.licenta.Security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Collections;

/**
 * Created by mihai on 04.04.2017.
 */
public class CustomAuthenticationManager implements AuthenticationManager {

    public CustomAuthenticationManager() {

    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());

    }
}
