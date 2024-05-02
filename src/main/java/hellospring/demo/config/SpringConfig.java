package hellospring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hellospring.demo.dao.MemberMemoryRepository;
import hellospring.demo.dao.MemberRepository;
import hellospring.demo.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberMemoryRepository();
    }

}
