package com.example.aquaone.web.controller;

import com.example.aquaone.LoggedUser;
import com.example.aquaone.View;
import com.example.aquaone.service.user.UserService;
import com.example.aquaone.to.UserTo;
import com.example.aquaone.util.TokenUtil;
import com.example.aquaone.util.UserUtil;
import com.example.aquaone.web.AuthenticationRequest;
import com.example.aquaone.web.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/rest/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationResponse login(@Valid @RequestBody AuthenticationRequest authenticationRequest) {

        AuthenticationResponse response = new AuthenticationResponse();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),// But we are use user email!
                            authenticationRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());// But we are use user email!

        String token = tokenUtil.generateToken(userDetails);
        response.setToken(token);
        LoggedUser loggedUser = userService.loadUserByUsername(authenticationRequest.getUsername());
        response.setUser(loggedUser);
        return response;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout() {

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationResponse createWithLocation(@Validated(View.Web.class) @RequestBody UserTo user) {
        System.out.println("AAAAAAAAA"+user);


        userService.create(UserUtil.createNewFromTo(user));
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(user.getEmail(), user.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),// But we are use user email!
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());// But we are use user email!
        String token = tokenUtil.generateToken(userDetails);

        AuthenticationResponse response = new AuthenticationResponse(token);
        LoggedUser loggedUser = userService.loadUserByUsername(authenticationRequest.getUsername());
        response.setUser(loggedUser);

        return response;
    }
}
