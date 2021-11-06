package hello.core.order;

public interface OrderService {
    Order creteOrder(Long memberId, String itemName, int itemPrice);
}
