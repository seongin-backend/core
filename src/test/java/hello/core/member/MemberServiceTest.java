package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    void 세팅() {
        memberService = new MemberSerivceImpl();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
         assertThat(member).isEqualTo(findMember); //멤버객체비교
        assertThat(member.getName()).isEqualTo(findMember.getName()); //멤버아이디비교
    }
}
