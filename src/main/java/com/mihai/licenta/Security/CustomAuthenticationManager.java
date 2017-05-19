package com.mihai.licenta.Security;

import com.mihai.licenta.Models.DBModels.User;
import com.mihai.licenta.Service.UserService;
import com.mihai.licenta.Utils.SpringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Collections;

/**
 * Created by mihai on 04.04.2017.
 */
public class CustomAuthenticationManager implements AuthenticationManager {

    UserService userService;

    public CustomAuthenticationManager() {
        userService = SpringUtils.getBean(UserService.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        User user = userService.loginUser(email, password);

        if (user == null) {
            throw new BadCredentialsException("Invalid email or password");
        }
        return new UsernamePasswordAuthenticationToken(email, password, Collections.emptyList());

    }
}
