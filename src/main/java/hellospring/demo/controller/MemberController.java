package hellospring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hellospring.demo.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
