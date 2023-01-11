package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDisCountPolicy implements DiscountPolicy{

    private int disCountFixAmout = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return disCountFixAmout;
        } else if (member.getGrade() == Grade.BASIC){
            return 0;
        }
        return 0;
    }
}
