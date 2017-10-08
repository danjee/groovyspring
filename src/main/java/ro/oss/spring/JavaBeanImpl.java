package ro.oss.spring;

import org.springframework.stereotype.Component;

/**
 * Created by daniel on 08.10.2017.
 */

@Component
public class JavaBeanImpl implements JavaBean {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
