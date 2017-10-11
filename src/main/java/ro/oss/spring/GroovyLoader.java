package ro.oss.spring;

import groovy.util.GroovyScriptEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.File;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

/**
 * Created by daniel on 08.10.2017.
 */
@Component
public class GroovyLoader implements ApplicationListener {

    @Autowired
    private ApplicationContext context;

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        GroovyScriptEngine groovyScriptEngine = null;
        try {
            groovyScriptEngine = new GroovyScriptEngine(new File("groovy").getAbsolutePath());
            Class<GroovyBean> clazz = groovyScriptEngine.loadScriptByName("groovy-script.groovy");
            GroovyBean groovyBean = clazz.newInstance();
            BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
            genericBeanDefinition.setBeanClass(clazz);
            genericBeanDefinition.setScope(SCOPE_SINGLETON);
            beanDefinitionRegistry.registerBeanDefinition(groovyBean.getBeanName(), genericBeanDefinition);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
