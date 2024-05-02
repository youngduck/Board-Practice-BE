package hellospring.demo.service;

import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import hellospring.demo.dao.MemberMemoryRepository;
import hellospring.demo.dao.MemberRepository;
import hellospring.demo.domain.Member;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원가입
     */
    public Long join(Member member) {

        validateDupilicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDupilicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /*
     * 전체회원조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /*
     * 세부회원조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
