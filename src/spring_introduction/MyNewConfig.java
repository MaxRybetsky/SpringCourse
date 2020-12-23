package spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:myApp.properties")
public class MyNewConfig {
    @Bean
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    @Scope("prototype")
    public Person personBean() {
        return new Person(catBean());
    }
}
