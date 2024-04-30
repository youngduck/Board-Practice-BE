package hellospring.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import hellospring.demo.dto.Auth;

@Repository
@Mapper
public interface AuthRepository {

    public void createAuth(Auth auth);
    
}
