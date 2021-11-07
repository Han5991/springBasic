package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        memberService.join(member);
        //when
        Order order = orderService.creteOrder(member.getId(), "itemA", 20000);
        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }

    @Test
    @DisplayName("BASIC는 0% 할인이 적용되어야 한다.")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        memberService.join(member);
        //when
        Order order = orderService.creteOrder(member.getId(), "itemA", 20000);
        //then
        assertThat(order.getDiscountPrice()).isEqualTo(0);
    }
}