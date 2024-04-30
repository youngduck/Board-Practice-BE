package hellospring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import hellospring.demo.dto.Auth;
import hellospring.demo.service.AuthService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Signup")

public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("")
    public ResponseEntity<?> postMethodName(@RequestBody Auth auth) {
        
        authService.createAuth(auth);
        

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
