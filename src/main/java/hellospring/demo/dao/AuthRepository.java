package hellospring.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import hellospring.demo.dto.Auth;

@Repository
@Mapper
public interface AuthRepository {

    // ANCHOR - 회원가입
    void createAuth(Auth auth);

    // ANCHOR - 로그인
    Auth postLogin(Auth auth);

}
