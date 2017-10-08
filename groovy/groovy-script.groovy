import org.springframework.beans.factory.annotation.Autowired
import ro.oss.spring.GroovyBean
import ro.oss.spring.JavaBean

class GroovyScript implements GroovyBean{

    @Autowired
    private JavaBean javaBean;

    @Override
    String getBeanName() {
        return "groovy-bean"
    }

    @Override
    String bePolite(String name) {
        return "from groovy: " + javaBean.sayHello(name);
    }
}