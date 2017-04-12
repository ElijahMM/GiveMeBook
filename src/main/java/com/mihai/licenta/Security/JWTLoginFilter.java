package com.mihai.licenta.Security;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mihai on 30.03.2017.
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {


    public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
//        LoginUser creds = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);
//        System.out.println(creds.getUsername() +" " + creds.getPassword());
//        System.out.println(request);
//        UsernamePasswordAuthenticationToken a = new UsernamePasswordAuthenticationToken(
//                creds.getUsername(),
//                creds.getPassword(),
//                Collections.emptyList()
//        );
//        CustomAuthenticationManager customAuthenticationManager = new CustomAuthenticationManager();
//        return customAuthenticationManager.authenticate(a);
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(response, authResult.getName());
    }
}
