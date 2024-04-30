package hellospring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hellospring.demo.dao.AuthRepository;
import hellospring.demo.dto.Auth;


@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;

    public void createAuth(Auth auth){
        authRepository.createAuth(auth);
    }
}
