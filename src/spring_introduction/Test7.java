package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test7 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyNewConfig.class);
        Person person = context.getBean("personBean", Person.class);
        person.printInfo();
        person.callYourPet();
        Person person1 = context.getBean("personBean", Person.class);
        person1.printInfo();
        person1.callYourPet();
    }
}
