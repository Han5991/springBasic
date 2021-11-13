package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StateFullServiceTest {

    @Test
    void StateFullServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StateFullService stateFullService1 = ac.getBean(StateFullService.class);
        StateFullService stateFullService2 = ac.getBean(StateFullService.class);

        //TgreadA: A사용자 10000원 주문
        int userA = stateFullService1.order("userA", 10000);

        //TgreadA: B사용자 20000원 주문
        int userB = stateFullService2.order("userB", 20000);

        System.out.println("price = " + userA);

        assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StateFullService stateFullService() {
            return new StateFullService();
        }
    }
}
