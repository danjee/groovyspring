package ro.oss.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by daniel on 08.10.2017.
 */
public class AppMain {

    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        JavaBean bean = context.getBean(JavaBean.class);
        System.out.println(bean.sayHello("Spring 4"));

        GroovyBean groovyBean = context.getBean(GroovyBean.class);
        System.out.println(groovyBean.bePolite("ion"));

        context.close();
    }
}
