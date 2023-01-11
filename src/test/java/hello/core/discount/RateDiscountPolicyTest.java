package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("등급 VIP는 10프로 할인 적용")
    void grade_vip() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int result = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("등급 BASIC 이면 할인 적용 안 됨")
    void grade_basic() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        //when
        int result = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(result).isEqualTo(0);
    }

}