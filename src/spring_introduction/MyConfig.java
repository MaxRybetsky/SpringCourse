package spring_introduction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("spring_introduction")
@PropertySource("classpath:myApp.properties")
public class MyConfig {
}
