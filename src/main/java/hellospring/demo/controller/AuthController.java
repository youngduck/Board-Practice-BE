package hellospring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import hellospring.demo.dto.Auth;
import hellospring.demo.service.AuthService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/")

public class AuthController {
    @Autowired
    AuthService authService;

    // ANCHOR - 회원가입
    @PostMapping("Signup")
    public ResponseEntity<?> postMethodName(@RequestBody Auth auth) {

        authService.createAuth(auth);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // ANCHOR - 로그인

    @PostMapping("Login")
    public ResponseEntity<?> postLogin(@RequestBody Auth auth) {
        authService.postLogin(auth);

        // NOTE - 객체형식반환, 로그인 값비교 로직 추가해야함
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
