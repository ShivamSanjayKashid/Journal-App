package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.service.UserDetailsServiceImpl;
import com.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return"ok";
    }

    @PostMapping("/create-user")
    public void signup(@RequestBody User user) {
        userService.saveNewUser(user);
    }

    @Autowired
    public PublicController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User user) {
//        try{
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
//            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
////            String jwt = jwtUtil.generateToken(userDetails.getUsername());
////            return new ResponseEntity<>(jwt, HttpStatus.OK);
//        }catch (Exception e){
////            log.error("Exception occurred while createAuthenticationToken ", e);
//            return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
//        }
//    }

}