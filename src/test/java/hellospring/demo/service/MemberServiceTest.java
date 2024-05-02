package hellospring.demo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hellospring.demo.dao.MemberMemoryRepository;
import hellospring.demo.domain.Member;

public class MemberServiceTest {

    MemberService memberService;
    MemberMemoryRepository memberRepository;

    @BeforeEach
    public void BeforeEach() {
        memberRepository = new MemberMemoryRepository();
        memberService = new MemberService(memberRepository);// memberSerivce 생성시마다 다른인스턴스가 생성되는것을 방지 = di dependency
                                                            // injection
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hi");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // try {
        // memberService.join(member2);
        // fail("예외가 발생해야합니다.");
        // } catch (IllegalStateException e) {
        // Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // }

        // then

    }

    @Test
    void testFindOne() {

    }

    @Test
    void testFindMembers() {

    }

}
