package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtoTypeTest {

    @Test
    void ProtoTypeBeanFind(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProtoTypeBean.class);

        ProtoTypeBean protoTypeBean1 = context.getBean(ProtoTypeBean.class);
        ProtoTypeBean protoTypeBean2 = context.getBean(ProtoTypeBean.class);

        System.out.println("protoTypeBean1 = " + protoTypeBean1);
        System.out.println("protoTypeBean2 = " + protoTypeBean2);

        assertThat(protoTypeBean1).isNotSameAs(protoTypeBean2);


        context.close();
    }

    @Scope("prototype")
    static class ProtoTypeBean{
        @PostConstruct
        public void init(){
            System.out.println("ProtoTypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("ProtoTypeBean.destroy");
        }
    }
}
