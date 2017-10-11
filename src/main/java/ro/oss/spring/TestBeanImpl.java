package ro.oss.spring;

import org.springframework.stereotype.Component;

/**
 * Created by daniel on 11.10.2017.
 */
@Component
public class TestBeanImpl implements TestBean {

    @Groovy
    private CustomBean customBean;

    public String hello(String name) {
        return customBean.getCustomResult(name);
    }
}
