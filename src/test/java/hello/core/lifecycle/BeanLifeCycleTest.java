package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = context.getBean(NetworkClient.class);
        System.out.println(client);
        context.close();
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("test");
            return networkClient;
        }
    }
}
