package ro.oss.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by daniel on 08.10.2017.
 */
public class AppMain {

    public static final Logger log = LoggerFactory.getLogger(AppMain.class);

    public static void main(String args[]) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        JavaBean bean = context.getBean(JavaBean.class);
        log.info(bean.sayHello("Spring 5"));

        GroovyBean groovyBean = context.getBean(GroovyBean.class);
        log.info(groovyBean.bePolite("ion"));

        TestBean testBean = context.getBean(TestBean.class);
        log.info(testBean.hello("academie"));

        context.close();
    }
}
