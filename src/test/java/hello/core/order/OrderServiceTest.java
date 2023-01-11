package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerivceImpl;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService = new MemberSerivceImpl();
    }

    @Test
    void 할인테스트() {
        //given
        Long memberId = 1L;
        Member member = new Member(1L, "테스트아이디", Grade.VIP);
        memberService.join(member);

        //when
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.createOrder(memberId, "테스트상품", 40000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

        //then

    }


}
