package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memeberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memeberRepository, DiscountPolicy discountPolicy) {
        this.memeberRepository = memeberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order creteOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memeberRepository.findById(memberId);
        int discount = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discount);
    }
}
