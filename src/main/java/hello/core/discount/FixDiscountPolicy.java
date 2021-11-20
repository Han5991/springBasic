package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //1000원

    @Override
    public int discount(Member member, int price) {
        return (member.getGrade() == Grade.VIP) ? discountFixAmount : 0;
    }
}