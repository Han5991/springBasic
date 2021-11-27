package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithProtoTypeTest1 {
    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProtoTypeBean.class);

        ProtoTypeBean bean = context.getBean(ProtoTypeBean.class);
        bean.addCount();
        assertThat(bean.getCount()).isSameAs(1);

        ProtoTypeBean bean1 = context.getBean(ProtoTypeBean.class);
        bean1.addCount();
        assertThat(bean1.getCount()).isSameAs(1);
    }

    @Test
    void singleClientUseProtoType() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClientBean.class, ProtoTypeBean.class);
        ClientBean clientBean1 = context.getBean(ClientBean.class);
        int logic = clientBean1.logic();

        assertThat(logic).isEqualTo(1);
        ClientBean clientBean2 = context.getBean(ClientBean.class);
        int logic1 = clientBean2.logic();
        assertThat(logic1).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean {

        @Autowired
        private Provider<ProtoTypeBean> provider;

        public int logic() {
            ProtoTypeBean providerObject = provider.get(); // getObject 프로토 타입을 찾아주는 매서드
            providerObject.addCount();
            return providerObject.getCount();
        }
    }

    @Scope("prototype")
    static class ProtoTypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("ProtoTypeBean.init : " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("ProtoTypeBean.destroy");
        }
    }
}
