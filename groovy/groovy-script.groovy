import org.springframework.beans.factory.annotation.Autowired
import ro.oss.spring.CustomBean
import ro.oss.spring.GroovyBean
import ro.oss.spring.JavaBean

class GroovyScript implements GroovyBean, CustomBean{

    @Autowired
    private JavaBean javaBean

    @Override
    String getBeanName() {
        return "groovy-bean"
    }

    @Override
    String bePolite(String name) {
        return "from groovy: " + javaBean.sayHello(name)
    }

    @Override
    String getCustomResult(String argument) {
        return "a custom result from groovy " + argument
    }
}